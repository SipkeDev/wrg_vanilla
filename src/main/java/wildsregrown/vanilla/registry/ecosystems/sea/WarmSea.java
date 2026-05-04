package wildsregrown.vanilla.registry.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class WarmSea extends Ecosystem {

    public WarmSea() {
        super(modid, "warm_sea", Climate.warmSea, VanillaBiomes.warm_ocean);
        register(Placement.Biome.normal, VanillaBiomes.lukewarm_ocean);
    }

}
