package wildsregrown.vanilla.registry.landforms.mountain;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import wildsregrown.vanilla.registry.VanillaMaterials;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Mountain extends Landform {

    public Mountain() {
        super(modid, "mountain",1f, Placement.Elevation.mountain, Climate.chaparral, Climate.steppe, Climate.coolShrubland, Climate.mixedForest);
        register(new StratumConfig(VanillaMaterials.stone.getIndex(), 12, 34, 5));
        register(new StratumConfig(VanillaMaterials.sandstone.getIndex(), 3, 5, 2));
        register(new StratumConfig(VanillaMaterials.deepslate.getIndex(), 5, 24, 2));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 512)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.025f);

        Noise shape = Constant.of(edge);
        return shape.multiply(0.88f)
                .subtract(erosion)
                .add(shape.map(MapType.almostUnitIdentity,0.82f, 1f).multiply(0.12f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
