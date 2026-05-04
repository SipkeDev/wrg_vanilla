package wildsregrown.vanilla.registry;

import com.sipke.api.terrain.Ecosystem;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;
import wildsregrown.vanilla.registry.ecosystems.*;
import wildsregrown.vanilla.registry.ecosystems.sea.*;

public class VanillaEcosystems {

    //Vanilla
    public static final RegistryContainer<Ecosystem> coldOcean = WorldRegistries.ECOSYSTEMS.register(new ColdOcean());
    public static final RegistryContainer<Ecosystem> ocean = WorldRegistries.ECOSYSTEMS.register(new Ocean());
    public static final RegistryContainer<Ecosystem> warmOcean = WorldRegistries.ECOSYSTEMS.register(new WarmOcean());
    public static final RegistryContainer<Ecosystem> coldSea = WorldRegistries.ECOSYSTEMS.register(new ColdSea());
    public static final RegistryContainer<Ecosystem> sea = WorldRegistries.ECOSYSTEMS.register(new Sea());
    public static final RegistryContainer<Ecosystem> warmSea = WorldRegistries.ECOSYSTEMS.register(new WarmSea());

    public static final RegistryContainer<Ecosystem> steppe = WorldRegistries.ECOSYSTEMS.register(new Steppe());
    public static final RegistryContainer<Ecosystem> mixed_forest = WorldRegistries.ECOSYSTEMS.register(new MixedForest());
    public static final RegistryContainer<Ecosystem> hot_shrubland = WorldRegistries.ECOSYSTEMS.register(new HotShrubland());
    public static final RegistryContainer<Ecosystem> cool_shrubland = WorldRegistries.ECOSYSTEMS.register(new CoolShrubland());
    public static final RegistryContainer<Ecosystem> hot_desert = WorldRegistries.ECOSYSTEMS.register(new HotDesert());
    public static final RegistryContainer<Ecosystem> cool_desert = WorldRegistries.ECOSYSTEMS.register(new CoolDesert());
    public static final RegistryContainer<Ecosystem> savanna = WorldRegistries.ECOSYSTEMS.register(new Savanna());
    public static final RegistryContainer<Ecosystem> spirit_forest = WorldRegistries.ECOSYSTEMS.register(new SpiritForest());
    public static final RegistryContainer<Ecosystem> chapparal = WorldRegistries.ECOSYSTEMS.register(new Chapparal());
    public static final RegistryContainer<Ecosystem> ice = WorldRegistries.ECOSYSTEMS.register(new Ice());
    public static final RegistryContainer<Ecosystem> polar_desert = WorldRegistries.ECOSYSTEMS.register(new PolarDesert());
    public static final RegistryContainer<Ecosystem> tundra = WorldRegistries.ECOSYSTEMS.register(new Tundra());

    public static final RegistryContainer<Ecosystem> ancient_forest = WorldRegistries.ECOSYSTEMS.register(new AncientForest());
    public static final RegistryContainer<Ecosystem> coniferious_forest = WorldRegistries.ECOSYSTEMS.register(new ConiferiousForest());
    public static final RegistryContainer<Ecosystem> decidious_forest = WorldRegistries.ECOSYSTEMS.register(new DecidiousForest());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded ecosystems");
    }

}
