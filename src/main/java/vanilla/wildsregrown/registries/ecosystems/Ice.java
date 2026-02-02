package vanilla.wildsregrown.registries.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Ice extends Ecosystem {

    public Ice() {
        super(Climate.ice, Biomes.ice_spikes, 2);
        register(Placement.Biome.normal, Biomes.snowy_slopes, 8);
        register(Placement.Biome.swamp, Biomes.ice_spikes);
        register(Placement.Biome.wet, Biomes.snowy_beach);
        register(Placement.Biome.dry, Biomes.snowy_plains);
    }

}
