package vanilla.wildsregrown.registries.biomes;

import com.sipke.NoiseGenerator;
import com.sipke.api.features.flora.FloraSpawnRule;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;


public class PeatSwamp extends VanillaBiome {

    public PeatSwamp() {
        super("swamp");
        setSurface(Materials.podzol, 8);
        register(Floras.tall_grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Structures.swamp_hut);
    }

    @Override
    public Noise surfaceNoise(Seed seed, float value) {
        return NoiseGenerator.perlin(seed.next(), 128).fbm(3);
    }

}