package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class MixedForest extends Ecosystem {

    public MixedForest() {
        super(modid, "mixed_forest", Climate.mixedForest, VanillaBiomes.forest, 5);
        register(Placement.Biome.normal, VanillaBiomes.flower_forest, 2);
        register(Placement.Biome.normal, VanillaBiomes.abandoned_farmland);
        register(Placement.Biome.normal, VanillaBiomes.windswept_forest);
        register(Placement.Biome.wet, VanillaBiomes.blue_meadow);
        register(Placement.Biome.wet, VanillaBiomes.birch_forest);
        register(Placement.Biome.wet, VanillaBiomes.meadow);
        register(Placement.Biome.wet, VanillaBiomes.dense_plains);
        register(Placement.Biome.swamp, VanillaBiomes.peat_swamp);
        register(Placement.Biome.swamp, VanillaBiomes.swamp);
    }

}
