package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class PinkFlowerPlains extends VanillaBiome {

    public PinkFlowerPlains() {
        super("plains");
        setSurface(Materials.dirt, 5);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.allium, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.cornflower, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.mineshaft);
    }

}
