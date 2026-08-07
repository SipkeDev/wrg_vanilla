package wildsregrown.vanilla.registry;

import com.sipke.api.features.botanic.flora.config.FloraConfig;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaFloras {

    public static final RegistryContainer<FloraConfig> grass = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId, "grass").build());
    public static final RegistryContainer<FloraConfig> tall_grass = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"tall_grass").build());
    public static final RegistryContainer<FloraConfig> fern = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"fern").build());
    public static final RegistryContainer<FloraConfig> tall_fern = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"large_fern").build());

    public static final RegistryContainer<FloraConfig> dandelion = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"dandelion").build());
    public static final RegistryContainer<FloraConfig> poppy = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"poppy").build());
    public static final RegistryContainer<FloraConfig> blue_orchid = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"blue_orchid").build());
    public static final RegistryContainer<FloraConfig> allium = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"allium").build());
    public static final RegistryContainer<FloraConfig> azure_bluet = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"azure_bluet").build());
    public static final RegistryContainer<FloraConfig> red_tulip = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"red_tulip").build());
    public static final RegistryContainer<FloraConfig> white_tulip = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"white_tulip").build());
    public static final RegistryContainer<FloraConfig> pink_tulip = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"pink_tulip").build());
    public static final RegistryContainer<FloraConfig> orange_tulip = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"orange_tulip").build());
    public static final RegistryContainer<FloraConfig> oxeye_daisy = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"oxeye_daisy").build());
    public static final RegistryContainer<FloraConfig> cornflower = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"cornflower").build());
    public static final RegistryContainer<FloraConfig> lily_of_the_valley = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"lily_of_the_valley").build());
    public static final RegistryContainer<FloraConfig> torch_flower = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"torchflower").build());

    public static final RegistryContainer<FloraConfig> rose_bush = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"rose_bush").build());
    public static final RegistryContainer<FloraConfig> lilac = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"lilac").build());
    public static final RegistryContainer<FloraConfig> peony = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"peony").build());

    public static final RegistryContainer<FloraConfig> pink_petals = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId, "pink_petals").build());
    public static final RegistryContainer<FloraConfig> wildflower = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"wildflowers").build());
    public static final RegistryContainer<FloraConfig> sunflower = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"sunflower").build());
    public static final RegistryContainer<FloraConfig> sweet_berry_bush = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"sweet_berry_bush").build());
    public static final RegistryContainer<FloraConfig> bush = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"bush").build());

    ///Desert
    public static final RegistryContainer<FloraConfig> dead_bush = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"dead_bush").build());
    public static final RegistryContainer<FloraConfig> cactus = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"cactus").build());
    public static final RegistryContainer<FloraConfig> cactus_flower = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"cactus_flower").build());

    /// misc
    public static final RegistryContainer<FloraConfig> leaf_litter = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"leaf_litter").build());
    public static final RegistryContainer<FloraConfig> short_dry_grass = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"short_dry_grass").build());
    public static final RegistryContainer<FloraConfig> tall_dry_grass = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"tall_dry_grass").build());

    /// Food
    public static final RegistryContainer<FloraConfig> wheat = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"wheat").build());
    public static final RegistryContainer<FloraConfig> beetroots = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"beetroots").build());
    public static final RegistryContainer<FloraConfig> carrots = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"carrots").build());
    public static final RegistryContainer<FloraConfig> potatoes = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"potatoes").build());
    public static final RegistryContainer<FloraConfig> hay_bale = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"hay_block").build());
    public static final RegistryContainer<FloraConfig> sugar_cane = WorldRegistries.FLORA.register(new FloraConfig.Builder(vanillaId,"sugar_cane").build());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded floras");
    }

}
