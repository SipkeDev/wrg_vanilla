package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class HotShrubland extends Ecosystem {

    public HotShrubland() {
        super(Climate.hotScrubland, Biomes.eroded_badlands);
        register(Placement.Biome.swamp, Biomes.swamp);
        register(Placement.Biome.wet, Biomes.wooded_badlands);
        register(Placement.Biome.dry, Biomes.badlands);
    }

}
