package vanilla.wildsregrown.registries;

import com.sipke.api.terrain.Biome;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.biome.IdentifierBiome;
import vanilla.wildsregrown.api.biome.VanillaBiome;

import static vanilla.wildsregrown.WRGVanilla.modid;

public class Biomes {

    //Vanilla
    public static final RegistryObject<Biome> badlands = WorldRegistries.BIOMES.register(new VanillaBiome("badlands"));
    public static final RegistryObject<Biome> bamboo_jungle = WorldRegistries.BIOMES.register(new VanillaBiome("bamboo_jungle"));
    public static final RegistryObject<Biome> beach = WorldRegistries.BIOMES.register(new VanillaBiome("beach"));
    public static final RegistryObject<Biome> birch_forest = WorldRegistries.BIOMES.register(new VanillaBiome("birch_forest"));
    public static final RegistryObject<Biome> cherry_grove = WorldRegistries.BIOMES.register(new VanillaBiome("cherry_grove"));
    public static final RegistryObject<Biome> cold_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("cold_ocean"));
    public static final RegistryObject<Biome> crimson_forest = WorldRegistries.BIOMES.register(new VanillaBiome("crimson_forest"));
    public static final RegistryObject<Biome> dark_forest = WorldRegistries.BIOMES.register(new VanillaBiome("dark_forest"));
    public static final RegistryObject<Biome> deep_cold_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_cold_ocean"));
    public static final RegistryObject<Biome> deep_frozen_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_frozen_ocean"));
    public static final RegistryObject<Biome> deep_lukewarm_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_lukewarm_ocean"));
    public static final RegistryObject<Biome> deep_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("deep_ocean"));
    public static final RegistryObject<Biome> desert = WorldRegistries.BIOMES.register(new VanillaBiome("desert"));
    public static final RegistryObject<Biome> dripstone_caves = WorldRegistries.BIOMES.register(new VanillaBiome("dripstone_caves"));
    public static final RegistryObject<Biome> eroded_badlands = WorldRegistries.BIOMES.register(new VanillaBiome("eroded_badlands"));
    public static final RegistryObject<Biome> flower_forest = WorldRegistries.BIOMES.register(new VanillaBiome("flower_forest"));
    public static final RegistryObject<Biome> forest = WorldRegistries.BIOMES.register(new VanillaBiome("forest"));
    public static final RegistryObject<Biome> frozen_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("frozen_ocean"));
    public static final RegistryObject<Biome> frozen_peaks = WorldRegistries.BIOMES.register(new VanillaBiome("frozen_peaks"));
    public static final RegistryObject<Biome> frozen_river = WorldRegistries.BIOMES.register(new VanillaBiome("frozen_river"));
    public static final RegistryObject<Biome> grove = WorldRegistries.BIOMES.register(new VanillaBiome("grove"));
    public static final RegistryObject<Biome> ice_spikes = WorldRegistries.BIOMES.register(new VanillaBiome("ice_spikes"));
    public static final RegistryObject<Biome> jagged_peaks = WorldRegistries.BIOMES.register(new VanillaBiome("jagged_peaks"));
    public static final RegistryObject<Biome> jungle = WorldRegistries.BIOMES.register(new VanillaBiome("jungle"));
    public static final RegistryObject<Biome> lukewarm_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("lukewarm_ocean"));
    public static final RegistryObject<Biome> lush_caves = WorldRegistries.BIOMES.register(new VanillaBiome("lush_caves"));
    public static final RegistryObject<Biome> mangrove_swamp = WorldRegistries.BIOMES.register(new VanillaBiome("mangrove_swamp"));
    public static final RegistryObject<Biome> meadow = WorldRegistries.BIOMES.register(new VanillaBiome("meadow"));
    public static final RegistryObject<Biome> mushroom_fields = WorldRegistries.BIOMES.register(new VanillaBiome("mushroom_fields"));
    public static final RegistryObject<Biome> ocean = WorldRegistries.BIOMES.register(new VanillaBiome("ocean"));
    public static final RegistryObject<Biome> old_growth_birch_forest = WorldRegistries.BIOMES.register(new VanillaBiome("old_growth_birch_forest"));
    public static final RegistryObject<Biome> old_growth_pine_taiga = WorldRegistries.BIOMES.register(new VanillaBiome("old_growth_pine_taiga"));
    public static final RegistryObject<Biome> old_growth_spruce_taiga = WorldRegistries.BIOMES.register(new VanillaBiome("old_growth_spruce_taiga"));
    public static final RegistryObject<Biome> pale_garden = WorldRegistries.BIOMES.register(new VanillaBiome("pale_garden"));
    public static final RegistryObject<Biome> plains = WorldRegistries.BIOMES.register(new VanillaBiome("plains"));
    public static final RegistryObject<Biome> river = WorldRegistries.BIOMES.register(new VanillaBiome("river"));
    public static final RegistryObject<Biome> savanna = WorldRegistries.BIOMES.register(new VanillaBiome("savanna"));
    public static final RegistryObject<Biome> savanna_plateau = WorldRegistries.BIOMES.register(new VanillaBiome("savanna_plateau"));
    public static final RegistryObject<Biome> snowy_beach = WorldRegistries.BIOMES.register(new VanillaBiome("snowy_beach"));
    public static final RegistryObject<Biome> snowy_plains = WorldRegistries.BIOMES.register(new VanillaBiome("snowy_plains"));
    public static final RegistryObject<Biome> snowy_slopes = WorldRegistries.BIOMES.register(new VanillaBiome("snowy_slopes"));
    public static final RegistryObject<Biome> snowy_taiga = WorldRegistries.BIOMES.register(new VanillaBiome("snowy_taiga"));
    public static final RegistryObject<Biome> sparse_jungle = WorldRegistries.BIOMES.register(new VanillaBiome("sparse_jungle"));
    public static final RegistryObject<Biome> stony_peaks = WorldRegistries.BIOMES.register(new VanillaBiome("stony_peaks"));
    public static final RegistryObject<Biome> stony_shore = WorldRegistries.BIOMES.register(new VanillaBiome("stony_shore"));
    public static final RegistryObject<Biome> sunflower_plains = WorldRegistries.BIOMES.register(new VanillaBiome("sunflower_plains"));
    public static final RegistryObject<Biome> swamp = WorldRegistries.BIOMES.register(new VanillaBiome("swamp"));
    public static final RegistryObject<Biome> taiga = WorldRegistries.BIOMES.register(new VanillaBiome("taiga"));
    public static final RegistryObject<Biome> warm_ocean = WorldRegistries.BIOMES.register(new VanillaBiome("warm_ocean"));
    public static final RegistryObject<Biome> warped_forest = WorldRegistries.BIOMES.register(new VanillaBiome("warped_forest"));
    public static final RegistryObject<Biome> windswept_forest = WorldRegistries.BIOMES.register(new VanillaBiome("windswept_forest"));
    public static final RegistryObject<Biome> windswept_gravelly_hills = WorldRegistries.BIOMES.register(new VanillaBiome("windswept_gravelly_hills"));
    public static final RegistryObject<Biome> windswept_hills = WorldRegistries.BIOMES.register(new VanillaBiome("windswept_hills"));
    public static final RegistryObject<Biome> windswept_savanna = WorldRegistries.BIOMES.register(new VanillaBiome("windswept_savanna"));
    public static final RegistryObject<Biome> wooded_badlands = WorldRegistries.BIOMES.register(new VanillaBiome("wooded_badlands"));

    public static void init(){
        WorldRegistries.BIOMES.bootstrap();
        WRGVanilla.LOGGER.info("loaded biomes");
    }

}
