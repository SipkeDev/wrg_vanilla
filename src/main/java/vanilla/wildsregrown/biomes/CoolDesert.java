package vanilla.wildsregrown.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Materials;

public class CoolDesert extends VanillaBiome {

    public CoolDesert() {
        super("desert");
        setOvergrown(false);
        setSurface(Materials.coarse_dirt, 3);
    }

}
