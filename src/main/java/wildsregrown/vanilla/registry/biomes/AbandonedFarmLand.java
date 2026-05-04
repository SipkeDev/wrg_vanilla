package wildsregrown.vanilla.registry.biomes;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.api.registry.registerables.WRGBiome;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class AbandonedFarmLand extends WRGBiome {

    public AbandonedFarmLand() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 3);
        register(VanillaFloras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaFloras.wheat, FloraSpawnRule.small_groups, 0, 0.5f, false);
        register(VanillaFloras.grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(VanillaFloras.wheat, FloraSpawnRule.occasional, 0.8f, 1f, false);
        register(VanillaFloras.hay_bale, FloraSpawnRule.legendary, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.pillager_outpost);
        register(VanillaStructures.trail_ruins);
        register(VanillaStructures.walled_pillager_outpost);
    }

}
