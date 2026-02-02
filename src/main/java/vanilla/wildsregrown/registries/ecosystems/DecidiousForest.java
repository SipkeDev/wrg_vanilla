package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class DecidiousForest extends Ecosystem {

    public DecidiousForest() {
        super(Climate.deciduousForest, Biomes.forest);
        register(Placement.Biome.normal, Biomes.sunflower_plains);
        register(Placement.Biome.normal, Biomes.dark_forest);
        register(Placement.Biome.normal, Biomes.windswept_forest);
        register(Placement.Biome.wet, Biomes.blue_meadow);
        register(Placement.Biome.wet, Biomes.dense_plains);
        register(Placement.Biome.wet, Biomes.abandoned_farmland);
        register(Placement.Biome.dry, Biomes.sparse_plains);
        register(Placement.Biome.dry, Biomes.red_meadow);
        register(Placement.Biome.swamp, Biomes.peat_swamp);
    }

}
