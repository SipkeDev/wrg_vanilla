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

public class DesertRidge extends Landform {

    public DesertRidge() {
        super(1f, Placement.Elevation.mountain, Climate.hotDesert, Climate.coolDesert, Climate.savanna, Climate.coolScrubland, Climate.hotScrubland);
        register(new StratumConfig(Materials.tuff.getKey(), 24, 55, 1));
        register(new StratumConfig(Materials.red_sandstone.getKey(), 4, 8, 2));
        register(new StratumConfig(Materials.sandstone.getKey(), 12, 32, 4));
        register(new StratumConfig(Materials.granite.getKey(), 5, 12, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 512)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.12f);

        return NoiseGenerator.perlin(seed.next(), 1512).fbm(5)
                .scalebias(0.8f, 0.2f)
                .subtract(erosion);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
