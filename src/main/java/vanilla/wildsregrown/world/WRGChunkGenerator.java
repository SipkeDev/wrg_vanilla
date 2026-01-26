package vanilla.wildsregrown.world;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sipke.World;
import com.sipke.WorldConstants;
import com.sipke.registeries.WorldRegistries;
import net.minecraft.SharedConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
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
    private final Supplier<AquiferSampler.FluidLevelSampler> fluidLevelSampler;

    public WRGChunkGenerator(BiomeSource source, RegistryEntry<ChunkGeneratorSettings> settings) {
        super(source);
        this.settings = settings;
        this.decorator = new BaseDecorator(this);
        this.bedrockDecorator = new BedrockDecorator();
        this.fluidLevelSampler = Suppliers.memoize(() -> createFluidLevelSampler(settings.value()));
    }

    @Override
    public void setStructureStarts(DynamicRegistryManager registryManager, StructurePlacementCalculator placementCalculator, StructureAccessor structureAccessor, Chunk chunk, StructureTemplateManager structureTemplateManager, RegistryKey<net.minecraft.world.World> dimension) {
        //super.setStructureStarts(registryManager, placementCalculator, structureAccessor, chunk, structureTemplateManager, dimension);
        if (!SharedConstants.DISABLE_STRUCTURES) {
            ChunkPos chunkPos = chunk.getPos();
            ChunkSectionPos chunkSectionPos = ChunkSectionPos.from(chunk);
            NoiseConfig noiseConfig = placementCalculator.getNoiseConfig();
            placementCalculator.getStructureSets().forEach((structureSet) -> {
                StructurePlacement structurePlacement = (structureSet.value()).placement();
                List<StructureSet.WeightedEntry> list = (structureSet.value()).structures();

                //WRGVanilla.LOGGER.info("MARK 1");
                for(StructureSet.WeightedEntry weightedEntry : list) {

                    //WRGVanilla.LOGGER.info("MARK : " + weightedEntry);
                    StructureStart structureStart = structureAccessor.getStructureStart(chunkSectionPos, weightedEntry.structure().value(), chunk);
                    if (structureStart != null && structureStart.hasChildren()) {
                        return;
                    }
                }

                //WRGVanilla.LOGGER.info("MARK 2");
                if (structurePlacement.shouldGenerate(placementCalculator, chunkPos.x, chunkPos.z)) {
                    if (list.size() == 1) {
                        //WRGVanilla.LOGGER.info("MARK 3");
                        this.trySetStructureStart(list.getFirst(), structureAccessor, registryManager, noiseConfig, structureTemplateManager, placementCalculator.getStructureSeed(), chunk, chunkPos, chunkSectionPos, dimension);
                    } else {

                        //WRGVanilla.LOGGER.info("MARK 4");
                        ArrayList<StructureSet.WeightedEntry> arrayList = new ArrayList(list.size());
                        arrayList.addAll(list);
                        ChunkRandom chunkRandom = new ChunkRandom(new CheckedRandom(0L));
                        chunkRandom.setCarverSeed(placementCalculator.getStructureSeed(), chunkPos.x, chunkPos.z);
                        int i = 0;

                        for(StructureSet.WeightedEntry weightedEntry2 : arrayList) {
                            i += weightedEntry2.weight();
                        }

                        while(!arrayList.isEmpty()) {
                            int j = chunkRandom.nextInt(i);
                            int k = 0;

                            for(StructureSet.WeightedEntry weightedEntry3 : arrayList) {
                                j -= weightedEntry3.weight();
                                if (j < 0) {
                                    break;
                                }

                                ++k;
                            }

                            StructureSet.WeightedEntry weightedEntry4 = (StructureSet.WeightedEntry)arrayList.get(k);
                            if (this.trySetStructureStart(weightedEntry4, structureAccessor, registryManager, noiseConfig, structureTemplateManager, placementCalculator.getStructureSeed(), chunk, chunkPos, chunkSectionPos, dimension)) {
                                return;
                            }

                            arrayList.remove(k);
                            i -= weightedEntry4.weight();
                        }

                    }
                }
            });
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
    public void generateFeatures(StructureWorldAccess world, Chunk chunk, StructureAccessor structureAccessor) {
        super.generateFeatures(world, chunk, structureAccessor);
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
        return WorldConstants.worldHeight;
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {

        populate(chunk);

        decorator.apply(chunk);
        bedrockDecorator.apply(chunk);
        return CompletableFuture.completedFuture(chunk);
    }

    public void populate(Chunk chunk){
        ChunkPos chunkPos = chunk.getPos();
        int x = chunkPos.getStartX();//BiomeCoords.fromBlock(chunkPos.getStartX());
        int z = chunkPos.getStartZ();//BiomeCoords.fromBlock(chunkPos.getStartZ());

        com.sipke.api.chunk.Chunk noiseChunk = getWorld().generator.getNoiseChunk(x, z);

        if (biomeSource instanceof WRGBiomeProvider provider) {
            for (int i = 0; i < chunkSize; i+=4) {
                for (int j = 0; j < chunkSize; j+=4) {

                    PalettedContainer<RegistryEntry<Biome>> container = chunk.getSection(0).getBiomeContainer().slice();
                    PalettedContainer<RegistryEntry<Biome>> cave = chunk.getSection(0).getBiomeContainer().slice();
                    for (int k = 0; k < 4; k++) {
                        for (int m = 0; m < 4; m++) {
                            int idx = (i + k) * chunkSize + (j + m);
                            if (WorldRegistries.BIOMES.get(noiseChunk.getTile(idx).biome) instanceof IdentifiableRegistery id) {
                                RegistryEntry<Biome> entry = provider.getMap().get(id.getIdentifier());
                                for (int l = 0; l < 4; l++) {
                                    container.swapUnsafe(k, l, m, entry);
                                }
                            }
                        }
                    }
                    Identifier caveIdentifier = noiseChunk.getTile((i + 1) * chunkSize + (j + 1)).flow > 0.5 ? ((VanillaBiome) Biomes.lush_caves.getInstance()).getIdentifier() : ((VanillaBiome) Biomes.dripstone_caves.getInstance()).getIdentifier();
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
                    int height = (int) noiseChunk.getTile((i + 1) * chunkSize + (j + 1)).height;
                    int index = chunk.getSectionIndex(height);
                    if (index < 1 || index > 64) {
                        index = 1;
                    }
                    ((SetableSection) chunk.getSection(index)).wrg_vanilla$set(container);
                    ((SetableSection) chunk.getSection(index - 1)).wrg_vanilla$set(container);
                    ((SetableSection) chunk.getSection(index - 2)).wrg_vanilla$set(container);
                }
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
        return (int) getWorld().generator.getHeightMapPos(x, z).getHeight();
    }

    @Override
    public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world, NoiseConfig noiseConfig) {
        int y = world.getHeight();
        BlockState[] states = new BlockState[y];
        for (int i = 0; i < y; i++) {
            states[i] = Blocks.STONE.getDefaultState();
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
