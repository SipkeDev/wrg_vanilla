package wildsregrown.vanilla.registry.landforms.coast;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Beach extends Landform {

    public Beach() {
        super(modid, "beach",0.175f, Placement.Elevation.coast, Climate.all_land);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.cubic(seed.next(), 384)
                .fbm(5, 1.45f, 0.45f, 0.38f)
                .multiply(Constant.of(edge).map(MapType.almostUnitIdentity, 0.215f, 0.57f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 180);
    }

}
