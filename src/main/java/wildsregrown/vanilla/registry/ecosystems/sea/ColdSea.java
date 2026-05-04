package wildsregrown.vanilla.registry.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class ColdSea extends Ecosystem {

    public ColdSea() {
        super(modid, "cold_sea", Climate.coldSea, VanillaBiomes.cold_ocean);
        register(Placement.Biome.normal, VanillaBiomes.frozen_ocean);
    }

}
