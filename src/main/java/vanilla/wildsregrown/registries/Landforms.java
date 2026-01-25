package vanilla.wildsregrown.registries;

import com.sipke.api.terrain.Landform;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.landforms.*;

public class Landforms {

    public static final RegistryObject<Landform> mountain = WorldRegistries.LANDFORMS.register(new Mountain());
    public static final RegistryObject<Landform> mountain_ridge = WorldRegistries.LANDFORMS.register(new MountainRidge());
    public static final RegistryObject<Landform> igneious_mountain = WorldRegistries.LANDFORMS.register(new IgneiousMountain());
    public static final RegistryObject<Landform> highlands = WorldRegistries.LANDFORMS.register(new HighLands());
    public static final RegistryObject<Landform> plains = WorldRegistries.LANDFORMS.register(new Plains());
    public static final RegistryObject<Landform> shallows = WorldRegistries.LANDFORMS.register(new Shallows());

    public static void init(){
        WorldRegistries.LANDFORMS.bootstrap();
        WRGVanilla.LOGGER.info("loaded landforms");
    }

}
