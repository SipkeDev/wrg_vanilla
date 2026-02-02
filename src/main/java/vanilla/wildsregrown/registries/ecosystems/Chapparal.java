package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Chapparal extends Ecosystem {

    public Chapparal() {
        super(Climate.chaparral, Biomes.plains);
        register(Placement.Biome.normal, Biomes.tall_plains);
        register(Placement.Biome.normal, Biomes.sunflower_plains);
        register(Placement.Biome.normal, Biomes.flower_forest);
        register(Placement.Biome.normal, Biomes.abandoned_farmland);
        register(Placement.Biome.wet, Biomes.dense_plains);
        register(Placement.Biome.wet, Biomes.farmland);
        register(Placement.Biome.dry, Biomes.sparse_plains);
        register(Placement.Biome.dry, Biomes.sunflower_plains);
        register(Placement.Biome.dry, Biomes.abandoned_farmland);
        register(Placement.Biome.swamp, Biomes.swamp);
        register(Placement.Biome.swamp, Biomes.peat_swamp);
    }

}
