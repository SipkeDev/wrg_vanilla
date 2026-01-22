package vanilla.wildsregrown.world.biomes;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.MapCodec;
import com.sipke.World;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.*;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import vanilla.wildsregrown.WRGVanilla;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class WRGBiomeProvider extends BiomeSource {

    public static final MapCodec<RegistryEntry<Biome>> BIOME_CODEC;
    public static final MapCodec<MultiNoiseUtil.Entries<RegistryEntry<Biome>>> CUSTOM_CODEC;
    public static final MapCodec<RegistryEntry<MultiNoiseBiomeSourceParameterList>> PRESET_CODEC;
    public static final MapCodec<WRGBiomeProvider> CODEC;
    private final Either<MultiNoiseUtil.Entries<RegistryEntry<Biome>>, RegistryEntry<MultiNoiseBiomeSourceParameterList>> biomeEntries;

    private final RegistryEntry<Biome> defaultBiome;
    private final HashMap<Identifier, RegistryEntry<Biome>> biomes;
    private World world;

    private WRGBiomeProvider(Either<MultiNoiseUtil.Entries<RegistryEntry<Biome>>, RegistryEntry<MultiNoiseBiomeSourceParameterList>> biomeEntries) {
        this.biomeEntries = biomeEntries;
        this.biomes = new HashMap<>();
        this.defaultBiome = getBiomeEntries().getEntries().get(5).getSecond();
        WRGVanilla.LOGGER.info("big marker: " + defaultBiome.getIdAsString());
    }

    public HashMap<Identifier, RegistryEntry<Biome>> getMap() {
        return biomes;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    private MultiNoiseUtil.Entries<RegistryEntry<Biome>> getBiomeEntries() {
        return this.biomeEntries.map((entries) -> entries, (parameterListEntry) -> (parameterListEntry.value()).getEntries());
    }

    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return this.getBiomeEntries().getEntries().stream().map(Pair::getSecond);
    }

    @Override
    public RegistryEntry<Biome> getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        /*
        if (world.generator.getBiome(x, z) instanceof IdentifierBiome identifierBiome) {
                RegistryEntry<Biome> entry =  biomes.get(identifierBiome.getIdentifier());
                if (entry!=null){
                    return entry;
                }
        }

         */
        return defaultBiome;
    }

    @Override
    public void addDebugInfo(List<String> info, BlockPos pos, MultiNoiseUtil.MultiNoiseSampler noiseSampler) {
        info.add("WRG Biome builder");
    }

    public void addBiomes(ImmutableList<RegistryEntry<Biome>> build) {
        for (RegistryEntry<Biome> entry : build) {
            Optional<RegistryKey<Biome>> key = entry.getKey();
            if (key.isPresent()) {
                this.biomes.put(key.get().getValue(), entry);
                WRGVanilla.LOGGER.info("value :" + key.get().getValue());
            }
        }
    }

    static {
        BIOME_CODEC = Biome.REGISTRY_CODEC.fieldOf("biome");
        CUSTOM_CODEC = MultiNoiseUtil.Entries.createCodec(BIOME_CODEC).fieldOf("biomes");
        PRESET_CODEC = MultiNoiseBiomeSourceParameterList.REGISTRY_CODEC.fieldOf("preset").withLifecycle(Lifecycle.stable());
        CODEC = Codec.mapEither(CUSTOM_CODEC, PRESET_CODEC).xmap(WRGBiomeProvider::new, (source) -> source.biomeEntries);
    }
}
