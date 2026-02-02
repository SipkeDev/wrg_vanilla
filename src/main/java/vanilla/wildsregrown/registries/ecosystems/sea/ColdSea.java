package vanilla.wildsregrown.registries.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class ColdSea extends Ecosystem {

    public ColdSea() {
        super(Climate.coldSea, Biomes.cold_ocean);
        register(Placement.Biome.normal, Biomes.frozen_ocean);
    }

}
