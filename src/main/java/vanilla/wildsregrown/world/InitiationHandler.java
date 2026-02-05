package vanilla.wildsregrown.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionOptions;
import vanilla.wildsregrown.WRGVanilla;
import vanilla.wildsregrown.world.biomes.WRGBiomeProvider;

import java.util.Map;

public class InitiationHandler {

    public static void initServer(MinecraftServer server) {
        DynamicRegistryManager.Immutable registryAccess = server.getRegistryManager();
        Registry<DimensionOptions> dim = registryAccess.getOrThrow(RegistryKeys.DIMENSION);
        for (Map.Entry<RegistryKey<DimensionOptions>, DimensionOptions> entry : dim.getEntrySet()) {
            WRGVanilla.LOGGER.info("MARK: " + entry.getKey());
            DimensionOptions dimensionOptions = entry.getValue();
            initBiomes(registryAccess, dimensionOptions, entry.getKey());
        }
    }

    private static void initBiomes(DynamicRegistryManager.Immutable registryAccess, DimensionOptions options, RegistryKey<DimensionOptions> key) {

        if (options.chunkGenerator() instanceof WRGChunkGenerator chunk) {
            ImmutableList.Builder<RegistryEntry<Biome>> builder = ImmutableList.builder();
            Registry<Biome> biomeRegistry = registryAccess.getOrThrow(RegistryKeys.BIOME);
            biomeRegistry.getIndexedEntries().forEach(ctx -> {
                //WRGVanilla.LOGGER.info("Key: " + ctx);
                builder.add(ctx);
            });
            if (chunk.getBiomeSource() instanceof WRGBiomeProvider provider){
                provider.addBiomes(builder.build());
            }
            WRGVanilla.LOGGER.info("Loaded biomes");
        }

    }

}