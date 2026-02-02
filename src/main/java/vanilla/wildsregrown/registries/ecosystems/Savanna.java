package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Savanna extends Ecosystem {

    public Savanna() {
        super(Climate.savanna, Biomes.savanna, 5);
        register(Placement.Biome.normal, Biomes.windswept_savanna);
        register(Placement.Biome.normal, Biomes.savanna_ferns);
        register(Placement.Biome.normal, Biomes.savanna_flowers);
        register(Placement.Biome.dry, Biomes.dry_savanna);
        register(Placement.Biome.dry, Biomes.sparse_savanna);
        register(Placement.Biome.wet, Biomes.dense_savanna);
        register(Placement.Biome.wet, Biomes.wet_savanna);
        register(Placement.Biome.swamp, Biomes.mangrove_swamp);
        register(Placement.Biome.river, Biomes.river);
        register(Placement.Biome.lake, Biomes.mangrove_swamp);
    }

}
