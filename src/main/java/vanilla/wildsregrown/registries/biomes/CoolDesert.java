package vanilla.wildsregrown.registries.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class CoolDesert extends VanillaBiome {

    public CoolDesert() {
        super("desert");
        setOvergrown(false);
        setSurface(Materials.coarse_dirt, 3);
        register(Structures.desert_pyramid);
        register(Structures.mineshaft);
        register(Structures.trail_ruins);
        register(Structures.buried_treasure);
    }

}
