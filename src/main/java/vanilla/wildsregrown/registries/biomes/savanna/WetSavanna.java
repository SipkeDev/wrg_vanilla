package vanilla.wildsregrown.registries.biomes.savanna;

import com.sipke.NoiseGenerator;
import com.sipke.api.features.flora.FloraSpawnRule;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class WetSavanna extends VanillaBiome {

    public WetSavanna() {
        super("savanna");
        setSurface(Materials.dirt, 2);
        register(Floras.grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(Floras.tall_grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.tall_fern, FloraSpawnRule.rare, 0, 0, false);
        register(Structures.village);
        register(Structures.walled_village);
        register(Structures.trail_ruins);
    }

    @Override
    public Noise surfaceNoise(Seed seed, float value) {
        return NoiseGenerator.perlin(seed.next(), 64).fbm(3);
    }

}
