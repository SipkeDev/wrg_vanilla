package vanilla.wildsregrown.registries.biomes;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class FarmLand extends VanillaBiome {

    public FarmLand() {
        super("plains");
        setSurface(Materials.dirt, 3);
        register(Floras.wheat, FloraSpawnRule.full_coverage, 0.25f, 0.75f, false);
        register(Floras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.beetroots, FloraSpawnRule.small_groups, 0, 1, false);
        register(Floras.carrots, FloraSpawnRule.small_groups, 0, 1, false);
        register(Floras.hay_bale, FloraSpawnRule.legendary, 0, 0, false);
        register(Structures.walled_village);
        register(Structures.pillager_outpost);
        register(Structures.walled_pillager_outpost);
    }

}
