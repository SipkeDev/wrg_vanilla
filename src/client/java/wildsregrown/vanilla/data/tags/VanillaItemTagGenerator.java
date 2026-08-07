package wildsregrown.vanilla.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import wildsregrown.vanilla.registry.VanillaBlocks;

import java.util.concurrent.CompletableFuture;

public class VanillaItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    public VanillaItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        valueLookupBuilder(ItemTags.LEAVES)
                .add(VanillaBlocks.azalea_bush_leaves.asItem())
                .add(VanillaBlocks.birch_bush_leaves.asItem())
                .add(VanillaBlocks.oak_bush_leaves.asItem())
                .add(VanillaBlocks.cherry_bush_leaves.asItem())
                .add(VanillaBlocks.mangrove_bush_leaves.asItem());

        valueLookupBuilder(ItemTags.LOGS)
                .add(VanillaBlocks.azalea_bush_branch.asItem())
                .add(VanillaBlocks.birch_bush_branch.asItem())
                .add(VanillaBlocks.oak_bush_branch.asItem())
                .add(VanillaBlocks.cherry_bush_branch.asItem())
                .add(VanillaBlocks.mangrove_bush_branch.asItem());

    }

}