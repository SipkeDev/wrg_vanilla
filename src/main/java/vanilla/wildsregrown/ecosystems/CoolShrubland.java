package vanilla.wildsregrown.ecosystems;

import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Ecosystem;
import vanilla.wildsregrown.registries.Biomes;

public class CoolShrubland extends Ecosystem {

    public CoolShrubland() {
        super(Climate.coolScrubland, Biomes.plains);
        register(Placement.Biome.normal, Biomes.wooded_badlands);
        register(Placement.Biome.swamp, Biomes.swamp);
    }

}
