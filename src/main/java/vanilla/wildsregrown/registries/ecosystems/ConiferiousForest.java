package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class ConiferiousForest extends Ecosystem {

    public ConiferiousForest() {
        super(Climate.coniferousForest, Biomes.old_growth_pine_taiga);
        register(Placement.Biome.normal, Biomes.old_growth_spruce_taiga);
        register(Placement.Biome.dry, Biomes.taiga);
        register(Placement.Biome.swamp, Biomes.old_growth_birch_forest);
    }

}
