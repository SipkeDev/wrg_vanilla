package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class BlueFlowerPlains extends VanillaBiome {

    public BlueFlowerPlains() {
        super("plains");
        setSurface(Materials.dirt, 5);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.blue_orchid, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.mineshaft);
    }

}
