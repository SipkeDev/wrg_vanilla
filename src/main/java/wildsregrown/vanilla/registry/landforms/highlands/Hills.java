package wildsregrown.vanilla.registry.landforms.highlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Hills extends Landform {

    public Hills() {
        super(modid, "hills",0.5f, Placement.Elevation.highland, Climate.ice, Climate.polarDesert, Climate.tundra, Climate.deciduousForest, Climate.coniferousForest, Climate.mixedForest, Climate.steppe, Climate.chaparral);
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();
        return NoiseGenerator.simplex(seed.next(), 768)
                .fbm(6, 1.8f, 0.5f, 0.5f)
                .warp(seed.next(), 384, 384)
                .map(MapType.hermite, 0.25f, 0.85f)
                .multiply(edge)
                ;
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
