package wildsregrown.vanilla.registry.landforms.coast;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.CellType;
import com.sipke.math.Distance;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Dunes extends Landform {

    public Dunes() {
        super(modid, "dunes",0.18f, Placement.Elevation.coast, Climate.all_land);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.voronoi(seed.next(), 384, Distance.hybrid, CellType.distance2Div, 0.75f, true)
                .fbm(3)
                .invert()
                .warp(seed.next(), 220, 80)
                .warp(seed.next(), 80, 44);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
