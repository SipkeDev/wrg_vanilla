package vanilla.wildsregrown.world.decorator;

import com.sipke.api.chunk.Chunk;
import com.sipke.api.features.flora.FloraPos;
import com.sipke.math.MathUtil;
import com.sipke.registeries.WorldRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.StructureWorldAccess;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.api.IdentifiableRegistery;
import vanilla.wildsregrown.world.WRGChunkGenerator;

import static com.sipke.WorldConstants.chunkSize;

public class FloraDecorator {

    private final WRGChunkGenerator chunkGenerator;

    public FloraDecorator(WRGChunkGenerator chunkGenerator){
        this.chunkGenerator = chunkGenerator;
    }

    //Fill chunk from Column Chunk
    public void apply(StructureWorldAccess world, net.minecraft.world.chunk.Chunk chunk) {

        ChunkPos chunkPos = chunk.getPos();
        int globalX = chunkPos.getStartX();
        int globalZ = chunkPos.getStartZ();

        //Creating BlockPos Instance.
        BlockPos.Mutable blockPos = new BlockPos.Mutable();
        Chunk noiseChunk = chunkGenerator.getWorld().generator.getNoiseChunk(globalX, globalZ);

        //Flora
        for (int i = 0; i < chunkSize; i++) {
            for (int j = 0; j < chunkSize; j++) {

                int idx = i*chunkSize+j;
                FloraPos pos = noiseChunk.getColumn(idx).getFlora();

                if (pos.key() != 0) {

                    blockPos.setY((int)noiseChunk.getTile(idx).height);
                    blockPos.setX(globalX + i);
                    blockPos.setZ(globalZ + j);

                    if (WorldRegistries.FLORA.get(pos.key()) instanceof IdentifiableRegistery registery){
                        Identifier identifier = registery.getIdentifier();
                        Block block = Registries.BLOCK.get(identifier);
                        if (block == Blocks.AIR){
                            WRGVanilla.LOGGER.info(WorldRegistries.FLORA.get(pos.key()).getName());
                        }
                        if (block == Blocks.WHEAT || block == Blocks.BEETROOTS || block == Blocks.CARROTS){
                            BlockState state = block.getDefaultState();
                            if (state.contains(Properties.AGE_3)){
                                state = state.with(Properties.AGE_3, MathUtil.round(MathUtil.range(pos.age(), 0, 3)));
                            }
                            if (state.contains(Properties.AGE_7)){
                                state = state.with(Properties.AGE_7, MathUtil.round(MathUtil.range(pos.age(), 0, 7)));
                            }
                            world.setBlockState(blockPos, state, 19);
                            world.setBlockState(blockPos.down(), Blocks.FARMLAND.getDefaultState().with(Properties.MOISTURE, world.getRandom().nextBetween(3, 7)), 19);
                        }else {
                            world.setBlockState(blockPos, block.getDefaultState(), 19);
                        }
                    }
                }
            }
        }
    }

}
