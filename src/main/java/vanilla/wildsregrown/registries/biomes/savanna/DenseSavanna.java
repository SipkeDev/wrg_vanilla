package vanilla.wildsregrown.registries.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class DenseSavanna extends VanillaBiome {

    public DenseSavanna() {
        super("savanna");
        setSurface(Materials.dirt, 2);
        register(Floras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Floras.tall_grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.village);
        register(Structures.walled_village);
        register(Structures.trail_ruins);
    }

}
