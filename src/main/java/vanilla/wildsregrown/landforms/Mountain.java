package vanilla.wildsregrown.landforms;

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

import static com.sipke.WorldConstants.landformFactor;

public class Mountain extends Landform {

    public Mountain() {
        super(landformFactor, Placement.Elevation.mountain, Climate.chaparral, Climate.coniferousForest, Climate.polarDesert, Climate.tundra);
        register(new StratumConfig(Materials.stone.getKey(), 12, 34, 5));
        register(new StratumConfig(Materials.sandstone.getKey(), 3, 5, 2));
        register(new StratumConfig(Materials.deepslate.getKey(), 5, 24, 2));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 384)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.12f);

        return NoiseGenerator.perlin(seed.next(), 768).fbm(5)
                .scalebias(0.6f, 0.4f)
                .subtract(erosion)
                .multiply(Constant.of(edge).map(MapType.almostUnitIdentity, 0.002f, 0.98f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
