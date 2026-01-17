package vanilla.wildsregrown.world.biomes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sipke.World;
import com.sipke.api.heightmap.HeightMapPos;
import com.sipke.math.MathUtil;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.biomes.meadows.BirchMeadow;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.*;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import vanilla.wildsregrown.WRGVanilla;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class WRGBiomeProvider extends BiomeSource {

    public static final MapCodec<WRGBiomeProvider> CODEC = RecordCodecBuilder.mapCodec(
            (instance) -> instance.group(
                    Biome.REGISTRY_CODEC.fieldOf("biome").forGetter((biomeSource) -> biomeSource.biomeArray)
            ).apply(instance, WRGBiomeProvider::new));
    private final RegistryEntry<Biome> biomeArray;
    private final List<RegistryEntry<Biome>> biomes;
    private World world;

    public WRGBiomeProvider(RegistryEntry<Biome> biomeArray) {
        this.biomeArray = biomeArray;
        this.biomes = new ArrayList<>();
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    protected MapCodec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    protected Stream<RegistryEntry<Biome>> biomeStream() {
        return biomes.stream();
    }

    @Override
    public RegistryEntry<Biome> getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        //HeightMapPos pos = world.generator.getHeightMapPos(x, z);
        return biomes.get((int)MathUtil.mudolo((1f/32)*MathUtil.abs(x), biomes.size()-1));
    }

    @Override
    public void addDebugInfo(List<String> info, BlockPos pos, MultiNoiseUtil.MultiNoiseSampler noiseSampler) {
        info.add("WRG Biome builder");
    }

    public void addBiomes(ImmutableList<RegistryEntry<Biome>> build) {
        for (RegistryEntry<Biome> entry : build){
            this.biomes.add(entry);
            WRGVanilla.LOGGER.info(entry.getIdAsString());
        }
        WRGVanilla.LOGGER.info("Added Biomes to source");
    }
}
