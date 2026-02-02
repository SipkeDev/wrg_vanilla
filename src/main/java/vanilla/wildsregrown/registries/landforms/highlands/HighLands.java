package vanilla.wildsregrown.registries.landforms.highlands;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import com.sipke.noise2d.warp.GradientWarp;
import vanilla.wildsregrown.registries.Materials;

public class HighLands extends Landform {

    public HighLands() {
        super(0.5f, Placement.Elevation.highland, Climate.tundra, Climate.steppe, Climate.polarDesert);
        register(new StratumConfig(Materials.stone.getKey(), 24, 50, 5));
        register(new StratumConfig(Materials.tuff.getKey(), 3, 5, 2));
        register(new StratumConfig(Materials.deepslate.getKey(), 12, 24, 2));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        Noise erosion = NoiseGenerator.perlin(seed.next(), 320)
                .ridged(3, 2.8f, 0.5f, 0.5f)
                .warp(new GradientWarp(seed.next(), 256), 128)
                .multiply(0.08f);

        return NoiseGenerator.perlin(seed.next(), 800)
                .steps(8,
                        NoiseGenerator.simplexFast(seed.next(), 500).map(0f, 0.4f))
                .warp(new GradientWarp(seed.next(), 1200), 512)
                .fbm(6, 2.2f, 0.6f, 0.5f)
                .warp(new GradientWarp(seed.next(), 512), 128)
                .subtract(erosion)
                .map(MapType.almostUnitIdentity, 0.1f, 0.9f)
                .multiply(Constant.of(edge).map(MapType.quintic, 0, 0.7f))
                ;
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
