package vanilla.wildsregrown.registries.landforms.ocean;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class Basin extends Landform {

    public Basin() {
        super(0f, Placement.Elevation.ocean, Climate.coldOcean, Climate.temperateOcean, Climate.warmOcean);
        register(new StratumConfig(Materials.basalt.getKey(), 24, 50, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return Constant.of(0f);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
