package wildsregrown.vanilla.registry.landforms.highlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Plateau extends Landform {

    public Plateau() {
        super(modid, "plateau",0.22f, Placement.Elevation.highland, Climate.hotScrubland, Climate.coolShrubland);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        Noise surface = NoiseGenerator.perlin(seed.next(), 256)
                .fbm(3, 2.25f, 0.5f, 0.5f);
        Noise valleys = NoiseGenerator.simplex(seed.next(), 768)
                .ridged(5).invert();

        return valleys.lerp(surface, 0.16f);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
