package vanilla.wildsregrown.api.chunk;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ReadableContainer;

public interface SetableSection {

    void wrg_vanilla$set(ReadableContainer<RegistryEntry<Biome>> biomeContainer);
    ReadableContainer<RegistryEntry<Biome>> wrg_vanilla$get();

}
