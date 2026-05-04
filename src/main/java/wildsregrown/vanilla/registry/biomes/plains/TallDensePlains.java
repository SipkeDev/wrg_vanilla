package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class TallDensePlains extends WRGBiome {

    public TallDensePlains() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 5);
        register(VanillaFloras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.dotted, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.tall_fern, FloraSpawnRule.rare, 0, 0, false);
    }

}
