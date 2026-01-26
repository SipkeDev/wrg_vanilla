package vanilla.wildsregrown.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Materials;

public class HotDesert extends VanillaBiome {

    public HotDesert() {
        super("desert");
        setOvergrown(false);
        setSurface(Materials.sand, 8);
    }

}
