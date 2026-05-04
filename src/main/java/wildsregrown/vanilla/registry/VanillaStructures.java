package wildsregrown.vanilla.registry;

import com.sipke.api.features.structures.Structure;
import com.sipke.api.features.structures.StructureImpl;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;
import wildsregrown.vanilla.registry.structures.Outpost;
import wildsregrown.vanilla.registry.structures.WalledOutpost;
import wildsregrown.vanilla.registry.structures.WalledVillage;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class VanillaStructures {

    private static String path = "minecraft";
    
    public static final RegistryContainer<Structure> swamp_hut = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"swamp_hut", "", -16,0,-16, 32,32,32, 8, 48, 2));
    public static final RegistryContainer<Structure> igloo = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"igloo", "",-16,0,-16, 32,32,32, 12, 32, 1));
    public static final RegistryContainer<Structure> jungle_temple = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"jungle_temple", "",-16,0,-16, 32,32,32, 12, 32, 1));
    public static final RegistryContainer<Structure> pillager_outpost = WorldRegistries.STRUCTURES.register(new Outpost());
    public static final RegistryContainer<Structure> walled_pillager_outpost = WorldRegistries.STRUCTURES.register(new WalledOutpost());
    public static final RegistryContainer<Structure> mansion = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"mansion", "",-32,0,-32, 32,32,32, 32, 64, 12));
    public static final RegistryContainer<Structure> desert_pyramid = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"desert_pyramid", "",-16,-1,-16, 16,16,16, 24, 44, 2));
    public static final RegistryContainer<Structure> village = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"village", "",-32,0,-32, 32,16,32, 32, 180, 6));
    public static final RegistryContainer<Structure> walled_village = WorldRegistries.STRUCTURES.register(new WalledVillage());

    //?
    public static final RegistryContainer<Structure> ruined_portal = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"ruined_portal", "",0,0,0, 16,16,16, 24, 16, 2));

    //underground
    public static final RegistryContainer<Structure> ancient_city = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"ancient_city", "",-32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryContainer<Structure> mineshaft = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"mineshaft", "",-32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryContainer<Structure> stronghold = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"stronghold","", -32,0,-32, 32,32,32, 32, 0, 0));
    public static final RegistryContainer<Structure> buried_treasure = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"buried_treasure", "",-32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryContainer<Structure> trail_ruins = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"trail_ruins", "",-32,0,-32, 32,32,32, 12, 0, 0));
    public static final RegistryContainer<Structure> trail_chamber = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"trail_chamber","", -32,0,-32, 32,32,32, 12, 0, 0));

    //Sea
    public static final RegistryContainer<Structure> shipwreck = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"shipwreck", "",-32,0,-32, 32,32,32, 16, 0, 0));
    public static final RegistryContainer<Structure> ocean_ruin = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"ocean_ruin","", -32,0,-32, 32,32,32, 32, 0, 0));
    public static final RegistryContainer<Structure> monument = WorldRegistries.STRUCTURES.register(new StructureImpl(vanillaId,"ocean_monument","", -32,0,-32, 32,32,32, 18, 0, 0));


    public static void init(){
        WRGVanilla.LOGGER.info("loaded structures");
    }

}
