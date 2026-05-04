package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class DryPlains extends WRGBiome {

    public DryPlains() {
        super(vanillaId, "plains");
        setSurface(VanillaMaterials.coarse_dirt, 1);
        register(VanillaFloras.fern, FloraSpawnRule.dotted, 0, 0, false);
    }

}
