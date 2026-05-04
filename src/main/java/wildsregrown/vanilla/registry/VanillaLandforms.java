package wildsregrown.vanilla.registry;

import com.sipke.api.terrain.Landform;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;
import wildsregrown.vanilla.registry.landforms.coast.Beach;
import wildsregrown.vanilla.registry.landforms.coast.Cliffs;
import wildsregrown.vanilla.registry.landforms.coast.Dunes;
import wildsregrown.vanilla.registry.landforms.highlands.*;
import wildsregrown.vanilla.registry.landforms.lowlands.FlatLands;
import wildsregrown.vanilla.registry.landforms.lowlands.Plains;
import wildsregrown.vanilla.registry.landforms.lowlands.SmoothDesert;
import wildsregrown.vanilla.registry.landforms.lowlands.Tundra;
import wildsregrown.vanilla.registry.landforms.mountain.ColdMountains;
import wildsregrown.vanilla.registry.landforms.mountain.IgneiousMountain;
import wildsregrown.vanilla.registry.landforms.mountain.Mountain;
import wildsregrown.vanilla.registry.landforms.mountain.WarmMountains;
import wildsregrown.vanilla.registry.landforms.ocean.Abyss;
import wildsregrown.vanilla.registry.landforms.ocean.Basin;
import wildsregrown.vanilla.registry.landforms.sea.Ridge;
import wildsregrown.vanilla.registry.landforms.sea.Rift;

public class VanillaLandforms {

    public static final RegistryContainer<Landform> mountain = WorldRegistries.LANDFORMS.register(new Mountain());
    public static final RegistryContainer<Landform> igneous_mountain = WorldRegistries.LANDFORMS.register(new IgneiousMountain());
    public static final RegistryContainer<Landform> warm_mountains = WorldRegistries.LANDFORMS.register(new WarmMountains());
    public static final RegistryContainer<Landform> cold_mountains = WorldRegistries.LANDFORMS.register(new ColdMountains());

    public static final RegistryContainer<Landform> highlands = WorldRegistries.LANDFORMS.register(new HighLands());
    public static final RegistryContainer<Landform> hills = WorldRegistries.LANDFORMS.register(new Hills());
    public static final RegistryContainer<Landform> mesa = WorldRegistries.LANDFORMS.register(new Mesa());
    public static final RegistryContainer<Landform> plateau = WorldRegistries.LANDFORMS.register(new Plateau());
    public static final RegistryContainer<Landform> desert_dunes = WorldRegistries.LANDFORMS.register(new DesertDunes());

    public static final RegistryContainer<Landform> flat_lands = WorldRegistries.LANDFORMS.register(new FlatLands());
    public static final RegistryContainer<Landform> plains = WorldRegistries.LANDFORMS.register(new Plains());
    public static final RegistryContainer<Landform> tundra = WorldRegistries.LANDFORMS.register(new Tundra());
    public static final RegistryContainer<Landform> smooth_desert = WorldRegistries.LANDFORMS.register(new SmoothDesert());

    public static final RegistryContainer<Landform> cliffs = WorldRegistries.LANDFORMS.register(new Cliffs());
    public static final RegistryContainer<Landform> desert_beach = WorldRegistries.LANDFORMS.register(new Beach());
    public static final RegistryContainer<Landform> dunes = WorldRegistries.LANDFORMS.register(new Dunes());

    public static final RegistryContainer<Landform> abyss = WorldRegistries.LANDFORMS.register(new Abyss());
    public static final RegistryContainer<Landform> basin = WorldRegistries.LANDFORMS.register(new Basin());

    public static final RegistryContainer<Landform> ridge = WorldRegistries.LANDFORMS.register(new Ridge());
    public static final RegistryContainer<Landform> rift = WorldRegistries.LANDFORMS.register(new Rift());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded landforms");
    }

}
