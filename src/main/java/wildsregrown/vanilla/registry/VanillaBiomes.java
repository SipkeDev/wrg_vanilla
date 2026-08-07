package wildsregrown.vanilla.registry;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.features.biome.lakes.LakeFeature;
import com.sipke.api.features.botanic.flora.spawn.FloraSpawnRule;
import com.sipke.api.terrain.Biome;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import net.minecraft.world.level.biome.Biomes;
import wildsregrown.api.registry.BiomeUtil;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.modid;
import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaBiomes {

    /// vanilla
    public static final RegistryContainer<Biome> plains = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "plains", Biomes.PLAINS).build());
    public static final RegistryContainer<Biome> plains_hills = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "plains_hills", Biomes.PLAINS).surfaceNoise((seed) -> NoiseGenerator.cubic(seed.getSeed(), 128).fbm(3).scalebias(0.5f, 0.5f)).build());
    public static final RegistryContainer<Biome> sunflower_plains = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "sunflower_plains", Biomes.SUNFLOWER_PLAINS).build());
    public static final RegistryContainer<Biome> meadow = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "meadow", Biomes.MEADOW).build());
    public static final RegistryContainer<Biome> swamp = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "swamp", Biomes.SWAMP).build());
    public static final RegistryContainer<Biome> birch_forest = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "birch_forest", Biomes.BIRCH_FOREST).build());
    public static final RegistryContainer<Biome> forest = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "birch_forest", Biomes.FOREST).build());
    public static final RegistryContainer<Biome> flower_forest = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "birch_forest", Biomes.FLOWER_FOREST).build());
    public static final RegistryContainer<Biome> dark_forest = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "dark_forest", Biomes.DARK_FOREST).build());
    public static final RegistryContainer<Biome> taiga = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "taiga", Biomes.TAIGA).build());;
    public static final RegistryContainer<Biome> old_growth_birch_forest = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "old_growth_birch_forest", Biomes.OLD_GROWTH_BIRCH_FOREST).build());
    public static final RegistryContainer<Biome> old_growth_pine_taiga = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "old_growth_pine_taiga", Biomes.OLD_GROWTH_PINE_TAIGA).build());
    public static final RegistryContainer<Biome> old_growth_spruce_taiga = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "old_growth_spruce_taiga", Biomes.OLD_GROWTH_SPRUCE_TAIGA).build());
    public static final RegistryContainer<Biome> snowy_taiga = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "snowy_taiga", Biomes.SNOWY_TAIGA).build());
    public static final RegistryContainer<Biome> snowy_plains = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "snowy_plains", Biomes.SNOWY_PLAINS).build());
    public static final RegistryContainer<Biome> ice_spikes = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "ice_spikes", Biomes.ICE_SPIKES).build());

    public static final RegistryContainer<Biome> windswept_hills = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "windswept_hills", Biomes.WINDSWEPT_HILLS).build());
    public static final RegistryContainer<Biome> windswept_gravelly_hills = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "windswept_gravelly_hills", Biomes.WINDSWEPT_GRAVELLY_HILLS).build());
    public static final RegistryContainer<Biome> windswept_savanna = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "windswept_savanna", Biomes.WINDSWEPT_SAVANNA).build());
    public static final RegistryContainer<Biome> windswept_forest = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "windswept_forest", Biomes.WINDSWEPT_FOREST).build());

    public static final RegistryContainer<Biome> jagged_peaks = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "frozen_peaks", Biomes.JAGGED_PEAKS).build());
    public static final RegistryContainer<Biome> frozen_peaks = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "frozen_peaks", Biomes.FROZEN_PEAKS).build());
    public static final RegistryContainer<Biome> stony_peaks = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "frozen_peaks", Biomes.STONY_PEAKS).build());

    public static final RegistryContainer<Biome> snowy_beach = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "snowy_beach", Biomes.SNOWY_BEACH).build());
    public static final RegistryContainer<Biome> stony_shore = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "stony_shore", Biomes.STONY_SHORE).build());
    public static final RegistryContainer<Biome> beach = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "beach", Biomes.BEACH).build());


    public static final RegistryContainer<Biome> savanna = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "savanna", Biomes.SAVANNA).build());
    public static final RegistryContainer<Biome> dry_savanna = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "dry_savanna", Biomes.SAVANNA_PLATEAU).surfaceNoise((Seed)-> Constant.of(1f)).build());
    public static final RegistryContainer<Biome> mangrove_swamp = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "mangrove_swamp", Biomes.MANGROVE_SWAMP).build());
    public static final RegistryContainer<Biome> cherry_grove = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "cherry_grove", Biomes.CHERRY_GROVE).build());

    public static final RegistryContainer<Biome> badlands = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "badlands", Biomes.BADLANDS).build());
    public static final RegistryContainer<Biome> wooded_badlands = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "wooded_badlands", Biomes.WOODED_BADLANDS).build());

    public static final RegistryContainer<Biome> river = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "river", Biomes.RIVER).build());
    public static final RegistryContainer<Biome> frozen_river = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "frozen_river", Biomes.FROZEN_RIVER).build());

    public static final RegistryContainer<Biome> red_desert = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "red_desert", Biomes.DESERT).surfaceDepth(5).surfaceKey(VanillaMaterials.red_sand).build());
    public static final RegistryContainer<Biome> desert = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "desert", Biomes.DESERT).surfaceDepth(5).surfaceKey(VanillaMaterials.sand).build());

    public static final RegistryContainer<Biome> sparse_jungle = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "sparse_jungle", Biomes.SPARSE_JUNGLE).build());
    public static final RegistryContainer<Biome> jungle = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "jungle", Biomes.JUNGLE).build());
    public static final RegistryContainer<Biome> bamboo_jungle = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "bamboo_jungle", Biomes.BAMBOO_JUNGLE).build());

    //Oceans
    public static final RegistryContainer<Biome> frozen_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "frozen_ocean", Biomes.FROZEN_OCEAN).build());
    public static final RegistryContainer<Biome> cold_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "cold_ocean", Biomes.COLD_OCEAN).build());
    public static final RegistryContainer<Biome> ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "ocean", Biomes.OCEAN).build());
    public static final RegistryContainer<Biome> lukewarm_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "lukewarm_ocean", Biomes.LUKEWARM_OCEAN).build());
    public static final RegistryContainer<Biome> warm_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "warm_ocean", Biomes.WARM_OCEAN).build());
    public static final RegistryContainer<Biome> deep_frozen_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "deep_frozen_ocean", Biomes.DEEP_FROZEN_OCEAN).build());
    public static final RegistryContainer<Biome> deep_cold_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "deep_cold_ocean", Biomes.DEEP_COLD_OCEAN).build());
    public static final RegistryContainer<Biome> deep_lukewarm_ocean = WorldRegistries.BIOMES.register(BiomeUtil.builder(vanillaId, "deep_lukewarm_ocean", Biomes.DEEP_LUKEWARM_OCEAN).build());

    ///Vanilla+
    
    //Steppe
            
    public static final RegistryContainer<Biome> steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.grouped)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.rare)
                    .build());
    public static final RegistryContainer<Biome> forested_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "forested_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.grouped)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.rare)
                    .treeDensity(1.618f)
                    .treeDensityNoise(seed->NoiseGenerator.simplex(seed, 32))
                    .addTree(VanillaTrees.tall_birch, 0.785f, 0.25f, 0.5f)
                    .addTree(VanillaTrees.silver_birch,  0.785f,0.25f, 0.5f)
                    .addTree(VanillaTrees.oak, 0.785f, 0.25f, 0.5f)
                    .addBush(VanillaBushes.birch, 0.785f, 9, .25f, 0.5f)
                    .addBush(VanillaBushes.oak, 0.785f, 12,0.25f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> open_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "open_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .build());
    public static final RegistryContainer<Biome> dense_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "dense_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.large_groups)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.common)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.small_groups)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.occasional)
                    .surfaceNoise(seed->NoiseGenerator.perlin(seed.next(), 32).multiply(0.215f))
            .build());
    public static final RegistryContainer<Biome> dry_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "dry_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.small_groups)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.legendary)
                    .surfaceNoise(seed->NoiseGenerator.perlin(seed.next(), 32).multiply(0.215f))
                    .build());

    public static final RegistryContainer<Biome> wet_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wet_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.full_coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.fern, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.allium, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.azure_bluet, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.blue_orchid, FloraSpawnRule.rare)
                    .surfaceNoise(seed->NoiseGenerator.perlin(seed.next(), 64).fbm(3).range(-0.125f,0.125f))
                    .build());
    public static final RegistryContainer<Biome> forested_wet_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "forested_wet_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.full_coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.grouped)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.common)
                    .addFlora(VanillaFloras.blue_orchid, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.bush, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.azure_bluet, FloraSpawnRule.occasional)
                    .treeDensity(1.215f)
                    .treeDensityNoise(seed->NoiseGenerator.simplex(seed, 32))
                    .addTree(VanillaTrees.tall_birch,  0.785f,0.25f, 0.5f)
                    .addTree(VanillaTrees.silver_birch,  0.785f,0.25f, 0.5f)
                    .addTree(VanillaTrees.oak,  0.785f,0.25f, 0.5f)
                    .addBush(VanillaBushes.birch,  6,0.785f,0.25f, 0.5f)
                    .addBush(VanillaBushes.oak, 9,0.785f, 0.25f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> swamp_steppe = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "swamp_steppe")
                    .overgrown(true)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.full_coverage)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .treeDensity(1.382f)
                    .treeDensityNoise(seed->NoiseGenerator.simplex(seed, 32))
                    .addTree(VanillaTrees.tall_birch,  0.785f,0.25f, 0.5f)
                    .addTree(VanillaTrees.silver_birch, 0.785f, 0.25f, 0.5f)
                    .addTree(VanillaTrees.oak,  0.785f,0.25f, 0.5f)
                    .addBush(VanillaBushes.birch,  0.785f, 5,0.25f, 0.5f)
                    .addBush(VanillaBushes.oak,  0.785f, 12,0.25f, 0.5f)
                    .addFeature(new LakeFeature(NoiseGenerator.simplex(12, 64), 5))
                    .build());

    //Deciduous forest

    public static final RegistryContainer<Biome> wild_oak_forest = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_oak_forest")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.small_groups)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.leaf_litter, FloraSpawnRule.common)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.bush, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.sweet_berry_bush, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.fern, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.tall_fern, FloraSpawnRule.legendary)
                    .addFlora(VanillaFloras.lily_of_the_valley, FloraSpawnRule.rare)
                    .treeDensity(0.785f)
                    .addTree(VanillaTrees.oak,  0.785f,0.125f, 0.5f)
                    .addTree(VanillaTrees.big_oak, 0.785f, 0.125f, 0.5f)
                    .addBush(VanillaBushes.oak, 0.785f, 12,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_birch_forest = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_birch_forest")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.small_groups)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.leaf_litter, FloraSpawnRule.common)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.bush, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.allium, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.dandelion, FloraSpawnRule.legendary)
                    .addFlora(VanillaFloras.lily_of_the_valley, FloraSpawnRule.rare)
                    .treeDensity(0.785f)
                    .addTree(VanillaTrees.silver_birch,0.785f, 0.125f, 0.5f)
                    .addTree(VanillaTrees.tall_birch, 0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.birch,  0.785f,6, 0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_meadow = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_meadow")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.poppy, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.lily_of_the_valley, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.blue_orchid, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.cornflower, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.rose_bush, FloraSpawnRule.legendary)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.legendary)
                    .treeDensity(2.218f)
                    .addTree(VanillaTrees.silver_birch,  0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.birch, 0.785f,  6,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_grassfield = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_grassfield")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.small_groups)
                    .treeDensity(2.618f)
                    .addTree(VanillaTrees.silver_birch,  0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.birch,  6,0.785f,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_deciduous_swamp = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_deciduous_swamp")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.grouped)
                    .addFlora(VanillaFloras.bush, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.fern, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.tall_fern, FloraSpawnRule.legendary)
                    .treeDensity(1.618f)
                    .addTree(VanillaTrees.silver_birch,  0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.birch,  6,0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.oak, 12, 0.785f,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_deciduous_river = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_deciduous_river")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.grouped)
                    .addFlora(VanillaFloras.bush, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.fern, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.tall_fern, FloraSpawnRule.legendary)
                    .addBush(VanillaBushes.birch,  9,0.785f,0.125f, 0.5f)
                    .build());

    //Savanna
    public static final RegistryContainer<Biome> wild_savanna = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_savanna")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.leaf_litter, FloraSpawnRule.occasional)
                    .treeDensity(2.785f)
                    .addTree(VanillaTrees.acacia,  0.785f,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_forested_savanna = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_forested_savanna")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.leaf_litter, FloraSpawnRule.occasional)
                    .treeDensity(1.382f)
                    .addTree(VanillaTrees.acacia,  0.785f,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_wet_savanna = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_wet_savanna")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.full_coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.large_groups)
                    .treeDensity(1.618f)
                    .addTree(VanillaTrees.acacia,  0.785f,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_dry_savanna = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_dry_savanna")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.small_groups)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.legendary)
                    .build());
    public static final RegistryContainer<Biome> wild_savanna_swamp = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_savanna_swamp")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.full_coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.large_groups)
                    .treeDensity(1.618f)
                    .addTree(VanillaTrees.mangrove,  0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.mangrove,  9,0.785f,0.125f, 0.5f)
                    .build());
    public static final RegistryContainer<Biome> wild_savanna_river = WorldRegistries.BIOMES.register(
            BiomeUtil.builder(modid, "wild_savanna_river")
                    .overgrown(true)
                    .addFlora(VanillaFloras.grass, FloraSpawnRule.coverage)
                    .addFlora(VanillaFloras.tall_grass, FloraSpawnRule.grouped)
                    .addFlora(VanillaFloras.bush, FloraSpawnRule.occasional)
                    .addFlora(VanillaFloras.fern, FloraSpawnRule.rare)
                    .addFlora(VanillaFloras.tall_fern, FloraSpawnRule.legendary)
                    .treeDensity(1.618f)
                    .addTree(VanillaTrees.acacia,  0.785f,0.125f, 0.5f)
                    .addBush(VanillaBushes.mangrove, 12,0.785f, 0.125f, 0.5f)
                    .build());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded biomes");
    }

}
