package wildsregrown.vanilla.registry.biomes;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class FarmLand extends WRGBiome {

    public FarmLand() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 3);
        register(VanillaFloras.wheat, FloraSpawnRule.full_coverage, 0.25f, 0.75f, false);
        register(VanillaFloras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaFloras.beetroots, FloraSpawnRule.small_groups, 0, 1, false);
        register(VanillaFloras.carrots, FloraSpawnRule.small_groups, 0, 1, false);
        register(VanillaFloras.hay_bale, FloraSpawnRule.legendary, 0, 0, false);
        register(VanillaStructures.walled_village);
        register(VanillaStructures.pillager_outpost);
        register(VanillaStructures.walled_pillager_outpost);
    }

}
