package vanilla.wildsregrown.registries;

import com.sipke.api.categorization.Placement;
import com.sipke.api.features.flora.Flora;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import net.minecraft.block.Blocks;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.VanillaFlora;

public class Floras {

    public static final RegistryObject<Flora> grass = WorldRegistries.FLORA.register(new VanillaFlora("grass", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> tall_grass = WorldRegistries.FLORA.register(new VanillaFlora("tall_grass", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> fern = WorldRegistries.FLORA.register(new VanillaFlora("fern", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> tall_fern = WorldRegistries.FLORA.register(new VanillaFlora("large_fern", 0, Placement.Flora.land));

    public static final RegistryObject<Flora> dandelion = WorldRegistries.FLORA.register(new VanillaFlora("dandelion", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> poppy = WorldRegistries.FLORA.register(new VanillaFlora("poppy", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> blue_orchid = WorldRegistries.FLORA.register(new VanillaFlora("blue_orchid", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> allium = WorldRegistries.FLORA.register(new VanillaFlora("allium", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> azure_bluet = WorldRegistries.FLORA.register(new VanillaFlora("azure_bluet", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> red_tulip = WorldRegistries.FLORA.register(new VanillaFlora("red_tulip", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> white_tulip = WorldRegistries.FLORA.register(new VanillaFlora("white_tulip", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> pink_tulip = WorldRegistries.FLORA.register(new VanillaFlora("pink_tulip", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> orange_tulip = WorldRegistries.FLORA.register(new VanillaFlora("orange_tulip", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> oxeye_daisy = WorldRegistries.FLORA.register(new VanillaFlora("oxeye_daisy", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> cornflower = WorldRegistries.FLORA.register(new VanillaFlora("cornflower", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> lily_of_the_valley = WorldRegistries.FLORA.register(new VanillaFlora("lily_of_the_valley", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> torch_flower = WorldRegistries.FLORA.register(new VanillaFlora("torchflower", 0, Placement.Flora.land));

    public static final RegistryObject<Flora> rose_bush = WorldRegistries.FLORA.register(new VanillaFlora("rose_bush", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> lilac = WorldRegistries.FLORA.register(new VanillaFlora("lilac", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> peony = WorldRegistries.FLORA.register(new VanillaFlora("peony", 0, Placement.Flora.land));

    public static final RegistryObject<Flora> wildflower = WorldRegistries.FLORA.register(new VanillaFlora("wildflowers", 0, Placement.Flora.land));

    public static final RegistryObject<Flora> wheat = WorldRegistries.FLORA.register(new VanillaFlora("wheat", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> beetroots = WorldRegistries.FLORA.register(new VanillaFlora("beetroots", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> carrots = WorldRegistries.FLORA.register(new VanillaFlora("carrots", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> potatoes = WorldRegistries.FLORA.register(new VanillaFlora("potatoes", 0, Placement.Flora.land));
    public static final RegistryObject<Flora> hay_bale = WorldRegistries.FLORA.register(new VanillaFlora("hay_block", 0, Placement.Flora.land));

    public static void init(){
        WorldRegistries.FLORA.bootstrap();
        WRGVanilla.LOGGER.info("loaded floras");
    }

}
