package wildsregrown.vanilla.registry.biomes.meadow;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class BlueMeadow extends WRGBiome {

    public BlueMeadow() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 3);
        register(VanillaFloras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaFloras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.blue_orchid, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.lily_of_the_valley, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.mineshaft);
        register(VanillaStructures.swamp_hut);
    }

}
