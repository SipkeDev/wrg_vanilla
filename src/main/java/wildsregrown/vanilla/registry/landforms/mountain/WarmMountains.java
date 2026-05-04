package wildsregrown.vanilla.registry.landforms.mountain;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaMaterials;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class WarmMountains extends Landform {

    public WarmMountains() {
        super(modid, "warm_mountains",1f, Placement.Elevation.mountain, Climate.hotDesert, Climate.coolDesert, Climate.savanna, Climate.coolShrubland, Climate.hotScrubland);
        register(new StratumConfig(VanillaMaterials.stone.getIndex(), 12, 34, 1));
        register(new StratumConfig(VanillaMaterials.red_sandstone.getIndex(), 4, 24, 2));
        register(new StratumConfig(VanillaMaterials.sandstone.getIndex(), 12, 55, 4));
        register(new StratumConfig(VanillaMaterials.granite.getIndex(), 5, 12, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 512)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.015f);

        return NoiseGenerator.perlin(seed.next(), 1512)
                .ridged(5, 1.55f, 0.6f, 0.35f)
                .scalebias(0.8f, 0.2f)
                .subtract(erosion);
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
