package vanilla.wildsregrown.registries.biomes.meadow;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class RedMeadow extends VanillaBiome {

    public RedMeadow() {
        super("plains");
        setSurface(Materials.dirt, 3);
        register(Floras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.poppy, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.red_tulip, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.allium, FloraSpawnRule.occasional, 0, 0, false);
        register(Structures.mineshaft);
        register(Structures.swamp_hut);
        register(Structures.ruined_portal);
    }

}
