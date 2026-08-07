package wildsregrown.vanilla.registry;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaEcosystems {

    /// Vanilla
    //public static final RegistryContainer<Ecosystem> coldOcean = WorldRegistries.ECOSYSTEMS.register(new ColdOcean());
    //public static final RegistryContainer<Ecosystem> ocean = WorldRegistries.ECOSYSTEMS.register(new Ocean());
    //public static final RegistryContainer<Ecosystem> warmOcean = WorldRegistries.ECOSYSTEMS.register(new WarmOcean());
    //public static final RegistryContainer<Ecosystem> coldSea = WorldRegistries.ECOSYSTEMS.register(new ColdSea());
    //public static final RegistryContainer<Ecosystem> sea = WorldRegistries.ECOSYSTEMS.register(new Sea());
    //public static final RegistryContainer<Ecosystem> warmSea = WorldRegistries.ECOSYSTEMS.register(new WarmSea());

    public static final RegistryContainer<Ecosystem> frozen_ocean = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "frozen_ocean", Climate.frozenOcean)
                    .register(Placement.Biome.normal, VanillaBiomes.deep_frozen_ocean)
                    .build());
    public static final RegistryContainer<Ecosystem> cold_ocean = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "cold_ocean", Climate.coldOcean)
                    .register(Placement.Biome.normal, VanillaBiomes.deep_cold_ocean)
                    .build());
    public static final RegistryContainer<Ecosystem> temperate_ocean = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "temperate_ocean", Climate.temperateOcean)
                    .register(Placement.Biome.normal, VanillaBiomes.deep_cold_ocean)
                    .build());
    public static final RegistryContainer<Ecosystem> warm_ocean = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "warm_ocean", Climate.warmOcean)
                    .register(Placement.Biome.normal, VanillaBiomes.deep_lukewarm_ocean)
                    .build());

    public static final RegistryContainer<Ecosystem> frozen_sea = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "frozen_ocean", Climate.frozenSea)
                    .register(Placement.Biome.normal, VanillaBiomes.frozen_ocean)
                    .build());
    public static final RegistryContainer<Ecosystem> cold_sea = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "cold_ocean", Climate.coldSea)
                    .register(Placement.Biome.normal, VanillaBiomes.cold_ocean)
                    .build());
    public static final RegistryContainer<Ecosystem> temperate_sea = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "temperate_sea", Climate.temperateSea)
                    .register(Placement.Biome.normal, VanillaBiomes.lukewarm_ocean)
                    .build());
    public static final RegistryContainer<Ecosystem> warm_sea = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "warm_sea", Climate.warmSea)
                    .register(Placement.Biome.normal, VanillaBiomes.warm_ocean)
                    .build());

    public static final RegistryContainer<Ecosystem> frozen_coast = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "frozen_coast", Climate.frozenSea)
                    .register(Placement.Biome.normal, VanillaBiomes.snowy_beach)
                    .build());
    public static final RegistryContainer<Ecosystem> cold_coast = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "cold_coast", Climate.coldSea)
                    .register(Placement.Biome.normal, VanillaBiomes.stony_shore)
                    .build());
    public static final RegistryContainer<Ecosystem> temperate_coast = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "temperate_coast", Climate.temperateSea)
                    .register(Placement.Biome.normal, VanillaBiomes.beach)
                    .build());
    public static final RegistryContainer<Ecosystem> warm_coast = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "warm_coast", Climate.warmSea)
                    .register(Placement.Biome.normal, VanillaBiomes.beach)
                    .build());

    public static final RegistryContainer<Ecosystem> cold_mountain_top = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "cold_mountain_top", Climate.cold_mountain_top)
                    .register(Placement.Biome.normal, VanillaBiomes.frozen_peaks)
                    .build());
    public static final RegistryContainer<Ecosystem> temperate_mountain_top = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "temperate_mountain_top", Climate.temperate_mountain_top)
                    .register(Placement.Biome.normal, VanillaBiomes.stony_peaks)
                    .build());
    public static final RegistryContainer<Ecosystem> warm_mountain_top = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "warm_mountain_top", Climate.warm_mountain_top)
                    .register(Placement.Biome.normal, VanillaBiomes.stony_peaks)
                    .build());

    public static final RegistryContainer<Ecosystem> coniferous_forest = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "coniferous_forest", Climate.coniferousForest)
                    .register(Placement.Biome.normal, VanillaBiomes.taiga, 5)
                    .register(Placement.Biome.normal, VanillaBiomes.forest)
                    .register(Placement.Biome.dry, VanillaBiomes.plains)
                    .register(Placement.Biome.wet, VanillaBiomes.old_growth_pine_taiga, 2)
                    .register(Placement.Biome.wet, VanillaBiomes.birch_forest)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> deciduous_forest = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "deciduous_forest", Climate.deciduousForest)
                    .register(Placement.Biome.normal, VanillaBiomes.forest, 5)
                    .register(Placement.Biome.normal, VanillaBiomes.dark_forest)
                    .register(Placement.Biome.dry, VanillaBiomes.plains, 3)
                    .register(Placement.Biome.dry, VanillaBiomes.sunflower_plains)
                    .register(Placement.Biome.wet, VanillaBiomes.birch_forest)
                    .register(Placement.Biome.wet, VanillaBiomes.meadow)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
            .build());
    public static final RegistryContainer<Ecosystem> mixed_forest = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "mixed_forest", Climate.mixedForest)
                    .register(Placement.Biome.normal, VanillaBiomes.plains)
                    .register(Placement.Biome.normal, VanillaBiomes.forest, 5)
                    .register(Placement.Biome.normal, VanillaBiomes.birch_forest)
                    .register(Placement.Biome.dry, VanillaBiomes.sunflower_plains)
                    .register(Placement.Biome.wet, VanillaBiomes.flower_forest, 2)
                    .register(Placement.Biome.wet, VanillaBiomes.meadow)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> plains = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "plains", Climate.steppe)
                    .register(Placement.Biome.normal, VanillaBiomes.plains, 2)
                    .register(Placement.Biome.normal, VanillaBiomes.sunflower_plains)
                    .register(Placement.Biome.dry, VanillaBiomes.plains_hills)
                    .register(Placement.Biome.wet, VanillaBiomes.meadow)
                    .register(Placement.Biome.wet, VanillaBiomes.birch_forest)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> polar_desert = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "polar_desert", Climate.polarDesert)
                    .register(Placement.Biome.normal, VanillaBiomes.snowy_plains)
                    .register(Placement.Biome.dry, VanillaBiomes.snowy_plains)
                    .register(Placement.Biome.wet, VanillaBiomes.snowy_taiga)
                    .register(Placement.Biome.swamp, VanillaBiomes.ice_spikes)
                    .build());
    public static final RegistryContainer<Ecosystem> savanna = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "savanna", Climate.savanna)
                    .register(Placement.Biome.normal, VanillaBiomes.savanna)
                    .register(Placement.Biome.dry, VanillaBiomes.dry_savanna)
                    .register(Placement.Biome.wet, VanillaBiomes.windswept_savanna)
                    .register(Placement.Biome.swamp, VanillaBiomes.mangrove_swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> tundra = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "tundra", Climate.tundra)
                    .register(Placement.Biome.normal, VanillaBiomes.taiga, 2)
                    .register(Placement.Biome.normal, VanillaBiomes.snowy_taiga)
                    .register(Placement.Biome.dry, VanillaBiomes.snowy_plains)
                    .register(Placement.Biome.wet, VanillaBiomes.old_growth_spruce_taiga, 2)
                    .register(Placement.Biome.wet, VanillaBiomes.old_growth_birch_forest)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> ice = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "ice", Climate.ice)
                    .register(Placement.Biome.normal, VanillaBiomes.snowy_plains)
                    .register(Placement.Biome.dry, VanillaBiomes.frozen_peaks)
                    .register(Placement.Biome.wet, VanillaBiomes.snowy_taiga)
                    .register(Placement.Biome.swamp, VanillaBiomes.ice_spikes)
                    .build());
    public static final RegistryContainer<Ecosystem> chaparral = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "chaparral", Climate.chaparral)
                    .register(Placement.Biome.normal, VanillaBiomes.windswept_forest)
                    .register(Placement.Biome.normal, VanillaBiomes.windswept_hills)
                    .register(Placement.Biome.dry, VanillaBiomes.windswept_gravelly_hills)
                    .register(Placement.Biome.wet, VanillaBiomes.cherry_grove)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> cool_shrubland = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "cool_shrubland", Climate.coolShrubland)
                    .register(Placement.Biome.normal, VanillaBiomes.taiga)
                    .register(Placement.Biome.dry, VanillaBiomes.windswept_hills)
                    .register(Placement.Biome.wet, VanillaBiomes.meadow)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> hot_shrubland = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "hot_shrubland", Climate.hotScrubland)
                    .register(Placement.Biome.normal, VanillaBiomes.badlands, 3)
                    .register(Placement.Biome.normal, VanillaBiomes.wooded_badlands)
                    .register(Placement.Biome.dry, VanillaBiomes.stony_peaks)
                    .register(Placement.Biome.wet, VanillaBiomes.savanna)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> cool_desert = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "cool_desert", Climate.coolDesert)
                    .register(Placement.Biome.normal, VanillaBiomes.desert, 2)
                    .register(Placement.Biome.normal, VanillaBiomes.windswept_gravelly_hills)
                    .register(Placement.Biome.dry, VanillaBiomes.desert)
                    .register(Placement.Biome.wet, VanillaBiomes.red_desert)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> hot_desert = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "hot_desert", Climate.hotDesert)
                    .register(Placement.Biome.normal, VanillaBiomes.desert)
                    .build());
    public static final RegistryContainer<Ecosystem> tropical_seasonal_forest = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "tropical_seasonal_forest", Climate.tropical_seasonal_forest)
                    .register(Placement.Biome.normal, VanillaBiomes.sparse_jungle, 3)
                    .register(Placement.Biome.normal, VanillaBiomes.savanna)
                    .register(Placement.Biome.dry, VanillaBiomes.dry_savanna)
                    .register(Placement.Biome.wet, VanillaBiomes.sparse_jungle)
                    .register(Placement.Biome.swamp, VanillaBiomes.mangrove_swamp)
                    .build());
    public static final RegistryContainer<Ecosystem> tropical_forest = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(vanillaId, "tropical_forest", Climate.tropical_forest)
                    .register(Placement.Biome.normal, VanillaBiomes.jungle)
                    .register(Placement.Biome.dry, VanillaBiomes.sparse_jungle)
                    .register(Placement.Biome.wet, VanillaBiomes.bamboo_jungle)
                    .register(Placement.Biome.swamp, VanillaBiomes.mangrove_swamp)
                    .build());

    /// Vanilla+
    public static final RegistryContainer<Ecosystem> wild_plains = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(WRGVanilla.modid, "wild_plains", Climate.steppe)
                    .register(Placement.Biome.normal, VanillaBiomes.steppe, 3)
                    .register(Placement.Biome.normal, VanillaBiomes.forested_steppe, 2)
                    .register(Placement.Biome.normal, VanillaBiomes.open_steppe)
                    .register(Placement.Biome.normal, VanillaBiomes.dense_steppe)
                    .register(Placement.Biome.dry, VanillaBiomes.dry_steppe, 3)
                    .register(Placement.Biome.dry, VanillaBiomes.open_steppe)
                    .register(Placement.Biome.wet, VanillaBiomes.wet_steppe, 2)
                    .register(Placement.Biome.wet, VanillaBiomes.forested_wet_steppe)
                    .register(Placement.Biome.swamp, VanillaBiomes.swamp_steppe)
                    .build());
    public static final RegistryContainer<Ecosystem> wild_deciduous_forest = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(WRGVanilla.modid, "wild_deciduous_forest", Climate.deciduousForest)
                    .register(Placement.Biome.normal, VanillaBiomes.wild_oak_forest, 3)
                    .register(Placement.Biome.normal, VanillaBiomes.wild_birch_forest, 2)
                    .register(Placement.Biome.dry, VanillaBiomes.wild_grassfield)
                    .register(Placement.Biome.wet, VanillaBiomes.wild_meadow)
                    .register(Placement.Biome.swamp, VanillaBiomes.wild_deciduous_swamp)
                    .register(Placement.Biome.river, VanillaBiomes.wild_deciduous_river)
                    .register(Placement.Biome.lake, VanillaBiomes.wild_deciduous_river)
                    .build());
    public static final RegistryContainer<Ecosystem> wild_savanna = WorldRegistries.ECOSYSTEMS.register(
            new Ecosystem.Builder(WRGVanilla.modid, "wild_savanna", Climate.savanna)
                    .register(Placement.Biome.normal, VanillaBiomes.wild_savanna, 4)
                    .register(Placement.Biome.normal, VanillaBiomes.wild_forested_savanna)
                    .register(Placement.Biome.dry, VanillaBiomes.wild_dry_savanna, 3)
                    .register(Placement.Biome.wet, VanillaBiomes.wild_wet_savanna)
                    .register(Placement.Biome.swamp, VanillaBiomes.wild_savanna_swamp)
                    .register(Placement.Biome.river, VanillaBiomes.wild_savanna_river)
                    .register(Placement.Biome.lake, VanillaBiomes.wild_savanna_river)
                    .build());

    public static void init() {
        WRGVanilla.LOGGER.info("loaded ecosystems");
    }

}
