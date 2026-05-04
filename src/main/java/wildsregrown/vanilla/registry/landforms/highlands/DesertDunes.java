package wildsregrown.vanilla.registry.landforms.highlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class DesertDunes extends Landform {

    public DesertDunes() {
        super(modid, "desert_dunes",0.32f, Placement.Elevation.highland, Climate.coolDesert, Climate.hotDesert);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.cubic(seed.next(), 384)
                .pingpong(5, 1.85f, 0.5f, 0.43f, 1f)
                .boost(3);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 512);
    }

}
