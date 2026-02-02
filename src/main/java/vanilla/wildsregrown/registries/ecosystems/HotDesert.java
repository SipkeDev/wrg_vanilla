package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class HotDesert extends Ecosystem {

    public HotDesert() {
        super(Climate.hotDesert, Biomes.hot_desert);
        register(Placement.Biome.swamp, Biomes.red_desert);
    }

}
