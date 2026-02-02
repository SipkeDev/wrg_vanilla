package vanilla.wildsregrown.registries.ecosystems.sea;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class Sea extends Ecosystem {

    public Sea() {
        super(Climate.temperateSea, Biomes.ocean);
        register(Placement.Biome.normal, Biomes.lukewarm_ocean);
    }

}
