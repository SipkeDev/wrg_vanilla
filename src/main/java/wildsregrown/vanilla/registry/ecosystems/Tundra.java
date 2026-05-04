package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class Tundra extends Ecosystem {

    public Tundra() {
        super(modid, "tundra", Climate.tundra, VanillaBiomes.snowy_taiga);
        register(Placement.Biome.swamp, VanillaBiomes.swamp);
        register(Placement.Biome.wet, VanillaBiomes.snowy_plains);
        register(Placement.Biome.dry, VanillaBiomes.snowy_taiga);
    }

}
