package vanilla.wildsregrown.registries.biomes;

import com.sipke.NoiseGenerator;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Structures;


public class Swamp extends VanillaBiome {

    public Swamp() {
        super("swamp");
        register(Structures.swamp_hut);
    }

    @Override
    public Noise surfaceNoise(Seed seed, float value) {
        return NoiseGenerator.perlin(seed.next(), 256).fbm(3).range(-0.5f, 0.5f);
    }

}