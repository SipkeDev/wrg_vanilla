package wildsregrown.vanilla.registry.biomes;

import com.sipke.NoiseGenerator;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;


public class Swamp extends WRGBiome {

    public Swamp() {
        super(vanillaId, "swamp");
        register(VanillaStructures.swamp_hut);
    }

    @Override
    public Noise surfaceNoise(Seed seed, float value) {
        return NoiseGenerator.perlin(seed.next(), 256).fbm(3).range(-0.5f, 0.5f);
    }

}