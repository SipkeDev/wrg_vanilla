package wildsregrown.vanilla.registry.biomes.savanna;

import com.sipke.NoiseGenerator;
import com.sipke.api.features.flora.FloraSpawnRule;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class WetSavanna extends WRGBiome {

    public WetSavanna() {
        super(vanillaId,"savanna");
        setSurface(VanillaMaterials.dirt, 2);
        register(VanillaFloras.grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.tall_fern, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.village);
        register(VanillaStructures.walled_village);
        register(VanillaStructures.trail_ruins);
    }

    @Override
    public Noise surfaceNoise(Seed seed, float value) {
        return NoiseGenerator.perlin(seed.next(), 64).fbm(3);
    }

}
