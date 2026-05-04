package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Ice extends Ecosystem {

    public Ice() {
        super(modid, "ice", Climate.ice, VanillaBiomes.ice_spikes, 2);
        register(Placement.Biome.normal, VanillaBiomes.snowy_slopes, 8);
        register(Placement.Biome.swamp, VanillaBiomes.ice_spikes);
        register(Placement.Biome.wet, VanillaBiomes.snowy_beach);
        register(Placement.Biome.dry, VanillaBiomes.snowy_plains);
    }

}
