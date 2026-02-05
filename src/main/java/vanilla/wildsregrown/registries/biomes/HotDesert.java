package vanilla.wildsregrown.registries.biomes;

import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class HotDesert extends VanillaBiome {

    public HotDesert() {
        super("desert");
        setOvergrown(false);
        setSurface(Materials.sand, 8);
        register(Structures.mineshaft);
        register(Structures.desert_pyramid);
        register(Structures.stronghold);
        register(Structures.buried_treasure);
    }

}
