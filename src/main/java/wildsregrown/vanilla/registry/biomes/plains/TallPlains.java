package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class TallPlains extends WRGBiome {

    public TallPlains() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 3);
        register(VanillaFloras.tall_grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(VanillaFloras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.dotted, 0, 0, false);
        register(VanillaStructures.mineshaft);
    }

}
