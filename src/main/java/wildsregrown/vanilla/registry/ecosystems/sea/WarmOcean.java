package wildsregrown.vanilla.registry.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class WarmOcean extends Ecosystem {

    public WarmOcean() {
        super(modid, "warm_ocean", Climate.warmOcean, VanillaBiomes.warm_ocean);
        register(Placement.Biome.normal, VanillaBiomes.deep_lukewarm_ocean);
    }

}
