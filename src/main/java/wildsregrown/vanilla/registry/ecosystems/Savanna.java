package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Savanna extends Ecosystem {

    public Savanna() {
        super(modid, "savanna", Climate.savanna, VanillaBiomes.savanna, 5);
        register(Placement.Biome.normal, VanillaBiomes.windswept_savanna);
        register(Placement.Biome.normal, VanillaBiomes.savanna_ferns);
        register(Placement.Biome.normal, VanillaBiomes.savanna_flowers);
        register(Placement.Biome.dry, VanillaBiomes.dry_savanna);
        register(Placement.Biome.dry, VanillaBiomes.sparse_savanna);
        register(Placement.Biome.wet, VanillaBiomes.dense_savanna);
        register(Placement.Biome.wet, VanillaBiomes.wet_savanna);
        register(Placement.Biome.swamp, VanillaBiomes.mangrove_swamp);
        register(Placement.Biome.river, VanillaBiomes.river);
        register(Placement.Biome.lake, VanillaBiomes.mangrove_swamp);
    }

}
