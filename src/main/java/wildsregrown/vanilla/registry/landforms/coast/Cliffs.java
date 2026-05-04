package wildsregrown.vanilla.registry.landforms.coast;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaMaterials;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Cliffs extends Landform {

    public Cliffs() {
        super(modid, "cliffs",0.28f, Placement.Elevation.coast, Climate.all_land);
        register(new StratumConfig(VanillaMaterials.stone.getIndex(), 5, 32, 2));
        register(new StratumConfig(VanillaMaterials.tuff.getIndex(), 5, 32, 2));
        register(new StratumConfig(VanillaMaterials.calcite.getIndex(), 2, 5, 2));
        register(new StratumConfig(VanillaMaterials.sandstone.getIndex(), 20, 30, 4));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();
       Noise mask = NoiseGenerator.simplex(seed.next(), 1200)
                .ridged(5, 1.55f, 0.5f, 0.5f);

        return NoiseGenerator.perlin(seed.next(), 512)
                .fbm(3, 1.85f, 0.5f,0.5f)
                .warp(seed.next(), 256, 128)
                .warp(seed.next(), 128, 64)
                .multiply(mask.invert())
                .range(-0.125f, 1f);

    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
