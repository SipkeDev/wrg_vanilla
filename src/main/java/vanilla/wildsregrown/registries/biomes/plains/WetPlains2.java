package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;

public class WetPlains2 extends VanillaBiome {

    public WetPlains2() {
        super("plains");
        setSurface(Materials.dirt, 5);
        register(Floras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Floras.tall_grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(Floras.grass, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.cornflower, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.lilac, FloraSpawnRule.rare, 0, 0, false);
    }

}
