package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class SpiritForest extends Ecosystem {

    public SpiritForest() {
        super(Climate.spiritForest, Biomes.jungle);
        register(Placement.Biome.wet, Biomes.bamboo_jungle);
        register(Placement.Biome.dry, Biomes.sparse_jungle);
        register(Placement.Biome.swamp, Biomes.mangrove_swamp);
    }

}
