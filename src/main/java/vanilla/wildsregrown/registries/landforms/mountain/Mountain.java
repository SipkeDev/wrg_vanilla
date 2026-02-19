package vanilla.wildsregrown.registries.landforms.mountain;

import com.mojang.datafixers.types.templates.Const;
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

public class Mountain extends Landform {

    public Mountain() {
        super(1f, Placement.Elevation.mountain, Climate.chaparral, Climate.steppe, Climate.coolScrubland, Climate.mixedForest);
        register(new StratumConfig(Materials.stone.getKey(), 12, 34, 5));
        register(new StratumConfig(Materials.sandstone.getKey(), 3, 5, 2));
        register(new StratumConfig(Materials.deepslate.getKey(), 5, 24, 2));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {

        seed.reset();

        Noise erosion = NoiseGenerator.perlin(seed.next(), 384)
                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                .multiply(0.12f);

        Noise scale = Constant.of(edge).map(MapType.almostUnitIdentity, 0.002f, 0.88f).range(0.6f, 0.95f);
        return NoiseGenerator.perlin(seed.next(), 1500).fbm(5)
                .scalebias(scale, Constant.of(0.35f))
                .subtract(erosion)
                .add(NoiseGenerator.cubic(seed.next(), 384).fbm(3).multiply(0.125f));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 128);
    }

}
