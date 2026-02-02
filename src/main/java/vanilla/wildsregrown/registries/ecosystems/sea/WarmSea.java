package vanilla.wildsregrown.registries.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class WarmSea extends Ecosystem {

    public WarmSea() {
        super(Climate.warmOcean, Biomes.warm_ocean);
        register(Placement.Biome.normal, Biomes.lukewarm_ocean);
    }

}
