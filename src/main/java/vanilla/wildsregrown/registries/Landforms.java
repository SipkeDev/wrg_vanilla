package vanilla.wildsregrown.registries;

import com.sipke.api.terrain.Landform;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.landforms.HighLands;
import vanilla.wildsregrown.landforms.Mountain;
import vanilla.wildsregrown.landforms.Plains;
import vanilla.wildsregrown.landforms.Shallows;

public class Landforms {

    public static final RegistryObject<Landform> mountain = WorldRegistries.LANDFORMS.register(new Mountain());
    public static final RegistryObject<Landform> highlands = WorldRegistries.LANDFORMS.register(new HighLands());
    public static final RegistryObject<Landform> plains = WorldRegistries.LANDFORMS.register(new Plains());
    public static final RegistryObject<Landform> shallows = WorldRegistries.LANDFORMS.register(new Shallows());

    public static void init(){
        WorldRegistries.LANDFORMS.bootstrap();
        WRGVanilla.LOGGER.info("loaded landforms");
    }

}
