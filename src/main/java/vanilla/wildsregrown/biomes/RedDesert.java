package vanilla.wildsregrown.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Materials;

public class RedDesert extends VanillaBiome {

    public RedDesert() {
        super("desert");
        setOvergrown(false);
        setSurface(Materials.red_sand, 8);
    }

}
