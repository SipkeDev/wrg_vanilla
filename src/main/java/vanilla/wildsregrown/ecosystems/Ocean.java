package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Ocean extends Ecosystem {

    public Ocean() {
        super(Climate.temperateOcean, Biomes.ocean);
        register(Placement.Biome.normal, Biomes.deep_ocean);
    }

}
