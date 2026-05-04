package wildsregrown.vanilla.registry.api;

import wildsregrown.vanilla.registry.VanillaMaterials;

public class VanillaBiomeGrass extends VanillaBiome{

    public VanillaBiomeGrass(String name) {
        super(name);
        setSurface(VanillaMaterials.grass, 3);
    }

}
