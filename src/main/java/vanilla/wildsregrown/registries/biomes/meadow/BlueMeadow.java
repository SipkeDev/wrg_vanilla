package vanilla.wildsregrown.registries.biomes.meadow;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class BlueMeadow extends VanillaBiome {

    public BlueMeadow() {
        super("plains");
        setSurface(Materials.dirt, 3);
        register(Floras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.blue_orchid, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.lily_of_the_valley, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.mineshaft);
        register(Structures.swamp_hut);
    }

}
