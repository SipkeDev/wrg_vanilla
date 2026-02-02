package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class CoolShrubland extends Ecosystem {

    public CoolShrubland() {
        super(Climate.coolScrubland, Biomes.plains, 2);
        register(Placement.Biome.normal, Biomes.sparse_plains, 3);
        register(Placement.Biome.normal, Biomes.birch_forest);
        register(Placement.Biome.normal, Biomes.wooded_badlands);
        register(Placement.Biome.wet, Biomes.red_meadow);
        register(Placement.Biome.wet, Biomes.dense_plains);
        register(Placement.Biome.wet, Biomes.abandoned_farmland);
        register(Placement.Biome.dry, Biomes.dry_plains);
        register(Placement.Biome.dry, Biomes.cool_desert);
        register(Placement.Biome.swamp, Biomes.swamp);
    }

}
