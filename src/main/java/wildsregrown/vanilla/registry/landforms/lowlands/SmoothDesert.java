package wildsregrown.vanilla.registry.landforms.lowlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class SmoothDesert extends Landform {

    public SmoothDesert() {
        super(modid, "smooth_desert",0.25f, Placement.Elevation.lowland, Climate.hotDesert, Climate.coolDesert);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.cubic(seed.next(), 480)
                .pingpong(3, 1.95f, 0.5f, 0.43f, 1f)
                .boost(5);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 384);
    }

}
