package vanilla.wildsregrown.registries.biomes.plains;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;

public class WetPlains3 extends VanillaBiome {

    public WetPlains3() {
        super("plains");
        setSurface(Materials.dirt, 5);
        register(Floras.grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Floras.tall_grass, FloraSpawnRule.small_groups, 0, 0, false);
        register(Floras.grass, FloraSpawnRule.dotted, 0, 0, false);
        register(Floras.poppy, FloraSpawnRule.occasional, 0, 0, false);
        register(Floras.rose_bush, FloraSpawnRule.rare, 0, 0, false);
    }

}
