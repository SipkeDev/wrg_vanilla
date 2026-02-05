package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import com.sipke.api.features.structures.Structure;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class Plains extends VanillaBiome {

    public Plains() {
        super("plains");
        setSurface(Materials.dirt, 3);
        register(Floras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(Floras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.allium, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.mineshaft);
        register(Structures.stronghold);
        register(Structures.walled_pillager_outpost);
    }

}
