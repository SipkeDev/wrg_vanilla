package vanilla.wildsregrown.world.decorator;

import com.sipke.api.chunk.Chunk;
import com.sipke.api.geology.GeoMaterial;
import com.sipke.api.geology.Stratum;
import com.sipke.generator.WorldGenerator;
import com.sipke.math.MathUtil;
import com.sipke.registeries.WorldRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.IdentifiableRegistery;
import vanilla.wildsregrown.api.materials.IdentifierMaterial;
import vanilla.wildsregrown.api.materials.VanillaMaterial;
import vanilla.wildsregrown.world.WRGChunkGenerator;

import java.util.LinkedList;
import static com.sipke.WorldConstants.chunkSize;

public class BaseDecorator implements Decorator {

    private final WRGChunkGenerator chunkGenerator;

    public BaseDecorator(WRGChunkGenerator chunkGenerator) {
        this.chunkGenerator = chunkGenerator;
    }

    //Fill chunk from Column Chunk
    public void apply(net.minecraft.world.chunk.Chunk chunk) {

        ChunkPos chunkPos = chunk.getPos();
        int chunkX = chunkPos.getStartX();
        int chunkZ = chunkPos.getStartZ();

        //Creating BlockPos Instance.
        BlockPos.Mutable blockPos = new BlockPos.Mutable();

        WorldGenerator generator = chunkGenerator.getWorld().generator;
        Chunk noiseChunk = generator.getNoiseChunk(chunkX, chunkZ);

        //Iterate Chunk positions
        for (int xi = 0; xi < chunkSize; ++xi) {
            for (int zi = 0; zi < chunkSize; ++zi) {

                int idx = xi * chunkSize + zi;
                int x = chunkX + xi;
                int y = MathUtil.floor(noiseChunk.getTile(idx).height);
                int z = chunkZ + zi;

                int waterLevel = MathUtil.ceil(noiseChunk.getTile(idx).waterLevel);

                //Set Blockpos
                blockPos.setX(x);
                blockPos.setZ(z);

                LinkedList<Stratum> strata = noiseChunk.getColumn(idx).getStrata();
                for (int i = 0; i < strata.size(); i++) {
                    Stratum stratum = strata.get(i);
                    GeoMaterial material = WorldRegistries.MATERIALS.get(stratum.geoKey);

                    Block block = Blocks.STONE;
                    if (WorldRegistries.MATERIALS.isAir(stratum)){
                        block = Blocks.AIR;
                    }else
                    if (material instanceof IdentifiableRegistery id) {
                        block = Registries.BLOCK.get(id.getIdentifier());
                    }

                    for (int k = stratum.getFloor(); k < stratum.getCeil(); k++) {
                        blockPos.setY(k);
                        setBlock(chunk, blockPos, block);
                    }

                    if (block == Blocks.DIRT && noiseChunk.getColumn(idx).isOvergrown()){
                        block = Blocks.GRASS_BLOCK;
                        blockPos.setY(y-1);
                        setBlock(chunk, blockPos, block);
                    }

                }

                fillAirLayer(chunk, blockPos, 0, waterLevel, Blocks.WATER);


            }//for x
        }//for z
    }

}