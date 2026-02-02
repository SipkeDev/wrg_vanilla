package vanilla.wildsregrown.registries.landforms.highlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class BadLands extends Landform {

    public BadLands() {
        super(0.45f, Placement.Elevation.highland, Climate.coolDesert, Climate.hotScrubland, Climate.coolScrubland, Climate.savanna, Climate.chaparral, Climate.steppe);
        register(new StratumConfig(Materials.tuff.getKey(), 24, 55, 1));
        register(new StratumConfig(Materials.red_sandstone.getKey(), 4, 8, 2));
        register(new StratumConfig(Materials.sandstone.getKey(), 12, 32, 4));
        register(new StratumConfig(Materials.granite.getKey(), 5, 12, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.perlin(seed.next(), 768)
                .warp(seed.next(), 250, 250)
                .ridged(2)
                .fbm(5, 2.5f, 0.5f, 0.5f)
                .steps(12,
                        NoiseGenerator.cubic(seed.next(), 250),
                        NoiseGenerator.simplex(seed.next(), 500).multiply(0.25f),
                        NoiseGenerator.simplex(seed.next(), 250).scalebias(0.5f, 0.5f),
                        0.35f
                )
                .multiply(NoiseGenerator.constant(edge).map(MapType.hermite, 0f, 0.65f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
