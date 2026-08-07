package wildsregrown.vanilla.registry;

import com.sipke.api.categorization.Season;
import com.sipke.api.features.botanic.bush.config.BushConfig;
import com.sipke.api.features.botanic.bush.config.BushSeasonalRule;
import com.sipke.api.features.botanic.bush.config.BushTraits;
import com.sipke.features.botanic.bush.BushRules;
import com.sipke.features.botanic.bush.BushShape;
import com.sipke.registeries.RegistryContainer;
import com.sipke.registeries.WorldRegistries;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class VanillaBushes {

    public static final RegistryContainer<BushConfig> oak = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "oak_bush").setFamily("oak")
                    .setTraits(new BushTraits.Builder().setMaxAge(75).setDimensions(5,3).setShape(BushShape.circle))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.jagged_blob))
                    .setSeasonalRule(Season.MID_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.decay))
                    .build());

    public static final RegistryContainer<BushConfig> pale_oak = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "pale_oak_bush").setFamily("pale_oak")
                    .setTraits(new BushTraits.Builder().setMaxAge(75).setDimensions(5,3).setShape(BushShape.circle))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.jagged_blob))
                    .setSeasonalRule(Season.MID_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.decay))
                    .build());
    public static final RegistryContainer<BushConfig> dark_oak = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "dark_oak_bush").setFamily("dark_oak")
                    .setTraits(new BushTraits.Builder().setMaxAge(75).setDimensions(8,5).setShape(BushShape.circle))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.jagged_blob))
                    .setSeasonalRule(Season.MID_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.decay))
                    .build());

    public static final RegistryContainer<BushConfig> birch = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "birch_bush").setFamily("birch")
                    .setTraits(new BushTraits.Builder().setMaxAge(35).setDimensions(5,3).setShape(BushShape.dome))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.growth))
                    .setSeasonalRule(Season.MID_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.fast_decay))
                    .build());

    public static final RegistryContainer<BushConfig> spruce = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "spruce_bush").setFamily("spruce")
                    .setTraits(new BushTraits.Builder().setMaxAge(120).setDimensions(3,7).setShape(BushShape.cone))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.clouds))
                    .setSeasonalRule(Season.EARLY_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.215f).setRule(BushRules.clouds))
                    .setSeasonalRule(Season.EARLY_WINTER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.slow_decay))
                    .build());

    public static final RegistryContainer<BushConfig> azalea = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "azalea_bush").setFamily("azalea")
                    .setTraits(new BushTraits.Builder().setMaxAge(55).setDimensions(3,3).setShape(BushShape.cone))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.57f).setRule(BushRules.blob))
                    .setSeasonalRule(Season.EARLY_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.125f).setRule(BushRules.blob))
                    .setSeasonalRule(Season.EARLY_WINTER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.slow_decay))
                    .build());

    public static final RegistryContainer<BushConfig> cherry = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "cherry_bush").setFamily("cherry")
                    .setTraits(new BushTraits.Builder().setMaxAge(35).setDimensions(5,5).setShape(BushShape.circle))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.382f).setRule(BushRules.clouds))
                    .setSeasonalRule(Season.EARLY_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.125f).setRule(BushRules.clouds))
                    .setSeasonalRule(Season.EARLY_WINTER, new BushSeasonalRule.Builder().setGrowthChange(0.618f).setRule(BushRules.slow_decay))
                    .build());

    public static final RegistryContainer<BushConfig> jungle = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "jungle_bush").setFamily("jungle")
                    .setTraits(new BushTraits.Builder().setMaxAge(35).setDimensions(5,5).setShape(BushShape.cone))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.382f).setRule(BushRules.coral))
                    .setSeasonalRule(Season.EARLY_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.125f).setRule(BushRules.coral))
                    .setSeasonalRule(Season.EARLY_WINTER, new BushSeasonalRule.Builder().setGrowthChange(0.215f).setRule(BushRules.decay))
                    .build());

    public static final RegistryContainer<BushConfig> mangrove = WorldRegistries.BUSHES.register(
            new BushConfig.Builder(modid, "mangrove_bush").setFamily("mangrove")
                    .setTraits(new BushTraits.Builder().setMaxAge(35).setDimensions(5,5).setShape(BushShape.cone))
                    .setSeasonalRule(Season.EARLY_SPRING, new BushSeasonalRule.Builder().setGrowthChange(0.785f).setRule(BushRules.grow))
                    .setSeasonalRule(Season.EARLY_SUMMER, new BushSeasonalRule.Builder().setGrowthChange(0.382f).setRule(BushRules.coral))
                    .setSeasonalRule(Season.EARLY_AUTUMN, new BushSeasonalRule.Builder().setGrowthChange(0.125f).setRule(BushRules.coral))
                    .setSeasonalRule(Season.EARLY_WINTER, new BushSeasonalRule.Builder().setGrowthChange(0.215f).setRule(BushRules.decay))
                    .build());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded Bushes");
    }

}
