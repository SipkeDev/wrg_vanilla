package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Savanna extends Ecosystem {

    public Savanna() {
        super(Climate.savanna, Biomes.savanna);
        register(Placement.Biome.normal, Biomes.windswept_savanna);
        register(Placement.Biome.dry, Biomes.savanna_plateau);
        register(Placement.Biome.swamp, Biomes.mangrove_swamp);
        register(Placement.Biome.river, Biomes.river);
        register(Placement.Biome.lake, Biomes.mangrove_swamp);
    }

}
