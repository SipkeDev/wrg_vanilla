package vanilla.wildsregrown.world;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sipke.World;
import com.sipke.WorldConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.util.math.random.RandomSeed;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeCoords;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.noise.NoiseConfig;
import vanilla.wildsregrown.mixin.PopulateBiomes;
import vanilla.wildsregrown.world.biomes.WRGBiomeProvider;
import vanilla.wildsregrown.world.decorator.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public final class WRGChunkGenerator extends ChunkGenerator {

    public static final MapCodec<WRGChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(
                    BiomeSource.CODEC.fieldOf("biome_source").forGetter(
                            (generator) -> generator.biomeSource),
                    ChunkGeneratorSettings.REGISTRY_CODEC.fieldOf("settings")
                            .forGetter((generator) -> generator.settings)
            ).apply(instance, instance.stable(WRGChunkGenerator::new)));

    private final World world;
    private final RegistryEntry<ChunkGeneratorSettings> settings;
    private final BaseDecorator decorator;
    private final BedrockDecorator bedrockDecorator;

    public WRGChunkGenerator(BiomeSource source, RegistryEntry<ChunkGeneratorSettings> settings) {
        super(source);
        this.settings = settings;
        this.world = new World();
        if (source instanceof WRGBiomeProvider provider){
            provider.setWorld(world);
        }
        this.decorator = new BaseDecorator(this);
        this.bedrockDecorator = new BedrockDecorator();
    }

    public CompletableFuture<Chunk> populateBiomes(NoiseConfig noiseConfig, Blender blender, StructureAccessor structureAccessor, Chunk chunk) {
        return CompletableFuture.supplyAsync(() -> {
            populateBiomes(chunk);
            return chunk;
        }, Util.getMainWorkerExecutor().named("init_biomes"));
    }

    private void populateBiomes(Chunk chunk) {
        ChunkPos chunkPos = chunk.getPos();
        HeightLimitView heightLimitView = chunk.getHeightLimitView();
        for(int k = heightLimitView.getBottomSectionCoord(); k <= heightLimitView.getTopSectionCoord(); ++k) {
            ChunkSection chunkSection = chunk.getSection(k-chunk.getBottomSectionCoord());
            int y = BiomeCoords.fromChunk(k);
            chunkSection.populateBiomes(biomeSource, null, BiomeCoords.fromChunk(chunkPos.getStartX()), y, BiomeCoords.fromChunk(chunkPos.getStartZ()));
        }
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
        //invalid
    }

    @Override
    public int getWorldHeight() {
        return WorldConstants.worldHeight;
    }

    @Override
    public CompletableFuture<Chunk> populateNoise(Blender blender, NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {
        decorator.apply(chunk);
        bedrockDecorator.apply(chunk);
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getSeaLevel() {
        return WorldConstants.sea;
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
        return this.world;
    }

    @Override
    public void populateEntities(ChunkRegion region) {
        if (!(this.settings.value()).mobGenerationDisabled()) {
            ChunkPos chunkPos = region.getCenterPos();
            RegistryEntry<Biome> registryEntry = region.getBiome(chunkPos.getStartPos().withY(region.getTopYInclusive()));
            ChunkRandom chunkRandom = new ChunkRandom(new CheckedRandom(RandomSeed.getSeed()));
            chunkRandom.setPopulationSeed(region.getSeed(), chunkPos.getStartX(), chunkPos.getStartZ());
            SpawnHelper.populateEntities(region, registryEntry, chunkPos, chunkRandom);
        }
    }

}
