package wildsregrown.vanilla.registry;

import com.sipke.api.geology.GeoMaterial;
import com.sipke.registeries.IndexedContainer;
import com.sipke.registeries.WorldRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

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
public class VanillaMaterials {
    
    private static String stripData(Block block){
        return block.getDescriptionId().replace("block.minecraft.", "");
    }

    //Soils
    public static final IndexedContainer<GeoMaterial> sand = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.SAND), 0.1f, 0.5f, 2,c(),c(),c());
    public static final IndexedContainer<GeoMaterial> red_sand = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.RED_SAND),0.1f, 0.5f, 2,c(),c(),c());
    public static final IndexedContainer<GeoMaterial> grass = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.GRASS_BLOCK),  0.25f, 0.75f, 4,c(),c(),c());
    public static final IndexedContainer<GeoMaterial> dirt = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.DIRT),  0.1f, 0.5f, 2,c(),c(),c());
    public static final IndexedContainer<GeoMaterial> coarse_dirt = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.COARSE_DIRT), 0.08f, 0.5f, 2,c(),c(),c());
    public static final IndexedContainer<GeoMaterial> podzol = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.PODZOL), 0.12f, 0.5f, 2,c(),c(),c());

    //Gravels
    public static final IndexedContainer<GeoMaterial> gravel = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.GRAVEL), 0.15f, 0.43f, 5, dirt.getIndex(), c(), c());

    //Rocks
    public static final IndexedContainer<GeoMaterial> cobble_stone = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.COBBLESTONE), 0.15f, 0.3f, 2, dirt.getIndex(), gravel.getIndex(), c());
    public static final IndexedContainer<GeoMaterial> stone = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.STONE),0.2f, 0.215f, 5, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());
    public static final IndexedContainer<GeoMaterial> black_stone = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.BLACKSTONE),0.3f, 0.215f, 8, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());

    public static final IndexedContainer<GeoMaterial> tuff = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.TUFF),0.25f, 0.2f, 8, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());
    public static final IndexedContainer<GeoMaterial> granite = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.GRANITE),0.8f, 0.2f, 8, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());
    public static final IndexedContainer<GeoMaterial> andesite = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.ANDESITE),0.8f, 0.2f, 8, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());
    public static final IndexedContainer<GeoMaterial> diorite = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.DIORITE),0.8f, 0.2f, 8, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());
    public static final IndexedContainer<GeoMaterial> calcite = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.CALCITE),0.1f, 0.1f, 5, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());

    public static final IndexedContainer<GeoMaterial> basalt = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.BASALT),0.9f, 0.1f, 8, dirt.getIndex(), gravel.getIndex(), cobble_stone.getIndex());

    public static final IndexedContainer<GeoMaterial> red_sandstone = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.RED_SANDSTONE),0.32f, 0.25f, 5, red_sand.getIndex(), red_sand.getIndex(), red_sand.getIndex());
    public static final IndexedContainer<GeoMaterial> sandstone = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.SANDSTONE), 0.32f, 0.25f, 5,sand.getIndex(),sand.getIndex(), sand.getIndex());

    public static final IndexedContainer<GeoMaterial> cobble_deepslate = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.COBBLED_DEEPSLATE),0.5f, 0.5f, 5, dirt.getIndex(),c(),c());
    public static final IndexedContainer<GeoMaterial> deepslate = WorldRegistries.MATERIALS.register(vanillaId, stripData(Blocks.DEEPSLATE), 0.5f, 0.5f, 5, dirt.getIndex(), cobble_deepslate.getIndex(),c());

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
        WRGVanilla.LOGGER.info("loaded Materials");
    }

    //current idx
    public static int c(){
        return WorldRegistries.MATERIALS.getEntries().size();
    }

}
