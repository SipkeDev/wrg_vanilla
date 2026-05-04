package wildsregrown.vanilla.registry.landforms.lowlands;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaMaterials;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Plains extends Landform {

    public Plains() {
        super(modid, "plains",0.12f, Placement.Elevation.lowland, Climate.all_land);
        register(new StratumConfig(VanillaMaterials.stone.getIndex(), 5, 24, 5));
        register(new StratumConfig(VanillaMaterials.deepslate.getIndex(), 5, 12, 2));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();

        Noise selector = NoiseGenerator.simplex(seed.next(), 320);
        Noise high = NoiseGenerator.cubic(seed.next(), 138);
        Noise low = NoiseGenerator.simplex(seed.next(), 77).multiply(0.4f);

        return selector.blend(high,low).warp(seed.next(), 128, 64);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
