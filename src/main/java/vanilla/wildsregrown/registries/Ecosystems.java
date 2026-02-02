package vanilla.wildsregrown.registries;

import com.sipke.api.terrain.Ecosystem;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.registries.ecosystems.*;
import vanilla.wildsregrown.registries.ecosystems.sea.*;

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
    public static final RegistryObject<Ecosystem> hot_shrubland = WorldRegistries.ECOSYSTEMS.register(new HotShrubland());
    public static final RegistryObject<Ecosystem> cool_shrubland = WorldRegistries.ECOSYSTEMS.register(new CoolShrubland());
    public static final RegistryObject<Ecosystem> hot_desert = WorldRegistries.ECOSYSTEMS.register(new HotDesert());
    public static final RegistryObject<Ecosystem> cool_desert = WorldRegistries.ECOSYSTEMS.register(new CoolDesert());
    public static final RegistryObject<Ecosystem> savanna = WorldRegistries.ECOSYSTEMS.register(new Savanna());
    public static final RegistryObject<Ecosystem> spirit_forest = WorldRegistries.ECOSYSTEMS.register(new SpiritForest());
    public static final RegistryObject<Ecosystem> chapparal = WorldRegistries.ECOSYSTEMS.register(new Chapparal());
    public static final RegistryObject<Ecosystem> ice = WorldRegistries.ECOSYSTEMS.register(new Ice());
    public static final RegistryObject<Ecosystem> polar_desert = WorldRegistries.ECOSYSTEMS.register(new PolarDesert());
    public static final RegistryObject<Ecosystem> tundra = WorldRegistries.ECOSYSTEMS.register(new Tundra());

    public static final RegistryObject<Ecosystem> ancient_forest = WorldRegistries.ECOSYSTEMS.register(new AncientForest());
    public static final RegistryObject<Ecosystem> coniferious_forest = WorldRegistries.ECOSYSTEMS.register(new ConiferiousForest());
    public static final RegistryObject<Ecosystem> decidious_forest = WorldRegistries.ECOSYSTEMS.register(new DecidiousForest());

    public static void init(){
        WorldRegistries.ECOSYSTEMS.bootstrap();
        WRGVanilla.LOGGER.info("loaded ecosystems");
    }

}
