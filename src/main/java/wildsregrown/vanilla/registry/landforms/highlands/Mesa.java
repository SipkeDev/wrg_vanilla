package wildsregrown.vanilla.registry.landforms.highlands;

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

public class Mesa extends Landform {

    public Mesa() {
        super(modid, "mesa",0.5f, Placement.Elevation.highland, Climate.coolShrubland, Climate.hotScrubland, Climate.savanna, Climate.chaparral);
        register(new StratumConfig(VanillaMaterials.tuff.getIndex(), 24, 55, 1));
        register(new StratumConfig(VanillaMaterials.red_sandstone.getIndex(), 4, 8, 2));
        register(new StratumConfig(VanillaMaterials.sandstone.getIndex(), 12, 32, 4));
        register(new StratumConfig(VanillaMaterials.granite.getIndex(), 5, 12, 1));
    }

    @Override
    public Noise elevation(Seed seed, float edge, float value) {
        seed.reset();

        Noise mask = NoiseGenerator.simplex(seed.next(), 850)
                .map(MapType.hermite, 0.25f, 0.5f);

        Noise underlayer = NoiseGenerator.simplex(seed.next(), 450)
                .fbm(3, 3.8f, 0.5f, 0.5f)
                .warp(seed.next(), 250, 250)
                .add(NoiseGenerator.simplex(seed.next(), 64).multiply(0.175f))
                .multiply(0.2f);

        Noise upperlayer = NoiseGenerator.simplex(seed.next(), 500)
                .warp(seed.next(), 180, 120)
                .ridged(3, 2.5f, 0.5f, 0.5f)
                .fbm(2)
                .boost(2);

        return mask.blend(underlayer, upperlayer, 0.25f, 1f, MapType.almostUnitIdentity)
                .multiply(NoiseGenerator.constant(edge).map(MapType.hermite));
    }

    @Override
    public Noise depthNoise(int iteration) {
        return NoiseGenerator.perlin(iteration, 256);
    }

}
