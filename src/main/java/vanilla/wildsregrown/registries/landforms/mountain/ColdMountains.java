package vanilla.wildsregrown.registries.landforms.mountain;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class ColdMountains extends Landform {

    public ColdMountains() {
        super(1f, Placement.Elevation.mountain, Climate.ice, Climate.tundra, Climate.polarDesert);
        register(new StratumConfig(Materials.stone.getKey(), 12, 24, 2));
        register(new StratumConfig(Materials.black_stone.getKey(), 12, 34, 5));
        register(new StratumConfig(Materials.calcite.getKey(), 4, 8, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 384)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.12f);

        return NoiseGenerator.perlin(seed.next(), 1200).fbm(5)
                .scalebias(0.3f, 0.7f)
                .subtract(erosion);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
