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

public class IgneiousMountain extends Landform {

    public IgneiousMountain() {
        super(0.92f, Placement.Elevation.mountain, Climate.chaparral, Climate.coniferousForest, Climate.polarDesert, Climate.tundra, Climate.hotScrubland, Climate.coolScrubland, Climate.mixedForest, Climate.coniferousForest, Climate.steppe);
        register(new StratumConfig(Materials.stone.getKey(), 24, 70, 3));
        register(new StratumConfig(Materials.granite.getKey(), 24, 48, 2));
        register(new StratumConfig(Materials.andesite.getKey(), 24, 32, 1));
        register(new StratumConfig(Materials.diorite.getKey(), 8, 16, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 128)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.12f);

        return NoiseGenerator.cubic(seed.next(), 880)
                .fbm(5)
                .subtract(erosion)
                .add(NoiseGenerator.perlin(seed.next(), 256).fbm(3).multiply(0.12f))
                ;
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
