package vanilla.wildsregrown.registries.landforms.highlands;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;

public class Plateau extends Landform {

    public Plateau() {
        super(0.33f, Placement.Elevation.highland, Climate.coolDesert, Climate.hotDesert, Climate.hotScrubland, Climate.savanna, Climate.chaparral, Climate.steppe);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        Noise surface = NoiseGenerator.perlin(seed.next(), 128)
                .fbm(3);
        Noise valleys = NoiseGenerator.simplex(seed.next(), 1024)
                .ridged(3).invert()
                .map(MapType.quintic, 0.44f, 0.95f);
        Noise mask = Constant.of(edge).map(MapType.hermite, 0f, 0.32f);

        return valleys.lerp(surface, 0.22f).multiply(mask);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
