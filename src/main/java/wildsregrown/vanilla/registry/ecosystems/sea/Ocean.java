package wildsregrown.vanilla.registry.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Ocean extends Ecosystem {

    public Ocean() {
        super(modid, "ocean", Climate.temperateOcean, VanillaBiomes.ocean);
        register(Placement.Biome.normal, VanillaBiomes.deep_ocean);
        register(Placement.Biome.normal, VanillaBiomes.deep_lukewarm_ocean);
    }

}
