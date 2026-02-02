package vanilla.wildsregrown.registries.landforms.highlands;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.CellType;
import com.sipke.math.Distance;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;

public class GrandCanyon extends Landform {

    public GrandCanyon() {
        super(0.5f, Placement.Elevation.highland, Climate.savanna, Climate.chaparral, Climate.hotScrubland);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();

        return NoiseGenerator.voronoi(seed.next(), 1800, Distance.chebyShev, CellType.distance2Div, 0.6f, false)
                .warp(seed.next(), 500, 500)
                .invert()
                .map(MapType.hermite, 0.15f, 0.65f)
                .steps(6,
                        NoiseGenerator.simplex(seed.next(), 512),
                        NoiseGenerator.simplex(seed.next(), 768).scalebias(0.25f, 0.25f),
                        NoiseGenerator.simplex(seed.next(), 512).scalebias(0.25f, 0.75f),
                        0.12f
                )
                .multiply(Constant.of(edge).map(MapType.almostUnitIdentity, 0.08f, 0.75f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
