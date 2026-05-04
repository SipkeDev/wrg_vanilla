package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class PolarDesert extends Ecosystem {

    public PolarDesert() {
        super(modid, "polar_desert", Climate.polarDesert, VanillaBiomes.snowy_plains, 8);
        register(Placement.Biome.swamp, VanillaBiomes.snowy_slopes, 2);
        register(Placement.Biome.wet, VanillaBiomes.snowy_beach);
        register(Placement.Biome.dry, VanillaBiomes.snowy_plains);
    }

}
