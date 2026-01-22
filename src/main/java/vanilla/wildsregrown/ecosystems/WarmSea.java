package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class WarmSea extends Ecosystem {

    public WarmSea() {
        super(Climate.warmOcean, Biomes.lukewarm_ocean);
    }

}
