package vanilla.wildsregrown.registries.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class ColdOcean extends Ecosystem {

    public ColdOcean() {
        super(Climate.coldSea, Biomes.deep_cold_ocean);
        register(Placement.Biome.normal, Biomes.cold_ocean);
        register(Placement.Biome.normal, Biomes.frozen_ocean);
        register(Placement.Biome.normal, Biomes.deep_frozen_ocean);
    }

}
