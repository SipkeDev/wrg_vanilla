package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Chapparal extends Ecosystem {

    public Chapparal() {
        super(modid, "chapparal", Climate.chaparral, VanillaBiomes.plains);
        register(Placement.Biome.normal, VanillaBiomes.tall_plains);
        register(Placement.Biome.normal, VanillaBiomes.sunflower_plains);
        register(Placement.Biome.normal, VanillaBiomes.flower_forest);
        register(Placement.Biome.normal, VanillaBiomes.abandoned_farmland);
        register(Placement.Biome.wet, VanillaBiomes.dense_plains);
        register(Placement.Biome.wet, VanillaBiomes.farmland);
        register(Placement.Biome.dry, VanillaBiomes.sparse_plains);
        register(Placement.Biome.dry, VanillaBiomes.sunflower_plains);
        register(Placement.Biome.dry, VanillaBiomes.abandoned_farmland);
        register(Placement.Biome.swamp, VanillaBiomes.swamp);
        register(Placement.Biome.swamp, VanillaBiomes.peat_swamp);
    }

}
