package wildsregrown.vanilla.registry;

import com.sipke.api.categorization.Season;
import com.sipke.api.features.botanic.trees.config.*;
import com.sipke.features.botanic.trees.TreeUtil;
import com.sipke.features.botanic.trees.graph.TreeShape;
import com.sipke.features.botanic.trees.leaf.LeafShape;
import com.sipke.registeries.RegistryContainer;
import com.sipke.registeries.WorldRegistries;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaTrees {

    public static final RegistryContainer<TreeConfig> oak = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "oak").setFamily("oak")
                    .setTreeTraits(80, TreeShape.circle, LeafShape.circle, 5, 14, false)
                    .setTrunkRule(0.785f, 1, 0.215f, 0.43f,2)
                    .setInnerBranchRule(0.785f, 0.618f,5, 45f, 60.5f)
                    .setOuterBranchRule(0.57f,0.382f,3,67.5f,37.5f)
                    .setRootRule(8, 5, -24, 75)
                    .setWindRule(13, 0.382f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.618f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.785f).setMaxAge(4))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> big_oak = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "big_oak").setFamily("oak")
                    .setTreeTraits(80, TreeShape.circle, LeafShape.circle, 8, 24, false)
                    .setTrunkRule(0.785f, 2, 0.385f, 0.57f,2)
                    .setInnerBranchRule(0.82f, 0.618f,7, 45f, 60.5f)
                    .setOuterBranchRule(0.57f,0.382f,5,6.5f,37.5f)
                    .setRootRule(8, 5, -24, 65)
                    .setWindRule(16, 0.215f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.57f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f).setMaxAge(4))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> pale_oak = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "pale_oak").setFamily("pale_oak")
                    .setTreeTraits(80, TreeShape.circle, LeafShape.circle, 9, 12, false)
                    .setTrunkRule(0.785f, 3, 0.215f, 0.43f,2)
                    .setInnerBranchRule(0.785f, 0.618f,5, 50.5f, 60.5f)
                    .setOuterBranchRule(0.57f,0.382f,3,37.5f,37.5f)
                    .setRootRule(8,5,-24,65)
                    .setWindRule(9, 0.382f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.57f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f).setMaxAge(4))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> dark_oak = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "dark_oak").setFamily("dark_oak")
                    .setTreeTraits(120, TreeShape.circle, LeafShape.circle, 7, 24, false)
                    .setTrunkRule(0.82f, 3, 0.382f, 0.57f,2)
                    .setInnerBranchRule(0.82f, 0.618f,5, 24.5f, 60.5f)
                    .setOuterBranchRule(0.785f,0.382f,7,6.5f,37.5f)
                    .setRootRule(8,5,-24,65)
                    .setWindRule(16, 0.215f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.57f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f).setMaxAge(4))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> spruce = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "spruce").setFamily("spruce")
                    .setTreeTraits(120, TreeShape.cone, LeafShape.cone,  3, 24, true)
                    .setTrunkRule(0.98f, 2, 0.125f, 0.215f,1)
                    .setInnerBranchRule(0.57f, 0.382f,2, -50.5f, 45.5f)
                    .setOuterBranchRule(0.785f,0.215f,2,-24.5f,37.5f)
                    .setRootRule(5,7,-37,95)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.57f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f).setMaxAge(4))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> tall_spruce = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "tall_spruce").setFamily("spruce")
                    .setTreeTraits(120, TreeShape.cone, LeafShape.cone,  7, TreeUtil.height, true)
                    .setTrunkRule(0.88f, 3, 0.215f, 0.215f,2)
                    .setInnerBranchRule(0.785f, 0.382f,8, -37f, 37.5f)
                    .setOuterBranchRule(0.57f,0.215f,5,-12,60.5f)
                    .setRootRule(5,7,-37,95)
                    .setWindRule(16, 0.0625f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.57f))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.215f))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f))
                    .build());

    public static final RegistryContainer<TreeConfig> silver_birch = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "silver_birch").setFamily("birch")
                    .setTreeTraits(50, TreeShape.circle, LeafShape.circleSmall,  3, 16, false)
                    .setTrunkRule(0.785f, 1, 0.382f, 0.57f,1)
                    .setInnerBranchRule(0.785f, 0.215f,2, 37.5f, 57.5f)
                    .setOuterBranchRule(0.785f,0.125f,3,72.5f,45.5f)
                    .setRootRule(5,7,-37,95)
                    .setWindRule(16, 0.0625f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(0))
                    .build());

    public static final RegistryContainer<TreeConfig> tall_birch = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "tall_birch").setFamily("birch")
                    .setTreeTraits(65, TreeShape.cone, LeafShape.dome,  5, 16, false)
                    .setTrunkRule(0.785f, 2, 0.382f, 0.125f,1)
                    .setInnerBranchRule(0.57f, 0.382f,3, 12, 57.5f)
                    .setOuterBranchRule(0.785f,0.215f,3,-72.5f,45.5f)
                    .setRootRule(4,5,-37,67)
                    .setWindRule(16, 0.125f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(0))
                    .build());

    public static final RegistryContainer<TreeConfig> cherry = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "cherry").setFamily("cherry")
                    .setTreeTraits(65, TreeShape.circle, LeafShape.circleSmall,  5, 16, false)
                    .setTrunkRule(0.57f, 2, 0.382f, 0.5f,1)
                    .setInnerBranchRule(0.57f, 0.382f,2, 72, 24.5f)
                    .setOuterBranchRule(0.785f,0.215f,3,-12.5f,75.5f)
                    .setRootRule(4,5,-37,67)
                    .setWindRule(16, 0.215f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(0))
                    .build());

    public static final RegistryContainer<TreeConfig> acacia = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "acacia").setFamily("acacia")
                    .setTreeTraits(80, TreeShape.circle, LeafShape.dome,  9, 16, false)
                    .setTrunkRule(0.82f, 2, 0.125f, 0.618f,2)
                    .setInnerBranchRule(0.88f, 0.382f,3, 12.5f, 45.5f)
                    .setOuterBranchRule(0.618f,0.215f,8,-12.5f,37.5f)
                    .setRootRule(8,7,-37,67)
                    .setWindRule(32, 0.215f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> azalea = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "azalea").setFamily("azalea")
                    .setTreeTraits(38, TreeShape.dome, LeafShape.circle,  7, 2, false)
                    .setTrunkRule(0.57f, 2, 0.382f, 0.0382f,1)
                    .setInnerBranchRule(0.88f, 0.382f,2, 12.5f, 45.5f)
                    .setOuterBranchRule(0.618f,0.215f,8,-12.5f,37.5f)
                    .setRootRule(4,5,-37,67)
                    .setWindRule(16, 0.382f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> jungle = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "jungle").setFamily("jungle")
                    .setTreeTraits(80, TreeShape.circle, LeafShape.dome,  13, 48, false)
                    .setTrunkRule(0.82f, 5, 0.215f, 0.215f,3)
                    .setInnerBranchRule(0.785f, 0.382f,5, 5f, 37.5f)
                    .setOuterBranchRule(0.57f,0.215f,8,47f,60.5f)
                    .setRootRule(8,7,-37,67)
                    .setWindRule(16, 0.57f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static final RegistryContainer<TreeConfig> mangrove = WorldRegistries.TREES.register(
            new TreeConfig.Builder(vanillaId, "mangrove").setFamily("mangrove")
                    .setTreeTraits(80, TreeShape.dome, LeafShape.dome,  9, 16, false)
                    .setTrunkRule(0.57f, 2, 0.215f, 0.215f,2)
                    .setInnerBranchRule(0.57f, 0.382f,5, 24f, 37.5f)
                    .setOuterBranchRule(0.57f,0.215f,5,-72,60.5f)
                    .setRootRule(13,3,-37,88)
                    .setWindRule(16, 0.382f)
                    .setSeasonalRule(Season.EARLY_SPRING, new TreeSeasonalRule.Builder().setGrowthChange(0.785f).setMaxAge(2))
                    .setSeasonalRule(Season.EARLY_SUMMER, new TreeSeasonalRule.Builder().setGrowthChange(0.618f))
                    .setSeasonalRule(Season.MID_AUTUMN, new TreeSeasonalRule.Builder().setGrowthChange(0.382f).setMaxAge(3))
                    .setSeasonalRule(Season.EARLY_WINTER, new TreeSeasonalRule.Builder().setGrowthChange(0.215f).setMaxAge(1))
                    .build());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded trees");
    }

}
