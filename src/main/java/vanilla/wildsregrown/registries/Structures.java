package vanilla.wildsregrown.registries;

import com.sipke.api.features.structures.Structure;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.VanillaStructure;
import vanilla.wildsregrown.registries.structures.Outpost;
import vanilla.wildsregrown.registries.structures.WalledOutpost;
import vanilla.wildsregrown.registries.structures.WalledVillage;

public class Structures {

    public static final RegistryObject<Structure> swamp_hut = WorldRegistries.STRUCTURES.register(new VanillaStructure("swamp_hut", -16,0,-16, 32,32,32, 8, 48, 2));
    public static final RegistryObject<Structure> igloo = WorldRegistries.STRUCTURES.register(new VanillaStructure("igloo", -16,0,-16, 32,32,32, 12, 32, 1));
    public static final RegistryObject<Structure> jungle_temple = WorldRegistries.STRUCTURES.register(new VanillaStructure("jungle_temple", -16,0,-16, 32,32,32, 12, 32, 1));
    public static final RegistryObject<Structure> pillager_outpost = WorldRegistries.STRUCTURES.register(new Outpost());
    public static final RegistryObject<Structure> walled_pillager_outpost = WorldRegistries.STRUCTURES.register(new WalledOutpost());
    public static final RegistryObject<Structure> mansion = WorldRegistries.STRUCTURES.register(new VanillaStructure("mansion", -32,0,-32, 32,32,32, 32, 64, 12));
    public static final RegistryObject<Structure> desert_pyramid = WorldRegistries.STRUCTURES.register(new VanillaStructure("desert_pyramid", -16,-1,-16, 16,16,16, 24, 44, 2));
    public static final RegistryObject<Structure> village = WorldRegistries.STRUCTURES.register(new VanillaStructure("village", -32,0,-32, 32,16,32, 32, 180, 6));
    public static final RegistryObject<Structure> walled_village = WorldRegistries.STRUCTURES.register(new WalledVillage());

    //?
    public static final RegistryObject<Structure> ruined_portal = WorldRegistries.STRUCTURES.register(new VanillaStructure("ruined_portal", 0,0,0, 16,16,16, 24, 16, 2));

    //underground
    public static final RegistryObject<Structure> ancient_city = WorldRegistries.STRUCTURES.register(new VanillaStructure("ancient_city", -32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryObject<Structure> mineshaft = WorldRegistries.STRUCTURES.register(new VanillaStructure("mineshaft", -32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryObject<Structure> stronghold = WorldRegistries.STRUCTURES.register(new VanillaStructure("stronghold", -32,0,-32, 32,32,32, 32, 0, 0));
    public static final RegistryObject<Structure> buried_treasure = WorldRegistries.STRUCTURES.register(new VanillaStructure("buried_treasure", -32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryObject<Structure> trail_ruins = WorldRegistries.STRUCTURES.register(new VanillaStructure("trail_ruins", -32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryObject<Structure> trail_chamber = WorldRegistries.STRUCTURES.register(new VanillaStructure("trail_chamber", -32,0,-32, 32,32,32, 12, 0, 0));

    //Sea
    public static final RegistryObject<Structure> shipwreck = WorldRegistries.STRUCTURES.register(new VanillaStructure("shipwreck", -32,0,-32, 32,32,32, 16, 0, 0));
    public static final RegistryObject<Structure> ocean_ruin = WorldRegistries.STRUCTURES.register(new VanillaStructure("ocean_ruin", -32,0,-32, 32,32,32, 32, 0, 0));
    public static final RegistryObject<Structure> monument = WorldRegistries.STRUCTURES.register(new VanillaStructure("monument", -32,0,-32, 32,32,32, 18, 0, 0));


    public static void init(){
        WorldRegistries.STRUCTURES.bootstrap();
        WRGVanilla.LOGGER.info("loaded structures");
    }

}
