package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;

public class DensePlains extends VanillaBiome {

    public DensePlains() {
        super("plains");
        setSurface(Materials.dirt, 5);
        register(Floras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Floras.tall_grass, FloraSpawnRule.grouped, 0, 0, false);
        register(Floras.fern, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.cornflower, FloraSpawnRule.rare, 0, 0, false);
        register(Floras.allium, FloraSpawnRule.rare, 0, 0, false);
        register(Floras.oxeye_daisy, FloraSpawnRule.rare, 0, 0, false);
        register(Floras.poppy, FloraSpawnRule.rare, 0, 0, false);
    }

}
