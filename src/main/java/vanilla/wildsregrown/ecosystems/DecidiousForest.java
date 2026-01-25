package vanilla.wildsregrown.ecosystems;

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
        register(Placement.Biome.dry, Biomes.windswept_forest);
        register(Placement.Biome.swamp, Biomes.swamp);
    }

}
