package wildsregrown.vanilla.registry.biomes.meadow;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class RedMeadow extends WRGBiome {

    public RedMeadow() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 3);
        register(VanillaFloras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaFloras.poppy, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.red_tulip, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.allium, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaStructures.mineshaft);
        register(VanillaStructures.swamp_hut);
        register(VanillaStructures.ruined_portal);
        register(VanillaStructures.walled_pillager_outpost);
    }

}
