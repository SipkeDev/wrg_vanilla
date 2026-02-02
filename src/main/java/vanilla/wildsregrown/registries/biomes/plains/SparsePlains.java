package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class SparsePlains extends VanillaBiome {

    public SparsePlains() {
        super("plains");
        setSurface(Materials.dirt, 2);
        register(Floras.lily_of_the_valley, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.pillager_outpost);
        register(Structures.mineshaft);
    }

}
