package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class CoolShrubland extends Ecosystem {

    public CoolShrubland() {
        super(modid, "cool_shrubland", Climate.coolShrubland, VanillaBiomes.plains, 2);
        register(Placement.Biome.normal, VanillaBiomes.sparse_plains, 3);
        register(Placement.Biome.normal, VanillaBiomes.birch_forest);
        register(Placement.Biome.normal, VanillaBiomes.wooded_badlands);
        register(Placement.Biome.wet, VanillaBiomes.red_meadow);
        register(Placement.Biome.wet, VanillaBiomes.dense_plains);
        register(Placement.Biome.wet, VanillaBiomes.abandoned_farmland);
        register(Placement.Biome.dry, VanillaBiomes.dry_plains);
        register(Placement.Biome.dry, VanillaBiomes.cool_desert);
        register(Placement.Biome.swamp, VanillaBiomes.swamp);
    }

}
