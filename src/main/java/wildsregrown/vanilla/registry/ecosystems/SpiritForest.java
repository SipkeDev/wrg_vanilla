package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class SpiritForest extends Ecosystem {

    public SpiritForest() {
        super(modid, "spirit_forest", Climate.spiritForest, VanillaBiomes.jungle);
        register(Placement.Biome.wet, VanillaBiomes.bamboo_jungle);
        register(Placement.Biome.dry, VanillaBiomes.sparse_jungle);
        register(Placement.Biome.swamp, VanillaBiomes.mangrove_swamp);
    }

}
