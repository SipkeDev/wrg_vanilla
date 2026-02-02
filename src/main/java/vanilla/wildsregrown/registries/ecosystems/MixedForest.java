package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class MixedForest extends Ecosystem {

    public MixedForest() {
        super(Climate.mixedForest, Biomes.forest, 5);
        register(Placement.Biome.normal, Biomes.flower_forest, 2);
        register(Placement.Biome.normal, Biomes.abandoned_farmland);
        register(Placement.Biome.normal, Biomes.windswept_forest);
        register(Placement.Biome.wet, Biomes.blue_meadow);
        register(Placement.Biome.wet, Biomes.birch_forest);
        register(Placement.Biome.wet, Biomes.meadow);
        register(Placement.Biome.wet, Biomes.dense_plains);
        register(Placement.Biome.swamp, Biomes.peat_swamp);
        register(Placement.Biome.swamp, Biomes.swamp);
    }

}
