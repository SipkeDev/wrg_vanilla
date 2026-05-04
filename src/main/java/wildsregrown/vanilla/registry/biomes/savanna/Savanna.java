package wildsregrown.vanilla.registry.biomes.savanna;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class Savanna extends WRGBiome {

    public Savanna() {
        super(vanillaId,"savanna");
        setSurface(VanillaMaterials.dirt, 2);
        register(VanillaFloras.grass, FloraSpawnRule.grouped, 0, 0, false);
        register(VanillaStructures.village);
        register(VanillaStructures.walled_village);
    }

}
