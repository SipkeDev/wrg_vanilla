package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Steppe extends Ecosystem {

    public Steppe() {
        super(Climate.steppe, Biomes.plains, 4);
        register(Placement.Biome.normal, Biomes.tall_plains);
        register(Placement.Biome.normal, Biomes.sunflower_plains);
        register(Placement.Biome.normal, Biomes.blue_flower_plains);
        register(Placement.Biome.normal, Biomes.red_flower_plains);
        register(Placement.Biome.normal, Biomes.pink_flower_plains);
        register(Placement.Biome.normal, Biomes.white_flower_plains);
        register(Placement.Biome.swamp, Biomes.dense_plains);
        register(Placement.Biome.swamp, Biomes.tall_dense_plains);
        register(Placement.Biome.wet, Biomes.wet_plains_0);
        register(Placement.Biome.wet, Biomes.wet_plains_1);
        register(Placement.Biome.wet, Biomes.wet_plains_2);
        register(Placement.Biome.dry, Biomes.dry_plains);
        register(Placement.Biome.dry, Biomes.sparse_plains);
        register(Placement.Biome.dry, Biomes.sparse_plains);
    }

}
