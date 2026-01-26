package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class CoolDesert extends Ecosystem {

    public CoolDesert() {
        super(Climate.coolDesert, Biomes.cool_desert);
        register(Placement.Biome.normal, Biomes.hot_desert);
        register(Placement.Biome.dry, Biomes.red_desert);
    }

}
