package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class HotDesert extends Ecosystem {

    public HotDesert() {
        super(modid, "hot_desert", Climate.hotDesert, VanillaBiomes.hot_desert);
        register(Placement.Biome.swamp, VanillaBiomes.red_desert);
    }

}
