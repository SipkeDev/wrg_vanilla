package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Steppe extends Ecosystem {

    public Steppe() {
        super(modid, "steppe", Climate.steppe, VanillaBiomes.plains, 4);
        register(Placement.Biome.normal, VanillaBiomes.tall_plains);
        register(Placement.Biome.normal, VanillaBiomes.sunflower_plains);
        register(Placement.Biome.normal, VanillaBiomes.blue_flower_plains);
        register(Placement.Biome.normal, VanillaBiomes.red_flower_plains);
        register(Placement.Biome.normal, VanillaBiomes.pink_flower_plains);
        register(Placement.Biome.normal, VanillaBiomes.white_flower_plains);
        register(Placement.Biome.swamp, VanillaBiomes.dense_plains);
        register(Placement.Biome.swamp, VanillaBiomes.tall_dense_plains);
        register(Placement.Biome.wet, VanillaBiomes.wet_plains_0);
        register(Placement.Biome.wet, VanillaBiomes.wet_plains_1);
        register(Placement.Biome.wet, VanillaBiomes.wet_plains_2);
        register(Placement.Biome.dry, VanillaBiomes.dry_plains);
        register(Placement.Biome.dry, VanillaBiomes.sparse_plains);
        register(Placement.Biome.dry, VanillaBiomes.sparse_plains);
    }

}
