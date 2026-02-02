package vanilla.wildsregrown.registries;

import com.sipke.api.geology.GeoMaterial;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.core.RegistryObject;
import net.minecraft.block.Blocks;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.materials.VanillaMaterial;

/**
 * ##CONFIG
 * #name
 * #Density (transfer rate + intertia)
 * #friction
 * #thalusAngle
 * ##TRANSFORMERS
 * #weathers   (Surface)
 * #collapses  (Thermal)
 * #transports (Hydraulic)
 */
public class Materials {

    //Soils
    public static final RegistryObject<GeoMaterial> sand = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.SAND.getTranslationKey(), 0.1f, 0.5f, 2,c(),c(),c()));
    public static final RegistryObject<GeoMaterial> red_sand = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.RED_SAND.getTranslationKey(),0.1f, 0.5f, 2,c(),c(),c()));
    public static final RegistryObject<GeoMaterial> dirt = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.DIRT.getTranslationKey(),  0.15f, 0.5f, 2,c(),c(),c()));
    public static final RegistryObject<GeoMaterial> coarse_dirt = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.COARSE_DIRT.getTranslationKey(), 0.12f, 0.5f, 2,c(),c(),c()));
    public static final RegistryObject<GeoMaterial> podzol = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.PODZOL.getTranslationKey(), 0.2f, 0.5f, 2,c(),c(),c()));

    //Gravels
    public static final RegistryObject<GeoMaterial> gravel = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.GRAVEL.getTranslationKey(), 0.25f, 0.5f, 5, dirt.getKey(), c(), c()));

    //Rocks
    public static final RegistryObject<GeoMaterial> cobble_stone = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.COBBLESTONE.getTranslationKey(), 0.3f, 0.5f, 2, dirt.getKey(), gravel.getKey(), c()));
    public static final RegistryObject<GeoMaterial> stone = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.STONE.getTranslationKey(),0.25f, 0.4f, 5, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));
    public static final RegistryObject<GeoMaterial> black_stone = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.BLACKSTONE.getTranslationKey(),0.45f, 0.4f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));

    public static final RegistryObject<GeoMaterial> tuff = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.TUFF.getTranslationKey(),0.3f, 0.4f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));
    public static final RegistryObject<GeoMaterial> granite = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.GRANITE.getTranslationKey(),0.8f, 0.2f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));
    public static final RegistryObject<GeoMaterial> andesite = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.ANDESITE.getTranslationKey(),0.8f, 0.2f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));
    public static final RegistryObject<GeoMaterial> diorite = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.DIORITE.getTranslationKey(),0.8f, 0.2f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));
    public static final RegistryObject<GeoMaterial> calcite = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.CALCITE.getTranslationKey(),0.8f, 0.2f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));

    public static final RegistryObject<GeoMaterial> basalt = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.BASALT.getTranslationKey(),0.8f, 0.2f, 8, dirt.getKey(), gravel.getKey(), cobble_stone.getKey()));

    public static final RegistryObject<GeoMaterial> red_sandstone = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.RED_SANDSTONE.getTranslationKey(),0.5f, 0.5f, 5, red_sand.getKey(), red_sand.getKey(), red_sand.getKey()));
    public static final RegistryObject<GeoMaterial> sandstone = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.SANDSTONE.getTranslationKey(), 0.5f, 0.5f, 5,sand.getKey(),sand.getKey(), sand.getKey()));

    public static final RegistryObject<GeoMaterial> cobble_deepslate = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.COBBLED_DEEPSLATE.getTranslationKey(),0.5f, 0.5f, 5, dirt.getKey(),c(),c()));
    public static final RegistryObject<GeoMaterial> deepslate = WorldRegistries.MATERIALS.register(new VanillaMaterial(Blocks.DEEPSLATE.getTranslationKey(), 0.5f, 0.5f, 5, dirt.getKey(), cobble_deepslate.getKey(),c()));

    static {
        WorldRegistries.MATERIALS.tagSoil(sand);
        WorldRegistries.MATERIALS.tagSoil(red_sand);
        WorldRegistries.MATERIALS.tagSoil(dirt);
        WorldRegistries.MATERIALS.tagSoil(coarse_dirt);
        WorldRegistries.MATERIALS.tagSoil(podzol);

        WorldRegistries.MATERIALS.tagGravel(gravel);

        WorldRegistries.MATERIALS.tagSoluable(stone);
        WorldRegistries.MATERIALS.tagSoluable(red_sandstone);
        WorldRegistries.MATERIALS.tagSoluable(sandstone);
        WorldRegistries.MATERIALS.tagSoluable(tuff);
        WorldRegistries.MATERIALS.tagSoluable(calcite);
    }

    public static void init(){
        WorldRegistries.MATERIALS.bootstrap();
        WRGVanilla.LOGGER.info("loaded Materials");
    }

    //current idx
    public static int c(){
        return WorldRegistries.MATERIALS.getEntries().size();
    }

}
