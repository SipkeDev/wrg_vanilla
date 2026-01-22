package vanilla.wildsregrown.landforms;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

import static com.sipke.WorldConstants.landformFactor;

public class Shallows extends Landform {

    public Shallows() {
        super(landformFactor*0.08f, Placement.Elevation.coast, Climate.tundra, Climate.coniferousForest, Climate.mixedForest, Climate.deciduousForest, Climate.steppe, Climate.polarDesert);
        register(new StratumConfig(Materials.stone.getKey(), 5, 24, 5));
        register(new StratumConfig(Materials.sandstone.getKey(), 3, 5, 2));
        register(new StratumConfig(Materials.red_sandstone.getKey(), 3, 5, 2));
        register(new StratumConfig(Materials.deepslate.getKey(), 3, 5, 2));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();
        return NoiseGenerator.perlin(seed.next(), 32)
                .fbm(3)
                .warp(seed.next(), 32, 32)
                .multiply(edge);

    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
