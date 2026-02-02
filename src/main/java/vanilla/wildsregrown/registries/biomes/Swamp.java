package vanilla.wildsregrown.registries.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Structures;


public class Swamp extends VanillaBiome {

    public Swamp() {
        super("swamp");
        register(Structures.swamp_hut);
    }

}