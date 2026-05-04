package wildsregrown.vanilla.registry.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Sea extends Ecosystem {

    public Sea() {
        super(modid, "sea", Climate.temperateSea, VanillaBiomes.ocean);
        register(Placement.Biome.normal, VanillaBiomes.lukewarm_ocean);
    }

}
