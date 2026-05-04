package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class AncientForest extends Ecosystem {

    public AncientForest() {
        super(modid, "ancient_forest", Climate.ancientForest, VanillaBiomes.dark_forest);
        register(Placement.Biome.swamp, VanillaBiomes.swamp);
        register(Placement.Biome.swamp, VanillaBiomes.mangrove_swamp);
        register(Placement.Biome.wet, VanillaBiomes.pale_garden);
    }

}
