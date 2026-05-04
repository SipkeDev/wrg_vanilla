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

public class IgneiousMountain extends Landform {

    public IgneiousMountain() {
        super(modid, "igneous_mountain",0.92f, Placement.Elevation.mountain, Climate.chaparral, Climate.coniferousForest, Climate.polarDesert, Climate.tundra, Climate.hotScrubland, Climate.coolShrubland, Climate.mixedForest, Climate.coniferousForest, Climate.steppe);
        register(new StratumConfig(VanillaMaterials.stone.getIndex(), 24, 70, 3));
        register(new StratumConfig(VanillaMaterials.granite.getIndex(), 24, 48, 2));
        register(new StratumConfig(VanillaMaterials.andesite.getIndex(), 24, 32, 1));
        register(new StratumConfig(VanillaMaterials.diorite.getIndex(), 8, 16, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 128)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.032f);

        return NoiseGenerator.cubic(seed.next(), 950)
                .fbm(5)
                .subtract(erosion)
                .add(NoiseGenerator.perlin(seed.next(), 384).fbm(3).multiply(0.12f))
                ;
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
