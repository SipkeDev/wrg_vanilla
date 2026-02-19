package vanilla.wildsregrown.registries;

import com.sipke.api.terrain.Landform;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.registries.landforms.coast.*;
import vanilla.wildsregrown.registries.landforms.highlands.*;
import vanilla.wildsregrown.registries.landforms.lowlands.*;
import vanilla.wildsregrown.registries.landforms.mountain.*;
import vanilla.wildsregrown.registries.landforms.ocean.Abyss;
import vanilla.wildsregrown.registries.landforms.ocean.Basin;
import vanilla.wildsregrown.registries.landforms.ocean.Islands;
import vanilla.wildsregrown.registries.landforms.ocean.Rocks;
import vanilla.wildsregrown.registries.landforms.sea.Ridge;
import vanilla.wildsregrown.registries.landforms.sea.Rift;

public class Landforms {

    public static final RegistryObject<Landform> mountain = WorldRegistries.LANDFORMS.register(new Mountain());
    public static final RegistryObject<Landform> mountain_ridge = WorldRegistries.LANDFORMS.register(new MountainRidge());
    public static final RegistryObject<Landform> igneious_mountain = WorldRegistries.LANDFORMS.register(new IgneiousMountain());
    public static final RegistryObject<Landform> desert_ridge = WorldRegistries.LANDFORMS.register(new DesertRidge());
    public static final RegistryObject<Landform> cold_mountains = WorldRegistries.LANDFORMS.register(new ColdMountains());

    public static final RegistryObject<Landform> ardennes = WorldRegistries.LANDFORMS.register(new Ardennes());
    public static final RegistryObject<Landform> badlands = WorldRegistries.LANDFORMS.register(new BadLands());
    public static final RegistryObject<Landform> desert_ridges = WorldRegistries.LANDFORMS.register(new DesertRidges());
    public static final RegistryObject<Landform> forest_hills = WorldRegistries.LANDFORMS.register(new ForestHills());
    public static final RegistryObject<Landform> grand_canyon = WorldRegistries.LANDFORMS.register(new GrandCanyon());
    public static final RegistryObject<Landform> highlands = WorldRegistries.LANDFORMS.register(new HighLands());
    public static final RegistryObject<Landform> hills = WorldRegistries.LANDFORMS.register(new Hills());
    public static final RegistryObject<Landform> mesa = WorldRegistries.LANDFORMS.register(new Mesa());
    public static final RegistryObject<Landform> plateau = WorldRegistries.LANDFORMS.register(new Plateau());
    public static final RegistryObject<Landform> rolling_hills = WorldRegistries.LANDFORMS.register(new RollingHills());

    public static final RegistryObject<Landform> desert_dunes = WorldRegistries.LANDFORMS.register(new DesertDunes());
    public static final RegistryObject<Landform> flat_lands = WorldRegistries.LANDFORMS.register(new FlatLands());
    public static final RegistryObject<Landform> great_plains = WorldRegistries.LANDFORMS.register(new GreatPlains());
    public static final RegistryObject<Landform> mystic_plains = WorldRegistries.LANDFORMS.register(new MysticPlains());
    public static final RegistryObject<Landform> plains = WorldRegistries.LANDFORMS.register(new Plains());
    public static final RegistryObject<Landform> priaries = WorldRegistries.LANDFORMS.register(new Priaries());
    public static final RegistryObject<Landform> tundra = WorldRegistries.LANDFORMS.register(new Tundra());
    public static final RegistryObject<Landform> worse_lands = WorldRegistries.LANDFORMS.register(new WorseLands());

    public static final RegistryObject<Landform> cliffs = WorldRegistries.LANDFORMS.register(new Cliffs());
    public static final RegistryObject<Landform> desert_beach = WorldRegistries.LANDFORMS.register(new DesertBeach());
    public static final RegistryObject<Landform> dunes = WorldRegistries.LANDFORMS.register(new Dunes());
    public static final RegistryObject<Landform> shallows = WorldRegistries.LANDFORMS.register(new Shallows());
    public static final RegistryObject<Landform> tiny_cliffs = WorldRegistries.LANDFORMS.register(new TinyCliffs());

    public static final RegistryObject<Landform> abyss = WorldRegistries.LANDFORMS.register(new Abyss());
    public static final RegistryObject<Landform> basin = WorldRegistries.LANDFORMS.register(new Basin());
    public static final RegistryObject<Landform> islands = WorldRegistries.LANDFORMS.register(new Islands());
    public static final RegistryObject<Landform> rocks = WorldRegistries.LANDFORMS.register(new Rocks());

    public static final RegistryObject<Landform> ridge = WorldRegistries.LANDFORMS.register(new Ridge());
    public static final RegistryObject<Landform> rift = WorldRegistries.LANDFORMS.register(new Rift());

    public static void init(){
        WorldRegistries.LANDFORMS.bootstrap();
        WRGVanilla.LOGGER.info("loaded landforms");
    }

}
