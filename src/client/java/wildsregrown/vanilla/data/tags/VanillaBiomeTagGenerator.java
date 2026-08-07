package wildsregrown.vanilla.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import java.util.concurrent.CompletableFuture;

public class VanillaBiomeTagGenerator extends FabricTagProvider<Biome> {

    public VanillaBiomeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, Registries.BIOME, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        //builder(BiomeTags.SPAWNS_WHITE_RABBITS).addAll(WRGBiomes.BIOMES);
    }

}
