package vanilla.wildsregrown.mixin;


import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.RandomSequencesState;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.level.ServerWorldProperties;
import net.minecraft.world.level.storage.LevelStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.world.WRGChunkGenerator;
import vanilla.wildsregrown.world.biomes.WRGBiomeProvider;

import java.util.List;
import java.util.concurrent.Executor;

@Mixin(ServerWorld.class)
public class WorldLoading {

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;syncChunkWrites()Z"), method = "<init>")
    public void getFolder(MinecraftServer server, Executor workerExecutor, LevelStorage.Session session, ServerWorldProperties properties, RegistryKey worldKey, DimensionOptions dimensionOptions, boolean debugWorld, long seed, List spawners, boolean shouldTickTime, RandomSequencesState randomSequenceState, CallbackInfo ci) {
        ChunkGenerator chunkGenerator = dimensionOptions.chunkGenerator();
        if (chunkGenerator instanceof WRGChunkGenerator chunk) {
            WRGVanilla.LOGGER.info("World name: " + session.getWorldDirectory(worldKey).getFileName().toString());
            if (server.isDedicated()) {
                WRGVanilla.LOGGER.info("Server path: " + server.getPath("world"));
                WRGVanilla.LOGGER.info("Session path: " + session.getWorldDirectory(worldKey));
                chunk.getWorld().load(server.getPath("world"));
            } else {
                chunk.getWorld().load(session.getWorldDirectory(worldKey));
            }
            if (chunk.getBiomeSource() instanceof WRGBiomeProvider provider){
                provider.setWorld(chunk.getWorld());
            }
        }

    }
}
