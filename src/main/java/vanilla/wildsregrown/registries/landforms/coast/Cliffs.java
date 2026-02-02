package vanilla.wildsregrown.registries.landforms.coast;

import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.geology.StratumConfig;
import com.sipke.api.terrain.Landform;
import com.sipke.core.Seed;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import vanilla.wildsregrown.registries.Materials;

public class Cliffs extends Landform {

    public Cliffs() {
        super(0.4f, Placement.Elevation.coast, Climate.tundra, Climate.coniferousForest, Climate.mixedForest, Climate.deciduousForest, Climate.ancientForest, Climate.spiritForest, Climate.steppe, Climate.tundra, Climate.polarDesert, Climate.ice);
        register(new StratumConfig(Materials.stone.getKey(), 5, 32, 2));
        register(new StratumConfig(Materials.tuff.getKey(), 5, 32, 2));
        register(new StratumConfig(Materials.calcite.getKey(), 2, 5, 2));
        register(new StratumConfig(Materials.sandstone.getKey(), 20, 30, 4));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();
       Noise mask = NoiseGenerator.simplex(seed.next(), 1800)
                .ridged(5, 2.25f, 0.5f, 0.5f)
                .map(MapType.hermite, 0.125f, 0.65f);

        return NoiseGenerator.perlin(seed.next(), 512)
                .fbm(3, 2.25f, 0.5f,0.5f)
                .warp(seed.next(), 256, 256)
                .warp(seed.next(), 128, 128)
                .multiply(mask.invert())
                .range(-0.125f, edge);

    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
