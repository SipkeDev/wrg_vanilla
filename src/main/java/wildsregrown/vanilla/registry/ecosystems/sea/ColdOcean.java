package wildsregrown.vanilla.registry.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class ColdOcean extends Ecosystem {

    public ColdOcean() {
        super(modid, "cold_ocean", Climate.coldOcean, VanillaBiomes.deep_cold_ocean);
        register(Placement.Biome.normal, VanillaBiomes.cold_ocean);
        register(Placement.Biome.normal, VanillaBiomes.frozen_ocean);
        register(Placement.Biome.normal, VanillaBiomes.deep_frozen_ocean);
    }

}
