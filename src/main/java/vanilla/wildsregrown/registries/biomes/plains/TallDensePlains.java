package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;

public class TallDensePlains extends VanillaBiome {

    public TallDensePlains() {
        super("plains");
        setSurface(Materials.dirt, 5);
        register(Floras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Floras.tall_grass, FloraSpawnRule.dotted, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.tall_fern, FloraSpawnRule.rare, 0, 0, false);
    }

}
