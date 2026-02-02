package vanilla.wildsregrown.registries.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class SavannaFlowers extends VanillaBiome {

    public SavannaFlowers() {
        super("savanna");
        setSurface(Materials.dirt, 2);
        register(Floras.tall_grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(Floras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.poppy, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.allium, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.dandelion, FloraSpawnRule.occasional, 0, 0, false);
        register(Structures.village);
        register(Structures.walled_village);
    }

}
