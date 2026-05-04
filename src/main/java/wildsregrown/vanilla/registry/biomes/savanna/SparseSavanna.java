package wildsregrown.vanilla.registry.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class SparseSavanna extends WRGBiome {

    public SparseSavanna() {
        super(vanillaId,"savanna_plateau");
        setSurface(VanillaMaterials.dirt, 2);
        register(VanillaFloras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.village);
        register(VanillaStructures.walled_village);
        register(VanillaStructures.ruined_portal);
        register(VanillaStructures.stronghold);
        register(VanillaStructures.trail_chamber);
    }

}
