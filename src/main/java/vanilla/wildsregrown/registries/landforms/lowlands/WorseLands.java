package vanilla.wildsregrown.registries.landforms.lowlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class WorseLands extends Landform {

    public WorseLands() {
        super(0.32f, Placement.Elevation.lowland, Climate.coolDesert, Climate.hotScrubland, Climate.coolScrubland, Climate.savanna, Climate.chaparral, Climate.steppe);
        register(new StratumConfig(Materials.tuff.getKey(), 24, 55, 1));
        register(new StratumConfig(Materials.red_sandstone.getKey(), 4, 8, 2));
        register(new StratumConfig(Materials.sandstone.getKey(), 12, 32, 4));
        register(new StratumConfig(Materials.granite.getKey(), 5, 12, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        Noise selector = NoiseGenerator.simplex(seed.next(), 320)
                .warp(seed.next(), 128, 64);

        Noise high = NoiseGenerator.cubic(seed.next(), 138)
                .fbm(3, 2.6f, 0.6f, 0.6f);

        Noise low = NoiseGenerator.simplex(seed.next(), 77)
                .fbm(3, 2.6f, 0.6f, 0.6f)
                .multiply(0.4f);

        return selector.blend(high,low);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
