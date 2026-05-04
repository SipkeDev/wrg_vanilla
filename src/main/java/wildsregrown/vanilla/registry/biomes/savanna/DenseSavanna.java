package wildsregrown.vanilla.registry.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class DenseSavanna extends WRGBiome {

    public DenseSavanna() {
        super(vanillaId,"savanna");
        setSurface(VanillaMaterials.dirt, 2);
        register(VanillaFloras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.village);
        register(VanillaStructures.walled_village);
        register(VanillaStructures.trail_ruins);
    }

}
