package vanilla.wildsregrown.registries.landforms.ocean;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class Abyss extends Landform {

    public Abyss() {
        super(0.02f, Placement.Elevation.ocean, Climate.coldOcean, Climate.temperateOcean, Climate.warmOcean);
        register(new StratumConfig(Materials.basalt.getKey(), 24, 50, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.cubic(seed.next(), 1024)
                .fbm(3)
                .warp(seed.next(), 250, 250)
                .map(MapType.inverseQuintic, 0.25f, 0.38f);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
