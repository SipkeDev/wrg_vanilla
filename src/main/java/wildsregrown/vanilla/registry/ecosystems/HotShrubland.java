package wildsregrown.vanilla.registry.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import wildsregrown.vanilla.registry.VanillaBiomes;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class HotShrubland extends Ecosystem {

    public HotShrubland() {
        super(modid, "hot_shrubland", Climate.hotScrubland, VanillaBiomes.eroded_badlands);
        register(Placement.Biome.swamp, VanillaBiomes.swamp);
        register(Placement.Biome.wet, VanillaBiomes.wooded_badlands);
        register(Placement.Biome.dry, VanillaBiomes.badlands);
    }

}
