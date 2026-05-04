package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class Plains extends WRGBiome {

    public Plains() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 3);
        register(VanillaFloras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaFloras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.allium, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.mineshaft);
        register(VanillaStructures.stronghold);
        register(VanillaStructures.walled_pillager_outpost);
    }

}
