package wildsregrown.vanilla.registry.biomes;

import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;

import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class CoolDesert extends WRGBiome {

    public CoolDesert() {
        super(vanillaId, "desert");
        setOvergrown(false);
        setSurface(VanillaMaterials.sand, 5);
        register(VanillaStructures.desert_pyramid);
        register(VanillaStructures.mineshaft);
        register(VanillaStructures.trail_ruins);
        register(VanillaStructures.buried_treasure);
    }

}
