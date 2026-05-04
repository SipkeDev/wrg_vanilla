package wildsregrown.vanilla.registry.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import wildsregrown.vanilla.registry.VanillaFloras;
import wildsregrown.vanilla.registry.VanillaMaterials;
import wildsregrown.vanilla.registry.VanillaStructures;
import wildsregrown.api.registry.registerables.WRGBiome;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class SparsePlains extends WRGBiome {

    public SparsePlains() {
        super(vanillaId,"plains");
        setSurface(VanillaMaterials.dirt, 2);
        register(VanillaFloras.lily_of_the_valley, FloraSpawnRule.rare, 0, 0, false);
        register(VanillaStructures.pillager_outpost);
        register(VanillaStructures.mineshaft);
    }

}
