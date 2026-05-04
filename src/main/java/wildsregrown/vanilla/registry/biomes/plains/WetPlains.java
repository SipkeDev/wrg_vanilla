package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class WetPlains extends WRGBiome {

    public WetPlains() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 5);
        register(VanillaFloras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(VanillaFloras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.blue_orchid, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.torch_flower, FloraSpawnRule.rare, 0, 0, false);
    }

}
