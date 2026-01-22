package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class MixedForest extends Ecosystem {

    public MixedForest() {
        super(Climate.mixedForest, Biomes.forest);
        register(Placement.Biome.swamp, Biomes.swamp);
        register(Placement.Biome.wet, Biomes.flower_forest);
        register(Placement.Biome.dry, Biomes.birch_forest);
    }

}
