package wildsregrown.vanilla.registry.biomes;

import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class HotDesert extends WRGBiome {

    public HotDesert() {
        super(vanillaId, "desert");
        setOvergrown(false);
        setSurface(VanillaMaterials.sand, 14);
        register(VanillaStructures.mineshaft);
        register(VanillaStructures.desert_pyramid);
        register(VanillaStructures.stronghold);
        register(VanillaStructures.buried_treasure);
    }

}
