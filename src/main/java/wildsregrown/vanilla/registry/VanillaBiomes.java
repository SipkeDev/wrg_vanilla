package wildsregrown.vanilla.registry;

import com.sipke.api.terrain.Biome;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;
import wildsregrown.vanilla.registry.api.VanillaBiome;
import wildsregrown.vanilla.registry.api.VanillaBiomeGrass;
import wildsregrown.vanilla.registry.biomes.*;
import wildsregrown.vanilla.registry.biomes.meadow.*;
import wildsregrown.vanilla.registry.biomes.plains.*;
import wildsregrown.vanilla.registry.biomes.savanna.*;

public class VanillaBiomes {

    //Vanilla
    public static final RegistryContainer<Biome> badlands = WorldRegistries.BIOMES.register(new VanillaBiome("badlands"));
    public static final RegistryContainer<Biome> bamboo_jungle = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("bamboo_jungle"));
    public static final RegistryContainer<Biome> beach = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("beach"));
    public static final RegistryContainer<Biome> birch_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("birch_forest"));
    public static final RegistryContainer<Biome> cherry_grove = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("cherry_grove"));
    public static final RegistryContainer<Biome> cold_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("cold_ocean"));
    public static final RegistryContainer<Biome> crimson_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("crimson_forest"));
    public static final RegistryContainer<Biome> dark_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("dark_forest"));
    public static final RegistryContainer<Biome> deep_cold_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_cold_ocean"));
    public static final RegistryContainer<Biome> deep_frozen_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_frozen_ocean"));
    public static final RegistryContainer<Biome> deep_lukewarm_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_lukewarm_ocean"));
    public static final RegistryContainer<Biome> deep_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_ocean"));

    public static final RegistryContainer<Biome> hot_desert = WorldRegistries.BIOMES.register(new HotDesert());
    public static final RegistryContainer<Biome> red_desert = WorldRegistries.BIOMES.register(new RedDesert());
    public static final RegistryContainer<Biome> cool_desert = WorldRegistries.BIOMES.register(new CoolDesert());

    public static final RegistryContainer<Biome> dripstone_caves = WorldRegistries.BIOMES.register(new VanillaBiome("dripstone_caves"));
    public static final RegistryContainer<Biome> eroded_badlands = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("eroded_badlands"));
    public static final RegistryContainer<Biome> flower_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("flower_forest"));
    public static final RegistryContainer<Biome> forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("forest"));
    public static final RegistryContainer<Biome> frozen_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("frozen_ocean"));
    public static final RegistryContainer<Biome> frozen_peaks = WorldRegistries.BIOMES.register(new VanillaBiome("frozen_peaks"));
    public static final RegistryContainer<Biome> frozen_river = WorldRegistries.BIOMES.register(new VanillaBiome("frozen_river"));
    public static final RegistryContainer<Biome> grove = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("grove"));
    public static final RegistryContainer<Biome> ice_spikes = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("ice_spikes"));
    public static final RegistryContainer<Biome> jagged_peaks = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("jagged_peaks"));
    public static final RegistryContainer<Biome> jungle = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("jungle"));
    public static final RegistryContainer<Biome> lukewarm_ocean = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("lukewarm_ocean"));
    public static final RegistryContainer<Biome> lush_caves = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("lush_caves"));
    public static final RegistryContainer<Biome> mangrove_swamp = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("mangrove_swamp"));
    public static final RegistryContainer<Biome> meadow = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("meadow"));
    public static final RegistryContainer<Biome> mushroom_fields = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("mushroom_fields"));
    public static final RegistryContainer<Biome> ocean = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("ocean"));
    public static final RegistryContainer<Biome> old_growth_birch_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("old_growth_birch_forest"));
    public static final RegistryContainer<Biome> old_growth_pine_taiga = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("old_growth_pine_taiga"));
    public static final RegistryContainer<Biome> old_growth_spruce_taiga = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("old_growth_spruce_taiga"));
    public static final RegistryContainer<Biome> pale_garden = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("pale_garden"));
    public static final RegistryContainer<Biome> river = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("river"));
    public static final RegistryContainer<Biome> snowy_beach = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("snowy_beach"));
    public static final RegistryContainer<Biome> snowy_plains = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("snowy_plains"));
    public static final RegistryContainer<Biome> snowy_slopes = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("snowy_slopes"));
    public static final RegistryContainer<Biome> snowy_taiga = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("snowy_taiga"));
    public static final RegistryContainer<Biome> sparse_jungle = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("sparse_jungle"));
    public static final RegistryContainer<Biome> stony_peaks = WorldRegistries.BIOMES.register(new VanillaBiome("stony_peaks"));
    public static final RegistryContainer<Biome> stony_shore = WorldRegistries.BIOMES.register(new VanillaBiome("stony_shore"));
    public static final RegistryContainer<Biome> sunflower_plains = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("sunflower_plains"));
    public static final RegistryContainer<Biome> swamp = WorldRegistries.BIOMES.register(new Swamp());
    public static final RegistryContainer<Biome> taiga = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("taiga"));
    public static final RegistryContainer<Biome> warm_ocean = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("warm_ocean"));
    public static final RegistryContainer<Biome> warped_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("warped_forest"));
    public static final RegistryContainer<Biome> windswept_forest = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("windswept_forest"));
    public static final RegistryContainer<Biome> windswept_gravelly_hills = WorldRegistries.BIOMES.register(new VanillaBiome("windswept_gravelly_hills"));
    public static final RegistryContainer<Biome> windswept_hills = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("windswept_hills"));
    public static final RegistryContainer<Biome> windswept_savanna = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("windswept_savanna"));
    public static final RegistryContainer<Biome> wooded_badlands = WorldRegistries.BIOMES.register(new VanillaBiomeGrass("wooded_badlands"));

    /**
     * Custom WRG powered biomes
     */
    //swamps
    public static final RegistryContainer<Biome> peat_swamp = WorldRegistries.BIOMES.register(new PeatSwamp());

    //plains
    public static final RegistryContainer<Biome> blue_flower_plains = WorldRegistries.BIOMES.register(new BlueFlowerPlains());
    public static final RegistryContainer<Biome> red_flower_plains = WorldRegistries.BIOMES.register(new RedFlowerPlains());
    public static final RegistryContainer<Biome> pink_flower_plains = WorldRegistries.BIOMES.register(new PinkFlowerPlains());
    public static final RegistryContainer<Biome> white_flower_plains = WorldRegistries.BIOMES.register(new WhiteFlowerPlains());
    public static final RegistryContainer<Biome> dense_plains = WorldRegistries.BIOMES.register(new DensePlains());
    public static final RegistryContainer<Biome> tall_dense_plains = WorldRegistries.BIOMES.register(new TallDensePlains());
    public static final RegistryContainer<Biome> dry_plains = WorldRegistries.BIOMES.register(new DryPlains());
    public static final RegistryContainer<Biome> plains = WorldRegistries.BIOMES.register(new Plains());
    public static final RegistryContainer<Biome> sparse_plains = WorldRegistries.BIOMES.register(new SparsePlains());
    public static final RegistryContainer<Biome> tall_plains = WorldRegistries.BIOMES.register(new TallPlains());
    public static final RegistryContainer<Biome> wet_plains_0 = WorldRegistries.BIOMES.register(new WetPlains());
    public static final RegistryContainer<Biome> wet_plains_1 = WorldRegistries.BIOMES.register(new WetPlains2());
    public static final RegistryContainer<Biome> wet_plains_2 = WorldRegistries.BIOMES.register(new WetPlains3());

    //savanna
    public static final RegistryContainer<Biome> dense_savanna = WorldRegistries.BIOMES.register(new DenseSavanna());
    public static final RegistryContainer<Biome> dry_savanna = WorldRegistries.BIOMES.register(new DrySavanna());
    public static final RegistryContainer<Biome> savanna = WorldRegistries.BIOMES.register(new Savanna());
    public static final RegistryContainer<Biome> savanna_ferns = WorldRegistries.BIOMES.register(new SavannaFerns());
    public static final RegistryContainer<Biome> savanna_flowers = WorldRegistries.BIOMES.register(new SavannaFlowers());
    public static final RegistryContainer<Biome> sparse_savanna = WorldRegistries.BIOMES.register(new SparseSavanna());
    public static final RegistryContainer<Biome> wet_savanna = WorldRegistries.BIOMES.register(new WetSavanna());

    //meadow
    public static final RegistryContainer<Biome> blue_meadow = WorldRegistries.BIOMES.register(new BlueMeadow());
    public static final RegistryContainer<Biome> red_meadow = WorldRegistries.BIOMES.register(new RedMeadow());

    //misc
    public static final RegistryContainer<Biome> farmland = WorldRegistries.BIOMES.register(new FarmLand());
    public static final RegistryContainer<Biome> abandoned_farmland = WorldRegistries.BIOMES.register(new AbandonedFarmLand());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded biomes");
    }

}
