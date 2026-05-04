package wildsregrown.vanilla.registry.api;

import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaBiome extends WRGBiome {

    public VanillaBiome(String name) {
        super(vanillaId, name);
    }

}
