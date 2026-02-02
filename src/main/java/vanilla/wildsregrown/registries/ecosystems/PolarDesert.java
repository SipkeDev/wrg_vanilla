package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class PolarDesert extends Ecosystem {

    public PolarDesert() {
        super(Climate.polarDesert, Biomes.snowy_plains, 8);
        register(Placement.Biome.swamp, Biomes.snowy_slopes, 2);
        register(Placement.Biome.wet, Biomes.snowy_beach);
        register(Placement.Biome.dry, Biomes.snowy_plains);
    }

}
