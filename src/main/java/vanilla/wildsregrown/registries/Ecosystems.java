package vanilla.wildsregrown.registries;

import com.sipke.api.terrain.Ecosystem;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.ecosystems.*;

public class Ecosystems {

    //Vanilla
    public static final RegistryObject<Ecosystem> coldOcean = WorldRegistries.ECOSYSTEMS.register(new ColdOcean());
    public static final RegistryObject<Ecosystem> ocean = WorldRegistries.ECOSYSTEMS.register(new Ocean());
    public static final RegistryObject<Ecosystem> warmOcean = WorldRegistries.ECOSYSTEMS.register(new WarmOcean());
    public static final RegistryObject<Ecosystem> coldSea = WorldRegistries.ECOSYSTEMS.register(new ColdSea());
    public static final RegistryObject<Ecosystem> sea = WorldRegistries.ECOSYSTEMS.register(new Sea());
    public static final RegistryObject<Ecosystem> warmSea = WorldRegistries.ECOSYSTEMS.register(new WarmSea());

    public static final RegistryObject<Ecosystem> steppe = WorldRegistries.ECOSYSTEMS.register(new Steppe());
    public static final RegistryObject<Ecosystem> mixed_forest = WorldRegistries.ECOSYSTEMS.register(new MixedForest());
    public static final RegistryObject<Ecosystem> cool_shrubland = WorldRegistries.ECOSYSTEMS.register(new HotShrubland());
    public static final RegistryObject<Ecosystem> hot_desert = WorldRegistries.ECOSYSTEMS.register(new HotDesert());

    public static void init(){
        WorldRegistries.ECOSYSTEMS.bootstrap();
        WRGVanilla.LOGGER.info("loaded ecosystems");
    }

}
