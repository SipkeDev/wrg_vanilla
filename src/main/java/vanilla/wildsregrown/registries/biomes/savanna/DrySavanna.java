package vanilla.wildsregrown.registries.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class DrySavanna extends VanillaBiome {

    public DrySavanna() {
        super("savanna_plateau");
        setSurface(Materials.coarse_dirt, 1);
        register(Floras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.village);
        register(Structures.walled_village);
        register(Structures.trail_chamber);
    }

}
