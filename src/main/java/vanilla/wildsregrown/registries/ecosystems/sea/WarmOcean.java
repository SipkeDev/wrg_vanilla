package vanilla.wildsregrown.registries.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class WarmOcean extends Ecosystem {

    public WarmOcean() {
        super(Climate.warmOcean, Biomes.warm_ocean);
        register(Placement.Biome.normal, Biomes.deep_lukewarm_ocean);
    }

}
