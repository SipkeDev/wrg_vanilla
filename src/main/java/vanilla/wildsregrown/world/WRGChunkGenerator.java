package vanilla.wildsregrown.world;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sipke.World;
import com.sipke.api.features.structures.StructureSpawn;
import com.sipke.api.geology.Stratum;
import com.sipke.api.grid.WRGConfig;
import com.sipke.generator.context.LocalAreaContext;
import com.sipke.math.MathUtil;
import com.sipke.registeries.WorldRegistries;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.structure.StructurePiece;
import net.minecraft.structure.StructureSet;
import net.minecraft.structure.StructureStart;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.RandomSeed;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.PalettedContainer;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.HeightContext;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.StructureWeightSampler;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.chunk.placement.StructurePlacement;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import net.minecraft.world.gen.noise.NoiseConfig;
import net.minecraft.world.gen.structure.Structure;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.IdentifiableRegistery;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.api.chunk.SetableSection;
import vanilla.wildsregrown.registries.Biomes;
import vanilla.wildsregrown.world.biomes.WRGBiomeProvider;
import vanilla.wildsregrown.world.decorator.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.sipke.WorldConstants.chunkSize;

public final class WRGChunkGenerator extends ChunkGenerator {

    public static final MapCodec<WRGChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(
                            (generator) -> generator.biomeSource),
                    ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings")
                            .forGetter((generator) -> generator.settings)
            ).apply(instance, instance.stable(WRGChunkGenerator::new)));

    private final RegistryEntry<ChunkGeneratorSettings> settings;
    private final BaseDecorator decorator;
    private final BedrockDecorator bedrockDecorator;
    private final FeatureDecorator featureDecorator;
    private final FloraDecorator floraDecorator;
    private final Supplier<AquiferSampler.FluidLevelSampler> fluidLevelSampler;

    public WRGChunkGenerator(BiomeSource source, RegistryEntry<ChunkGeneratorSettings> settings) {
        super(source);
        this.settings = settings;
        this.decorator = new BaseDecorator(this);
        this.bedrockDecorator = new BedrockDecorator();
        this.featureDecorator = new FeatureDecorator(this);
        this.floraDecorator = new FloraDecorator(this);
        this.fluidLevelSampler = Suppliers.memoize(() -> createFluidLevelSampler(settings.value()));
    }

    @Override
    public void generateFeatures(StructureWorldAccess world, Chunk chunk, StructureAccessor structureAccessor) {
        featureDecorator.apply(world, chunk);
        floraDecorator.apply(world, chunk);
        super.generateFeatures(world, chunk, structureAccessor);
    }

        @Override
    public void setStructureStarts(DynamicRegistryManager registryManager, StructurePlacementCalculator placementCalculator, StructureAccessor structureAccessor, Chunk chunk, StructureTemplateManager structureTemplateManager, RegistryKey<net.minecraft.world.World> dimension) {
        //super.setStructureStarts(registryManager, placementCalculator, structureAccessor, chunk, structureTemplateManager, dimension);
        if (!SharedConstants.DISABLE_STRUCTURES) {

            //Positions
            ChunkPos chunkPos = chunk.getPos();
            ChunkSectionPos chunkSectionPos = ChunkSectionPos.from(chunk);

            com.sipke.api.chunk.Chunk noiseChunk = getWorld().generator.getNoiseChunk(chunkPos.getStartX(), chunkPos.getStartZ());
            if (noiseChunk.hasSpawnRef()) {
                for (StructureSpawn spawn : noiseChunk.getSpawnRefs()) {
                    for (StructureSet entry : registryManager.getOrThrow(RegistryKeys.STRUCTURE_SET)) {
                        RegistryEntry<Structure> ref = entry.structures().getFirst().structure();
                        if (ref.getIdAsString().contains(spawn.getStructure().name)) {

                            //WRGVanilla.LOGGER.info("entry:" + ref.getIdAsString());
                            List<StructureSet.WeightedEntry> list = entry.structures();

                            //Check if position is already taken
                            for (StructureSet.WeightedEntry weightedEntry : list) {
                                StructureStart structureStart = structureAccessor.getStructureStart(chunkSectionPos, weightedEntry.structure().value(), chunk);
                                if (structureStart != null && structureStart.hasChildren()) {
                                    return;
                                }
                            }

                            if (list.size() == 1) {
                                //Single structure
                                this.trySetStructureStart(entry.structures().getFirst(), structureAccessor, registryManager, placementCalculator.getNoiseConfig(), structureTemplateManager, placementCalculator.getStructureSeed(), chunk, chunkPos, chunkSectionPos, dimension);
                            } else {
                                //Multi/jigsaw struct
                                ArrayList<StructureSet.WeightedEntry> arrayList = new ArrayList<>(list);
                                ChunkRandom chunkRandom = new ChunkRandom(new CheckedRandom(0L));
                                chunkRandom.setCarverSeed(placementCalculator.getStructureSeed(), chunkPos.x, chunkPos.z);

                                //Set base value?
                                int i = 0;
                                for (StructureSet.WeightedEntry weightedEntry2 : arrayList) {
                                    i += weightedEntry2.weight();
                                }

                                while (!arrayList.isEmpty()) {

                                    //Shuffle the values?
                                    int j = chunkRandom.nextInt(i);
                                    int k = 0;
                                    for (StructureSet.WeightedEntry weightedEntry3 : arrayList) {
                                        j -= weightedEntry3.weight();
                                        if (j < 0) {
                                            break;
                                        }
                                        ++k;
                                    }

                                    StructureSet.WeightedEntry weightedEntry4 = arrayList.get(k);
                                    if (this.trySetStructureStart(weightedEntry4, structureAccessor, registryManager, placementCalculator.getNoiseConfig(), structureTemplateManager, placementCalculator.getStructureSeed(), chunk, chunkPos, chunkSectionPos, dimension)) {
                                        return;
                                    }

                                    arrayList.remove(k);
                                    i -= weightedEntry4.weight();
                                }
                            }
                        }else {
                            //WRGVanilla.LOGGER.info("SkIPPED: " + entry.structures().getFirst().structure().getIdAsString() + " / " + spawn.getStructure().name);
                        }

                    }
                }
            }
        }
    }

    private boolean trySetStructureStart(StructureSet.WeightedEntry weightedEntry, StructureAccessor structureAccessor, DynamicRegistryManager dynamicRegistryManager, NoiseConfig noiseConfig, StructureTemplateManager structureManager, long seed, Chunk chunk, ChunkPos pos, ChunkSectionPos sectionPos, RegistryKey<net.minecraft.world.World> dimension) {
        Structure structure = weightedEntry.structure().value();
        int i = getStructureReferences(structureAccessor, chunk, sectionPos, structure);
        RegistryEntryList<Biome> registryEntryList = structure.getValidBiomes();
        Objects.requireNonNull(registryEntryList);
        Predicate<RegistryEntry<Biome>> predicate = registryEntryList::contains;
        StructureStart structureStart = structure.createStructureStart(weightedEntry.structure(), dimension, dynamicRegistryManager, this, this.biomeSource, noiseConfig, structureManager, seed, pos, i, chunk, predicate);
        if (structureStart.hasChildren()) {
            structureAccessor.setStructureStart(sectionPos, structure, structureStart, chunk);
            return true;
        } else {
            return false;
        }
    }

    private static int getStructureReferences(StructureAccessor structureAccessor, Chunk chunk, ChunkSectionPos sectionPos, Structure structure) {
        StructureStart structureStart = structureAccessor.getStructureStart(sectionPos, structure, chunk);
        return structureStart != null ? structureStart.getReferences() : 0;
    }

    @Override
    public CompletableFuture<Chunk> populateBiomes(NoiseConfig noiseConfig, Blender blender, StructureAccessor structureAccessor, Chunk chunk) {
        //Moved to fill populate Noise
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> getCodec() {
        return CODEC;
    }

    @Override
    public void carve(ChunkRegion chunkRegion, long seed, NoiseConfig noiseConfig, BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk) {
        //invalid
    }

    @Override
    public void buildSurface(ChunkRegion region, StructureAccessor structures, NoiseConfig noiseConfig, Chunk chunk) {
        if (!SharedConstants.isOutsideGenerationArea(chunk.getPos()) && !SharedConstants.DISABLE_SURFACE) {
            HeightContext heightContext = new HeightContext(this, region);
            this.buildSurface(chunk, heightContext, noiseConfig, structures, region.getBiomeAccess(), region.getRegistryManager().getOrThrow(RegistryKeys.BIOME), Blender.getBlender(region));
        }
    }

    @VisibleForTesting
    public void buildSurface(Chunk chunk, HeightContext heightContext, NoiseConfig noiseConfig, StructureAccessor structureAccessor, BiomeAccess biomeAccess, Registry<Biome> biomeRegistry, Blender blender) {
        ChunkNoiseSampler chunkNoiseSampler = chunk.getOrCreateChunkNoiseSampler((chunkx) -> this.createChunkNoiseSampler(chunkx, structureAccessor, blender, noiseConfig));
        ChunkGeneratorSettings chunkGeneratorSettings = this.settings.value();
        noiseConfig.getSurfaceBuilder().buildSurface(noiseConfig, biomeAccess, biomeRegistry, chunkGeneratorSettings.usesLegacyRandom(), heightContext, chunk, chunkNoiseSampler, chunkGeneratorSettings.surfaceRule());
    }

    private ChunkNoiseSampler createChunkNoiseSampler(Chunk chunk, StructureAccessor world, Blender blender, NoiseConfig noiseConfig) {
        return ChunkNoiseSampler.create(chunk, noiseConfig, StructureWeightSampler.createStructureWeightSampler(world, chunk.getPos()), this.settings.value(), fluidLevelSampler.get(), blender);
    }

    @Override
    public int getWorldHeight() {
        WRGConfig config = getWorld().getConfig();
        return (int)(config.continentFactor() + config.landformFactor() + config.biomeFactor()) + 1;
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {
        populateBiomes(chunk);
        decorator.apply(chunk);
        bedrockDecorator.apply(chunk);
        return CompletableFuture.completedFuture(chunk);
    }

    public void populateBiomes(Chunk chunk) {
        ChunkPos chunkPos = chunk.getPos();
        int x = chunkPos.getStartX();//BiomeCoords.fromBlock(chunkPos.getStartX());
        int z = chunkPos.getStartZ();//BiomeCoords.fromBlock(chunkPos.getStartZ());

        com.sipke.api.chunk.Chunk noiseChunk = getWorld().generator.getNoiseChunk(x, z);

        if (biomeSource instanceof WRGBiomeProvider provider) {
            int center = 8*chunkSize+8;
            PalettedContainer<RegistryEntry<Biome>> container = chunk.getSection(0).getBiomeContainer().slice();
            PalettedContainer<RegistryEntry<Biome>> cave = chunk.getSection(0).getBiomeContainer().slice();
            for (int k = 0; k < 4; k++) {
                for (int m = 0; m < 4; m++) {
                    int idx = (k*4) * chunkSize + (m*4);
                    if (WorldRegistries.BIOMES.get(noiseChunk.getTile(idx).biome) instanceof IdentifiableRegistery id) {
                        RegistryEntry<Biome> entry = provider.getMap().get(id.getIdentifier());
                        for (int l = 0; l < 4; l++) {
                            container.swapUnsafe(k, l, m, entry);
                        }
                    }
                }
            }
            Identifier caveIdentifier = noiseChunk.getTile(center).flow > 0.5 ? ((VanillaBiome) Biomes.lush_caves.getInstance()).getIdentifier() : ((VanillaBiome) Biomes.dripstone_caves.getInstance()).getIdentifier();
            RegistryEntry<Biome> entry = provider.getMap().get(caveIdentifier);
            for (int k = 0; k < 4; k++) {
                for (int m = 0; m < 4; m++) {
                    for (int l = 0; l < 4; l++) {
                        cave.swapUnsafe(k, l, m, entry);
                    }
                }
            }
            for (ChunkSection section0 : chunk.getSectionArray()) {
                ((SetableSection) section0).wrg_vanilla$set(cave);
            }
            int height = (int) noiseChunk.getTile(center).height;
            int index = chunk.getSectionIndex(height);
            if (index < 1 || index > 64) {
                index = 1;
            }
            if (index < chunk.getSectionArray().length) {
                ((SetableSection) chunk.getSection(index)).wrg_vanilla$set(container);
            }
            if (index + 1 < chunk.getSectionArray().length) {
                ((SetableSection) chunk.getSection(index + 1)).wrg_vanilla$set(container);
            }
            if (index - 1 > 0) {
                ((SetableSection) chunk.getSection(index - 1)).wrg_vanilla$set(container);
            }
            if (index - 2 > 0) {
                ((SetableSection) chunk.getSection(index - 2)).wrg_vanilla$set(container);
            }
        }
    }

    @Override
    public int getSeaLevel() {
        return (int) getWorld().getConfig().waterLevel();
    }

    @Override
    public int getMinimumY() {
        return 0;
    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world, NoiseConfig noiseConfig) {
        return getWorld().generator.getColumn(x, z).getStrata().getLast().getCeil();
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig) {
        List<Stratum> strata = getWorld().generator.getColumn(x, z).getStrata();
        int max = strata.getLast().getCeil()+1;
        BlockState[] states = new BlockState[max];
        int y = 0;
        for (Stratum stratum : strata){
            for (int i = 0; i < stratum.depth; i++) {
                if (stratum.getRegistry() instanceof IdentifiableRegistery id) {
                    Block block = Registries.BLOCK.get(id.getIdentifier());
                    states[MathUtil.min(y, max-1)] = block.getDefaultState();
                    y++;
                }
            }
        }
        for (int i = 0; i < states.length; i++) {
            BlockState state = states[i];
            if (state == null){
                states[i] = Blocks.STONE.getDefaultState();
            }
        }
        return new VerticalBlockSample(0, states);
    }


    @Override
    public void appendDebugHudText(List<String> text, NoiseConfig noiseConfig, BlockPos pos) {}

    public World getWorld() {
        return World.getInstance();
    }

    @Override
    public void populateEntities(ChunkRegion region) {
        if (!(this.settings.value()).mobGenerationDisabled()) {
            ChunkPos chunkPos = region.getCenterPos();
            RegistryEntry<Biome> registryEntry = region.getBiome(chunkPos.getStartPos().withY(region.getTopYInclusive()));
            if (registryEntry != null) {
                ChunkRandom chunkRandom = new ChunkRandom(new CheckedRandom(RandomSeed.getSeed()));
                chunkRandom.setPopulationSeed(region.getSeed(), chunkPos.getStartX(), chunkPos.getStartZ());
                SpawnHelper.populateEntities(region, registryEntry, chunkPos, chunkRandom);
            }
        }
    }

    private static AquiferSampler.FluidLevelSampler createFluidLevelSampler(ChunkGeneratorSettings settings) {
        AquiferSampler.FluidLevel fluidLevel = new AquiferSampler.FluidLevel(-54, Blocks.LAVA.getDefaultState());
        int i = settings.seaLevel();
        AquiferSampler.FluidLevel fluidLevel2 = new AquiferSampler.FluidLevel(i, settings.defaultFluid());
        AquiferSampler.FluidLevel fluidLevel3 = new AquiferSampler.FluidLevel(DimensionType.MIN_HEIGHT * 2, Blocks.AIR.getDefaultState());
        return (x, y, z) -> {
            if (SharedConstants.DISABLE_FLUID_GENERATION) {
                return fluidLevel3;
            } else {
                return y < Math.min(-54, i) ? fluidLevel : fluidLevel2;
            }
        };
    }

}
