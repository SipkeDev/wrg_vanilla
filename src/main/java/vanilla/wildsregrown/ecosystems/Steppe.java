package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Steppe extends Ecosystem {

    public Steppe() {
        super(Climate.steppe, Biomes.plains, 8);
        register(Placement.Biome.normal, Biomes.flower_forest, 2);
        register(Placement.Biome.swamp, Biomes.swamp);
        register(Placement.Biome.wet, Biomes.birch_forest);
        register(Placement.Biome.dry, Biomes.sunflower_plains);
    }

}
