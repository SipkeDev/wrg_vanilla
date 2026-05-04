package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class DensePlains extends WRGBiome {

    public DensePlains() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 5);
        register(VanillaFloras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.cornflower, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaFloras.allium, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaFloras.oxeye_daisy, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaFloras.poppy, FloraSpawnRule.rare, 0, 0, false);
    }

}
