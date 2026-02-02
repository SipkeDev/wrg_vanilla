package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;

public class TallPlains extends VanillaBiome {

    public TallPlains() {
        super("plains");
        setSurface(Materials.dirt, 3);
        register(Floras.tall_grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.dotted, 0, 0, false);
        register(Structures.mineshaft);
    }

}
