package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;

public class DryPlains extends VanillaBiome {

    public DryPlains() {
        super("plains");
        setSurface(Materials.coarse_dirt, 1);
        register(Floras.fern, FloraSpawnRule.dotted, 0, 0, false);
    }

}
