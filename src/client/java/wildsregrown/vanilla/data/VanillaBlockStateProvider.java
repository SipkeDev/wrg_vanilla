package wildsregrown.vanilla.data;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import wildsregrown.api.WRGApi;
import wildsregrown.api.client.WRGApiDataGenerator;
import wildsregrown.api.client.data.libraries.FloraLibrary;
import wildsregrown.api.client.data.libraries.TreeLibrary;
import wildsregrown.api.client.data.util.BlockStateUtil;
import wildsregrown.api.client.data.util.TextureRef;
import wildsregrown.api.registry.defaults.ApiBlocks;
import wildsregrown.vanilla.WRGVanilla;
import wildsregrown.vanilla.registry.VanillaBlocks;

import static wildsregrown.api.client.data.libraries.BlockStateLibrary.root;
import static wildsregrown.vanilla.WRGVanilla.modid;
import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaBlockStateProvider extends FabricModelProvider {

    public VanillaBlockStateProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        source(generator, modid, VanillaBlocks.oak_source, "block/oak_log","block/oak_log_top");
        TreeLibrary.branch(generator, VanillaBlocks.oak_branch, modid, TextureRef.of(0, "minecraft", "block/oak_log"));

        TreeLibrary.sapling(generator, VanillaBlocks.oak_source_sapling, modid, TextureRef.of(0, "minecraft", "block/oak_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/oak_leaves"));
        source(generator, modid, VanillaBlocks.big_oak_source, "block/oak_log","block/oak_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.big_oak_source_sapling, modid, TextureRef.of(0, "minecraft", "block/oak_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/oak_leaves"));

        source(generator, modid, VanillaBlocks.pale_oak_source, "block/pale_oak_log","block/pale_oak_log_top");
        TreeLibrary.branch(generator, VanillaBlocks.pale_oak_branch, modid, TextureRef.of(0, "minecraft", "block/pale_oak_log"));
        TreeLibrary.sapling(generator, VanillaBlocks.pale_oak_source_sapling, modid, TextureRef.of(0, "minecraft", "block/pale_oak_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/pale_oak_leaves"));

        source(generator, modid, VanillaBlocks.dark_oak_source, "block/dark_oak_log","block/dark_oak_log_top");
        TreeLibrary.branch(generator, VanillaBlocks.dark_oak_branch, modid, TextureRef.of(0, "minecraft", "block/dark_oak_log"));
        TreeLibrary.sapling(generator, VanillaBlocks.dark_oak_source_sapling, modid, TextureRef.of(0, "minecraft", "block/dark_oak_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/dark_oak_leaves"));

        TreeLibrary.branch(generator, VanillaBlocks.spruce_branch, modid, TextureRef.of(0, "minecraft", "block/spruce_log"));
        source(generator, modid, VanillaBlocks.spruce_source, "block/spruce_log","block/spruce_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.spruce_source_sapling, modid, TextureRef.of(0, "minecraft", "block/spruce_log"), TreeLibrary.LeaveModels.pine, TextureRef.of(0, "minecraft", "block/spruce_leaves"));
        source(generator, modid, VanillaBlocks.large_spruce_source, "block/spruce_log","block/spruce_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.large_spruce_source_sapling, modid, TextureRef.of(0, "minecraft", "block/spruce_log"), TreeLibrary.LeaveModels.sparse_pine, TextureRef.of(0, "minecraft", "block/spruce_leaves"));

        TreeLibrary.branch(generator, VanillaBlocks.birch_branch, modid, TextureRef.of(0, "minecraft", "block/birch_log"));
        source(generator, modid, VanillaBlocks.silver_birch_source, "block/birch_log","block/birch_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.silver_birch_source_sapling, modid, TextureRef.of(0, "minecraft", "block/birch_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/birch_leaves"));
        source(generator, modid, VanillaBlocks.tall_birch_source, "block/birch_log","block/birch_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.tall_birch_source_sapling, modid, TextureRef.of(0, "minecraft", "block/birch_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/birch_leaves"));

        TreeLibrary.branch(generator, VanillaBlocks.cherry_branch, modid, TextureRef.of(0, "minecraft", "block/cherry_log"));
        source(generator, modid, VanillaBlocks.cherry_source, "block/cherry_log","block/cherry_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.cherry_source_sapling, modid, TextureRef.of(0, "minecraft", "block/cherry_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/cherry_leaves"));
        TreeLibrary.branch(generator, VanillaBlocks.acacia_branch, modid, TextureRef.of(0, "minecraft", "block/acacia_log"));
        source(generator, modid, VanillaBlocks.acacia_source, "block/acacia_log","block/acacia_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.acacia_source_sapling, modid, TextureRef.of(0, "minecraft", "block/acacia_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/acacia_leaves"));
        TreeLibrary.branch(generator, VanillaBlocks.azalea_branch, modid, TextureRef.of(0, "minecraft", "block/oak_log"));
        source(generator, modid, VanillaBlocks.azalea_source, "block/oak_log","block/oak_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.azalea_source_sapling, modid, TextureRef.of(0, "minecraft", "block/oak_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/azalea_leaves"));
        TreeLibrary.branch(generator, VanillaBlocks.jungle_branch, modid, TextureRef.of(0, "minecraft", "block/jungle_log"));
        source(generator, modid, VanillaBlocks.jungle_source, "block/jungle_log","block/jungle_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.jungle_source_sapling, modid, TextureRef.of(0, "minecraft", "block/jungle_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/jungle_leaves"));
        TreeLibrary.branch(generator, VanillaBlocks.mangrove_branch, modid, TextureRef.of(0, "minecraft", "block/mangrove_log"));
        source(generator, modid, VanillaBlocks.mangrove_source, "block/mangrove_log","block/mangrove_log_top");
        TreeLibrary.sapling(generator, VanillaBlocks.mangrove_source_sapling, modid, TextureRef.of(0, "minecraft", "block/mangrove_log"), TreeLibrary.LeaveModels.cubic, TextureRef.of(0, "minecraft", "block/mangrove_leaves"));

        ///Bushes
        source(generator, modid, VanillaBlocks.oak_bush_source, "block/oak_log","block/oak_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.oak_bush_branch, modid,TextureRef.of(0, "minecraft", "block/oak_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.oak_bush_leaves, modid, TreeLibrary.LeaveModels.cube, TextureRef.of(0, vanillaId, "block/oak_leaves"));

        source(generator, modid, VanillaBlocks.pale_oak_bush_source, "block/pale_oak_log","block/pale_oak_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.pale_oak_bush_branch, modid,TextureRef.of(0, "minecraft", "block/pale_oak_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.pale_oak_bush_leaves, modid, TreeLibrary.LeaveModels.cube, TextureRef.of(0, vanillaId, "block/pale_oak_leaves"));

        source(generator, modid, VanillaBlocks.dark_oak_bush_source, "block/dark_oak_log","block/dark_oak_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.dark_oak_bush_branch, modid,TextureRef.of(0, "minecraft", "block/dark_oak_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.dark_oak_bush_leaves, modid, TreeLibrary.LeaveModels.cube, TextureRef.of(0, vanillaId, "block/dark_oak_leaves"));

        source(generator, modid, VanillaBlocks.birch_bush_source, "block/birch_log","block/birch_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.birch_bush_branch, modid,TextureRef.of(0, "minecraft", "block/birch_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.birch_bush_leaves, modid, TreeLibrary.LeaveModels.cube, TextureRef.of(0, vanillaId, "block/birch_leaves"));

        source(generator, modid, VanillaBlocks.spruce_bush_source, "block/spruce_log","block/spruce_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.spruce_bush_branch, modid,TextureRef.of(0, "minecraft", "block/spruce_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.spruce_bush_leaves, modid, TreeLibrary.LeaveModels.sparse_pine, TextureRef.of(0, vanillaId, "block/spruce_leaves"));

        source(generator, modid, VanillaBlocks.azalea_bush_source, "block/oak_log","block/oak_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.azalea_bush_branch, modid,TextureRef.of(0, "minecraft", "block/oak_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.azalea_bush_leaves, modid, TreeLibrary.LeaveModels.cube, TextureRef.of(0, vanillaId, "block/azalea_leaves"));

        source(generator, modid, VanillaBlocks.cherry_bush_source, "block/cherry_log","block/cherry_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.cherry_bush_branch, modid,TextureRef.of(0, "minecraft", "block/cherry_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.cherry_bush_leaves, modid, TreeLibrary.LeaveModels.cubic, TextureRef.of(0, vanillaId, "block/cherry_leaves"));

        source(generator, modid, VanillaBlocks.jungle_bush_source, "block/jungle_log","block/jungle_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.jungle_bush_branch, modid,TextureRef.of(0, "minecraft", "block/jungle_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.jungle_bush_leaves, modid, TreeLibrary.LeaveModels.cubic, TextureRef.of(0, vanillaId, "block/jungle_leaves"));

        source(generator, modid, VanillaBlocks.mangrove_bush_source, "block/mangrove_log","block/mangrove_log_top");
        FloraLibrary.bushBranch(generator, VanillaBlocks.mangrove_bush_branch, modid,TextureRef.of(0, "minecraft", "block/mangrove_log"));
        TreeLibrary.leaves(generator, VanillaBlocks.mangrove_bush_leaves, modid, TreeLibrary.LeaveModels.cubic, TextureRef.of(0, vanillaId, "block/mangrove_leaves"));


    }

    public static void source(BlockModelGenerators generator, String modid, Block block, String texture0, String texture1) {
        String path = "wood/" + WRGApiDataGenerator.idFromBlock(block);
        BlockStateUtil.applyTextureToModel(generator, modid, path, WRGApi.modid, "block/trees/tree_source", TextureRef.of(0, vanillaId, texture0), TextureRef.of(1, vanillaId, texture1));
        generator.registerSimpleItemModel(block, Identifier.fromNamespaceAndPath(modid, root + path));
        BlockStateUtil.CreateSingleton(generator, block, modid, path);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        ///Empty
    }

}
