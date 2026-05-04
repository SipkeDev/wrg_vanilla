package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class ConiferiousForest extends Ecosystem {

    public ConiferiousForest() {
        super(modid, "coniferious_forest", Climate.coniferousForest, VanillaBiomes.old_growth_pine_taiga);
        register(Placement.Biome.normal, VanillaBiomes.old_growth_spruce_taiga);
        register(Placement.Biome.dry, VanillaBiomes.taiga);
        register(Placement.Biome.swamp, VanillaBiomes.old_growth_birch_forest);
    }

}
