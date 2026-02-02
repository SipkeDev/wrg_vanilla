package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Tundra extends Ecosystem {

    public Tundra() {
        super(Climate.tundra, Biomes.snowy_taiga);
        register(Placement.Biome.swamp, Biomes.swamp);
        register(Placement.Biome.wet, Biomes.snowy_plains);
        register(Placement.Biome.dry, Biomes.snowy_taiga);
    }

}
