package wildsregrown.vanilla.registry.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class DrySavanna extends WRGBiome {

    public DrySavanna() {
        super(vanillaId, "savanna_plateau");
        setSurface(VanillaMaterials.coarse_dirt, 1);
        register(VanillaFloras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.village);
        register(VanillaStructures.walled_village);
        register(VanillaStructures.trail_chamber);
    }

}
