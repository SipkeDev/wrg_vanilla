package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class BlueFlowerPlains extends WRGBiome {

    public BlueFlowerPlains() {
        super(vanillaId, "plains");
        setSurface(VanillaMaterials.dirt, 5);
        register(VanillaFloras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(VanillaFloras.blue_orchid, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.mineshaft);
    }

}
