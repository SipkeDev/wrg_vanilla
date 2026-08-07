package wildsregrown.vanilla.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import wildsregrown.vanilla.registry.VanillaBlocks;

import java.util.concurrent.CompletableFuture;

public class VanillaBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public VanillaBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {

        valueLookupBuilder(BlockTags.LEAVES)
                .addOptionalTag(BlockTags.MINEABLE_WITH_HOE)
                .addOptionalTag(BlockTags.REPLACEABLE_BY_MUSHROOMS)
                .addOptionalTag(BlockTags.SWORD_EFFICIENT)
                .addOptionalTag(BlockTags.PARROTS_SPAWNABLE_ON)
                .add(VanillaBlocks.azalea_bush_leaves)
                .add(VanillaBlocks.birch_bush_leaves)
                .add(VanillaBlocks.cherry_bush_leaves)
                .add(VanillaBlocks.oak_bush_leaves)
                .add(VanillaBlocks.mangrove_bush_leaves);

        valueLookupBuilder(BlockTags.LOGS)
                .add(VanillaBlocks.azalea_bush_branch)
                .add(VanillaBlocks.birch_bush_branch)
                .add(VanillaBlocks.cherry_bush_branch)
                .add(VanillaBlocks.oak_bush_branch)
                .add(VanillaBlocks.mangrove_bush_branch)
                .addOptionalTag(BlockTags.MINEABLE_WITH_AXE)
                .addOptionalTag(BlockTags.LOGS_THAT_BURN);

        valueLookupBuilder(BlockTags.LOGS)
                .add(VanillaBlocks.oak_source)
                .add(VanillaBlocks.big_oak_source)
                .add(VanillaBlocks.pale_oak_source)
                .add(VanillaBlocks.dark_oak_source)
                .add(VanillaBlocks.spruce_source)
                .add(VanillaBlocks.large_spruce_source)
                .add(VanillaBlocks.silver_birch_source)
                .add(VanillaBlocks.tall_birch_source)
                .add(VanillaBlocks.cherry_source)
                .add(VanillaBlocks.azalea_source)
                .add(VanillaBlocks.jungle_source)
                .add(VanillaBlocks.mangrove_source)
                .addOptionalTag(BlockTags.MINEABLE_WITH_AXE)
                .addOptionalTag(BlockTags.LOGS_THAT_BURN)
                .addOptionalTag(BlockTags.OVERWORLD_NATURAL_LOGS);

    }

}