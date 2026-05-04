package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class CoolDesert extends Ecosystem {

    public CoolDesert() {
        super(modid, "cool_desert", Climate.coolDesert, VanillaBiomes.cool_desert);
        register(Placement.Biome.normal, VanillaBiomes.hot_desert);
        register(Placement.Biome.dry, VanillaBiomes.red_desert);
    }

}
