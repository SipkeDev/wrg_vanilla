package vanilla.wildsregrown.landforms;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class MountainRidge extends Landform {

    public MountainRidge() {
        super(1f, Placement.Elevation.mountain, Climate.chaparral, Climate.coniferousForest, Climate.polarDesert, Climate.tundra, Climate.hotScrubland, Climate.coolScrubland, Climate.mixedForest, Climate.coniferousForest, Climate.steppe);
        register(new StratumConfig(Materials.stone.getKey(), 12, 34, 5));
        register(new StratumConfig(Materials.black_stone.getKey(), 5, 12, 1));
        register(new StratumConfig(Materials.calcite.getKey(), 2, 4, 1));
        register(new StratumConfig(Materials.granite.getKey(), 2, 4, 1));
        register(new StratumConfig(Materials.andesite.getKey(), 2, 4, 1));
        register(new StratumConfig(Materials.diorite.getKey(), 2, 4, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 384)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.12f);

        return NoiseGenerator.perlin(seed.next(), 2200)
                .ridged(5)
                .subtract(erosion)
                .multiply(Constant.of(edge).map(MapType.almostUnitIdentity, 0.002f, 0.88f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
