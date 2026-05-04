package wildsregrown.vanilla.registry.biomes;

import com.sipke.NoiseGenerator;
import com.sipke.api.features.flora.FloraSpawnRule;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;


public class PeatSwamp extends WRGBiome {

    public PeatSwamp() {
        super(vanillaId,"swamp");
        setSurface(VanillaMaterials.podzol, 8);
        register(VanillaFloras.tall_grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(VanillaStructures.swamp_hut);
    }

    @Override
    public Noise surfaceNoise(Seed seed, float value) {
        return NoiseGenerator.perlin(seed.next(), 128).fbm(3);
    }

}