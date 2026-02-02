package vanilla.wildsregrown.registries.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class SparseSavanna extends VanillaBiome {

    public SparseSavanna() {
        super("savanna_plateau");
        setSurface(Materials.dirt, 2);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.village);
        register(Structures.walled_village);
        register(Structures.ruined_portal);
        register(Structures.stronghold);
        register(Structures.trail_chamber);
    }

}
