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

public class Islands extends Landform {

    public Islands() {
        super(0.43f, Placement.Elevation.ocean, Climate.coldOcean, Climate.temperateOcean, Climate.warmOcean);
        register(new StratumConfig(Materials.stone.getKey(), 24, 50, 3));
        register(new StratumConfig(Materials.basalt.getKey(), 4, 8, 1));
        register(new StratumConfig(Materials.calcite.getKey(), 5, 12, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.cubic(seed.next(), 512)
                .fbm(5)
                .steps(8, 0.785f)
                .map(MapType.hermite, 0.125f, 0.785f)
                .multiply(0.9f)
                .add(
                        NoiseGenerator.perlin(seed.next(), 128)
                        .fbm(3)
                                .multiply(0.12f)
                );
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
