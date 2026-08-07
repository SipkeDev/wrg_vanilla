package wildsregrown.vanilla.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import wildsregrown.api.block.flora.bush.BushBranch;
import wildsregrown.api.block.flora.bush.BushSource;
import wildsregrown.api.block.tree.blocks.*;
import wildsregrown.api.registry.defaults.ApiBlocks;
import wildsregrown.api.registry.defaults.ApiEntities;
import wildsregrown.vanilla.WRGVanilla;

import java.util.function.Function;

import static wildsregrown.vanilla.WRGVanilla.modid;
import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaBlocks {

    /// Trees
    public static final Block oak_source = registerSource(vanillaId, "oak_source", ctx -> new TreeSource(ctx, VanillaTrees.oak.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block oak_branch = registerSource(vanillaId, "oak_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block oak_source_sapling = ApiBlocks.register(modid, "oak_source_sapling", ctx -> new TreeSapling(ctx, oak_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block big_oak_source = registerSource(vanillaId, "big_oak_source", ctx -> new TreeSource(ctx, VanillaTrees.big_oak.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block big_oak_source_sapling = ApiBlocks.register(modid, "big_oak_source_sapling", ctx -> new TreeSapling(ctx, big_oak_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block pale_oak_source = registerSource(vanillaId, "pale_oak_source", ctx -> new TreeSource(ctx, VanillaTrees.pale_oak.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_WOOD));
    public static final Block pale_oak_branch = registerSource(vanillaId, "pale_oak_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block pale_oak_source_sapling = ApiBlocks.register(modid, "pale_oak_source_sapling", ctx -> new TreeSapling(ctx, pale_oak_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block dark_oak_source = registerSource(vanillaId, "dark_oak_source", ctx -> new TreeSource(ctx, VanillaTrees.dark_oak.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD));
    public static final Block dark_oak_branch = registerSource(vanillaId, "dark_oak_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block dark_oak_source_sapling = ApiBlocks.register(modid, "dark_oak_source_sapling", ctx -> new TreeSapling(ctx, dark_oak_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block spruce_source = registerSource(vanillaId, "spruce_source", ctx -> new TreeSource(ctx, VanillaTrees.spruce.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD));
    public static final Block spruce_branch = registerSource(vanillaId, "spruce_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block spruce_source_sapling = ApiBlocks.register(modid, "spruce_source_sapling", ctx -> new TreeSapling(ctx, oak_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block large_spruce_source = registerSource(vanillaId, "tall_spruce_source", ctx -> new TreeSource(ctx, VanillaTrees.tall_spruce.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD));
    public static final Block large_spruce_source_sapling = ApiBlocks.register(modid, "large_spruce_source_sapling", ctx -> new TreeSapling(ctx, oak_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block birch_branch = registerSource(vanillaId, "birch_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block silver_birch_source = registerSource(vanillaId, "silver_birch_source", ctx -> new TreeSource(ctx, VanillaTrees.silver_birch.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD));
    public static final Block silver_birch_source_sapling = ApiBlocks.register(modid, "silver_birch_source_sapling", ctx -> new TreeSapling(ctx, silver_birch_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block tall_birch_source = registerSource(vanillaId, "tall_birch_source", ctx -> new TreeSource(ctx, VanillaTrees.tall_birch.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD));
    public static final Block tall_birch_source_sapling = ApiBlocks.register(modid, "tall_birch_source_sapling", ctx -> new TreeSapling(ctx, tall_birch_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block cherry_branch = registerSource(vanillaId, "cherry_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block cherry_source = registerSource(vanillaId, "cherry_source", ctx -> new TreeSource(ctx, VanillaTrees.cherry.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD));
    public static final Block cherry_source_sapling = ApiBlocks.register(modid, "cherry_source_sapling", ctx -> new TreeSapling(ctx, cherry_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block acacia_branch = registerSource(vanillaId, "acacia_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block acacia_source = registerSource(vanillaId, "acacia_source", ctx -> new TreeSource(ctx, VanillaTrees.acacia.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD));
    public static final Block acacia_source_sapling = ApiBlocks.register(modid, "acacia_source_sapling", ctx -> new TreeSapling(ctx, acacia_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block azalea_branch = registerSource(vanillaId, "azalea_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block azalea_source = registerSource(vanillaId, "azalea_source", ctx -> new TreeSource(ctx, VanillaTrees.azalea.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA));
    public static final Block azalea_source_sapling = ApiBlocks.register(modid, "azalea_source_sapling", ctx -> new TreeSapling(ctx, azalea_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block jungle_branch = registerSource(vanillaId, "jungle_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block jungle_source = registerSource(vanillaId, "jungle_source", ctx -> new TreeSource(ctx, VanillaTrees.jungle.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD));
    public static final Block jungle_source_sapling = ApiBlocks.register(modid, "jungle_source_sapling", ctx -> new TreeSapling(ctx, jungle_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block mangrove_branch = registerSource(vanillaId, "mangrove_branch", Branch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final Block mangrove_source = registerSource(vanillaId, "mangrove_source", ctx -> new TreeSource(ctx, VanillaTrees.mangrove.getKey()), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block mangrove_source_sapling = ApiBlocks.register(modid, "mangrove_source_sapling", ctx -> new TreeSapling(ctx, mangrove_source), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD), CreativeModeTabs.NATURAL_BLOCKS);

    ///Bushes
    public static final Block oak_bush_source = registerSource(modid,"oak_bush_source", ctx -> new BushSource(VanillaBushes.oak.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block oak_bush_branch = ApiBlocks.register(modid, "oak_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block oak_bush_leaves = ApiBlocks.register(modid, "oak_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block pale_oak_bush_source = registerSource(modid,"pale_oak_bush_source", ctx -> new BushSource(VanillaBushes.pale_oak.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block pale_oak_bush_branch = ApiBlocks.register(modid, "pale_oak_bush_branch", BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block pale_oak_bush_leaves = ApiBlocks.register(modid, "pale_oak_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block dark_oak_bush_source = registerSource(modid,"dark_oak_bush_source", ctx -> new BushSource(VanillaBushes.dark_oak.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block dark_oak_bush_branch = ApiBlocks.register(modid, "dark_oak_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block dark_oak_bush_leaves = ApiBlocks.register(modid, "dark_oak_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);
    
    public static final Block birch_bush_source = registerSource(modid,"birch_bush_source", ctx -> new BushSource(VanillaBushes.birch.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block birch_bush_branch = ApiBlocks.register(modid, "birch_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block birch_bush_leaves = ApiBlocks.register(modid, "birch_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block spruce_bush_source = registerSource(modid,"spruce_bush_source", ctx -> new BushSource(VanillaBushes.spruce.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block spruce_bush_branch = ApiBlocks.register(modid, "spruce_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block spruce_bush_leaves = ApiBlocks.register(modid, "spruce_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block azalea_bush_source = registerSource(modid,"azalea_bush_source", ctx -> new BushSource(VanillaBushes.azalea.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block azalea_bush_branch = ApiBlocks.register(modid, "azalea_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block azalea_bush_leaves = ApiBlocks.register(modid, "azalea_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block cherry_bush_source = registerSource(modid,"cherry_bush_source", ctx -> new BushSource(VanillaBushes.azalea.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block cherry_bush_branch = ApiBlocks.register(modid, "cherry_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block cherry_bush_leaves = ApiBlocks.register(modid, "cherry_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block jungle_bush_source = registerSource(modid,"jungle_bush_source", ctx -> new BushSource(VanillaBushes.azalea.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block jungle_bush_branch = ApiBlocks.register(modid, "jungle_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block jungle_bush_leaves = ApiBlocks.register(modid, "jungle_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);

    public static final Block mangrove_bush_source = registerSource(modid,"mangrove_bush_source", ctx -> new BushSource(VanillaBushes.azalea.getKey(),ctx), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final Block mangrove_bush_branch = ApiBlocks.register(modid, "mangrove_bush_branch",BushBranch::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CHORUS_PLANT), CreativeModeTabs.NATURAL_BLOCKS);
    public static final Block mangrove_bush_leaves = ApiBlocks.register(modid, "mangrove_bush_leaves", Leaves::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES), CreativeModeTabs.NATURAL_BLOCKS);



    static {
        ApiEntities.treeEntity.addSupportedBlock(oak_source);
        ApiEntities.treeEntity.addSupportedBlock(big_oak_source);

        ApiEntities.treeEntity.addSupportedBlock(pale_oak_source);
        ApiEntities.treeEntity.addSupportedBlock(dark_oak_source);

        ApiEntities.treeEntity.addSupportedBlock(spruce_source);
        ApiEntities.treeEntity.addSupportedBlock(large_spruce_source);

        ApiEntities.treeEntity.addSupportedBlock(silver_birch_source);
        ApiEntities.treeEntity.addSupportedBlock(tall_birch_source);

        ApiEntities.treeEntity.addSupportedBlock(cherry_source);

        ApiEntities.treeEntity.addSupportedBlock(acacia_source);

        ApiEntities.treeEntity.addSupportedBlock(azalea_source);

        ApiEntities.treeEntity.addSupportedBlock(jungle_source);

        ApiEntities.treeEntity.addSupportedBlock(mangrove_source);

        ///bushes
        ApiEntities.bushEntity.addSupportedBlock(oak_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(pale_oak_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(dark_oak_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(birch_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(spruce_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(azalea_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(cherry_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(jungle_bush_source);
        ApiEntities.bushEntity.addSupportedBlock(mangrove_bush_source);
    }

    /// Utility
    public static Block registerSource(String modid, String path, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        final ResourceKey<Block> registryKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(modid, path));
        final Block block = Blocks.register(registryKey, factory, settings);
        final Item item = Items.registerBlock(block);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(content -> {
            content.accept(item);
        });
        return block;
    }

    public static void init(){
        WRGVanilla.LOGGER.info("loaded blocks");
    }

}
