package vanilla.wildsregrown.registries.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import com.sipke.api.features.structures.Structure;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class Savanna extends VanillaBiome {

    public Savanna() {
        super("savanna");
        setSurface(Materials.dirt, 2);
        register(Floras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Structures.village);
        register(Structures.walled_village);
    }

}
