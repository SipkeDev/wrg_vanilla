package vanilla.wildsregrown.registries;

import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.landforms.mountains.AncientGiants;
import vanilla.wildsregrown.WRGVanilla;

public class Landforms {

    public void init(){

        WorldRegistries.LANDFORMS.register(new AncientGiants(0));
        WorldRegistries.LANDFORMS.register(new AncientGiants(0));
        WorldRegistries.LANDFORMS.register(new AncientGiants(0));
        WorldRegistries.LANDFORMS.register(new AncientGiants(0));
        WorldRegistries.LANDFORMS.register(new AncientGiants(0));
        WorldRegistries.LANDFORMS.register(new AncientGiants(0));

        WRGVanilla.LOGGER.info("loaded landforms");
    }

}
