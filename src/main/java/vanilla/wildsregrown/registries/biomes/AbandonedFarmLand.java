package vanilla.wildsregrown.registries.biomes;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class AbandonedFarmLand extends VanillaBiome {

    public AbandonedFarmLand() {
        super("plains");
        setSurface(Materials.dirt, 3);
        register(Floras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.wheat, FloraSpawnRule.small_groups, 0, 0.5f, false);
        register(Floras.grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(Floras.wheat, FloraSpawnRule.occasional, 0.8f, 1f, false);
        register(Floras.hay_bale, FloraSpawnRule.legendary, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.pillager_outpost);
        register(Structures.trail_ruins);
        register(Structures.walled_pillager_outpost);
    }

}
