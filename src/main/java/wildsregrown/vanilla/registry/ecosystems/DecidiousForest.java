package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class DecidiousForest extends Ecosystem {

    public DecidiousForest() {
        super(modid, "decidious_forest", Climate.deciduousForest, VanillaBiomes.forest);
        register(Placement.Biome.normal, VanillaBiomes.sunflower_plains);
        register(Placement.Biome.normal, VanillaBiomes.dark_forest);
        register(Placement.Biome.normal, VanillaBiomes.windswept_forest);
        register(Placement.Biome.wet, VanillaBiomes.blue_meadow);
        register(Placement.Biome.wet, VanillaBiomes.dense_plains);
        register(Placement.Biome.wet, VanillaBiomes.abandoned_farmland);
        register(Placement.Biome.dry, VanillaBiomes.sparse_plains);
        register(Placement.Biome.dry, VanillaBiomes.red_meadow);
        register(Placement.Biome.swamp, VanillaBiomes.peat_swamp);
    }

}
