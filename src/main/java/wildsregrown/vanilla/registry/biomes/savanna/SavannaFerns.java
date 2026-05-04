package wildsregrown.vanilla.registry.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class SavannaFerns extends WRGBiome {

    public SavannaFerns() {
        super(vanillaId,"savanna");
        setSurface(VanillaMaterials.dirt, 2);
        register(VanillaFloras.grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.fern, FloraSpawnRule.small_groups, 0, 0, false);
        register(VanillaFloras.tall_grass, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.village);
        register(VanillaStructures.walled_village);
    }

}
