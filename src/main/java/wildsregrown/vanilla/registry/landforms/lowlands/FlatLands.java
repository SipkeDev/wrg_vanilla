package wildsregrown.vanilla.registry.landforms.lowlands;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class FlatLands extends Landform {

    public FlatLands() {
        super(modid, "flat_lands",0f, Placement.Elevation.lowland, Climate.all_land);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return Constant.of(0);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.simplex(iteration, 512);
    }

}
