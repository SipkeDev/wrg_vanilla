package vanilla.wildsregrown.mixin;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSupplier;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.PalettedContainer;
import net.minecraft.world.chunk.ReadableContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChunkSection.class)
public class PopulateBiomes {

	@Shadow
	private ReadableContainer<RegistryEntry<Biome>> biomeContainer;

	@Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/world/chunk/ChunkSection;populateBiomes(Lnet/minecraft/world/biome/source/BiomeSupplier;Lnet/minecraft/world/biome/source/util/MultiNoiseUtil$MultiNoiseSampler;III)V", cancellable = true)
	public void populateBiomes(BiomeSupplier biomeSupplier, MultiNoiseUtil.MultiNoiseSampler sampler, int x, int y, int z, CallbackInfo ci) {
		if (sampler == null){
			//populate(biomeSupplier, x, y, z);
			ci.cancel();
		}
	}

	@Unique
	public void populate(BiomeSupplier biomeSupplier, int x, int y, int z) {
		PalettedContainer<RegistryEntry<Biome>> palettedContainer = this.biomeContainer.slice();
		int i = 4;
		for(int j = 0; j < i; ++j) {
			for (int l = 0; l < i; ++l) {
				RegistryEntry<Biome> entry = biomeSupplier.getBiome(x+j, y, z+l, null);
				for (int k = 0; k < i; k++) {
					palettedContainer.swapUnsafe(j, k, l, entry);
				}
			}
		}
		this.biomeContainer = palettedContainer;
	}

}