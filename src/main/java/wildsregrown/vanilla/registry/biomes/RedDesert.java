package wildsregrown.vanilla.registry.biomes;

import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class RedDesert extends WRGBiome {

    public RedDesert() {
        super(vanillaId, "desert");
        setOvergrown(false);
        setSurface(VanillaMaterials.red_sand, 6);
        register(VanillaStructures.mineshaft);
        register(VanillaStructures.ruined_portal);
        register(VanillaStructures.trail_chamber);
    }

}
