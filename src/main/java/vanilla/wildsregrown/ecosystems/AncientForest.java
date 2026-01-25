package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class AncientForest extends Ecosystem {

    public AncientForest() {
        super(Climate.ancientForest, Biomes.dark_forest);
        register(Placement.Biome.swamp, Biomes.swamp);
        register(Placement.Biome.swamp, Biomes.mangrove_swamp);
        register(Placement.Biome.wet, Biomes.pale_garden);
    }

}
