package vanilla.wildsregrown.registries.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class RedDesert extends VanillaBiome {

    public RedDesert() {
        super("desert");
        setOvergrown(false);
        setSurface(Materials.red_sand, 8);
        register(Structures.mineshaft);
        register(Structures.ruined_portal);
        register(Structures.trail_chamber);
    }

}
