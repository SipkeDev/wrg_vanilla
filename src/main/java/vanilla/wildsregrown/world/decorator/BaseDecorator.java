package vanilla.wildsregrown.world.decorator;

import com.sipke.api.chunk.Chunk;
import com.sipke.api.geology.Stratum;
import com.sipke.generator.WorldGenerator;
import com.sipke.math.MathUtil;
import com.sipke.registeries.GeoRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import vanilla.wildsregrown.world.WRGChunkGenerator;

import java.util.LinkedList;
import java.util.Objects;

import static com.mojang.text2speech.Narrator.LOGGER;
import static com.sipke.WorldConstants.chunkSize;
import static vanilla.wildsregrown.WRGVanilla.modid;

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

                    String key = GeoRegistry.get(stratum.getKey()).name;
                    Block block = Registries.BLOCK.get(Identifier.of(modid, key));
                    boolean air = Objects.equals(key, "air");
                    if (air){
                        block = Blocks.AIR;
                    }else if(!Registries.BLOCK.containsId(Identifier.of(modid, key))){
                        LOGGER.info("Missing entry: " + key);
                    }

                    for (int k = stratum.getFloor(); k < stratum.getCeil(); k++) {
                        blockPos.setY(k);
                        setBlock(chunk, blockPos, block);
                    }

                }

                fillAirLayer(chunk, blockPos, 0, waterLevel, Blocks.WATER);


            }//for x
        }//for z
    }

}