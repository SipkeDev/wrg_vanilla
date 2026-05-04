package wildsregrown.vanilla.registry;

import com.sipke.api.categorization.Placement;
import com.sipke.api.features.flora.Flora;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.api.registry.registerables.WRGFlora;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class VanillaFloras {

    public static final RegistryContainer<Flora> grass = WorldRegistries.FLORA.register(new WRGFlora(modid, "grass",  Placement.Flora.land));
    public static final RegistryContainer<Flora> tall_grass = WorldRegistries.FLORA.register(new WRGFlora(modid,"tall_grass",  Placement.Flora.land));
    public static final RegistryContainer<Flora> fern = WorldRegistries.FLORA.register(new WRGFlora(modid,"fern",  Placement.Flora.land));
    public static final RegistryContainer<Flora> tall_fern = WorldRegistries.FLORA.register(new WRGFlora(modid,"large_fern",  Placement.Flora.land));

    public static final RegistryContainer<Flora> dandelion = WorldRegistries.FLORA.register(new WRGFlora(modid,"dandelion",  Placement.Flora.land));
    public static final RegistryContainer<Flora> poppy = WorldRegistries.FLORA.register(new WRGFlora(modid,"poppy",  Placement.Flora.land));
    public static final RegistryContainer<Flora> blue_orchid = WorldRegistries.FLORA.register(new WRGFlora(modid,"blue_orchid",  Placement.Flora.land));
    public static final RegistryContainer<Flora> allium = WorldRegistries.FLORA.register(new WRGFlora(modid,"allium",  Placement.Flora.land));
    public static final RegistryContainer<Flora> azure_bluet = WorldRegistries.FLORA.register(new WRGFlora(modid,"azure_bluet",  Placement.Flora.land));
    public static final RegistryContainer<Flora> red_tulip = WorldRegistries.FLORA.register(new WRGFlora(modid,"red_tulip",  Placement.Flora.land));
    public static final RegistryContainer<Flora> white_tulip = WorldRegistries.FLORA.register(new WRGFlora(modid,"white_tulip",  Placement.Flora.land));
    public static final RegistryContainer<Flora> pink_tulip = WorldRegistries.FLORA.register(new WRGFlora(modid,"pink_tulip",  Placement.Flora.land));
    public static final RegistryContainer<Flora> orange_tulip = WorldRegistries.FLORA.register(new WRGFlora(modid,"orange_tulip",  Placement.Flora.land));
    public static final RegistryContainer<Flora> oxeye_daisy = WorldRegistries.FLORA.register(new WRGFlora(modid,"oxeye_daisy",  Placement.Flora.land));
    public static final RegistryContainer<Flora> cornflower = WorldRegistries.FLORA.register(new WRGFlora(modid,"cornflower",  Placement.Flora.land));
    public static final RegistryContainer<Flora> lily_of_the_valley = WorldRegistries.FLORA.register(new WRGFlora(modid,"lily_of_the_valley",  Placement.Flora.land));
    public static final RegistryContainer<Flora> torch_flower = WorldRegistries.FLORA.register(new WRGFlora(modid,"torchflower",  Placement.Flora.land));

    public static final RegistryContainer<Flora> rose_bush = WorldRegistries.FLORA.register(new WRGFlora(modid,"rose_bush",  Placement.Flora.land));
    public static final RegistryContainer<Flora> lilac = WorldRegistries.FLORA.register(new WRGFlora(modid,"lilac",  Placement.Flora.land));
    public static final RegistryContainer<Flora> peony = WorldRegistries.FLORA.register(new WRGFlora(modid,"peony",  Placement.Flora.land));

    public static final RegistryContainer<Flora> wildflower = WorldRegistries.FLORA.register(new WRGFlora(modid,"wildflowers",  Placement.Flora.land));

    public static final RegistryContainer<Flora> wheat = WorldRegistries.FLORA.register(new WRGFlora(modid,"wheat",  Placement.Flora.land));
    public static final RegistryContainer<Flora> beetroots = WorldRegistries.FLORA.register(new WRGFlora(modid,"beetroots",  Placement.Flora.land));
    public static final RegistryContainer<Flora> carrots = WorldRegistries.FLORA.register(new WRGFlora(modid,"carrots",  Placement.Flora.land));
    public static final RegistryContainer<Flora> potatoes = WorldRegistries.FLORA.register(new WRGFlora(modid,"potatoes",  Placement.Flora.land));
    public static final RegistryContainer<Flora> hay_bale = WorldRegistries.FLORA.register(new WRGFlora(modid,"hay_block",  Placement.Flora.land));

    public static void init(){
        WRGVanilla.LOGGER.info("loaded floras");
    }

}
