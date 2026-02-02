package vanilla.wildsregrown.registries.biomes;

import com.sipke.api.features.flora.FloraSpawnRule;
import vanilla.wildsregrown.api.biome.VanillaBiome;
import vanilla.wildsregrown.registries.Floras;
import vanilla.wildsregrown.registries.Materials;
import vanilla.wildsregrown.registries.Structures;


public class PeatSwamp extends VanillaBiome {

    public PeatSwamp() {
        super("swamp");
        setSurface(Materials.podzol, 8);
        register(Floras.tall_grass, FloraSpawnRule.full_coverage, 0, 0, false);
        register(Structures.swamp_hut);
    }

}