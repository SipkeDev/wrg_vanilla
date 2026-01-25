package vanilla.wildsregrown.mixin;

import net.minecraft.SharedConstants;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import net.minecraft.world.gen.feature.util.PlacedFeatureIndexer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vanilla.wildsregrown.WRGVanilla;

import java.util.List;
import java.util.function.Supplier;

@Mixin(ChunkGenerator.class)
public class MixinChunkGenerator {

    @Final
    @Shadow
    private Supplier<List<PlacedFeatureIndexer.IndexedFeatures>> indexedFeaturesListSupplier;

    @Inject(method = "initializeIndexedFeaturesList", at = @At("HEAD"), cancellable = true)
    public void initializeIndexedFeaturesList(CallbackInfo ci) {
        //for (PlacedFeatureIndexer.IndexedFeatures indexedFeatures : indexedFeaturesListSupplier.get()){
        //    WRGVanilla.LOGGER.info("Hello : "+ indexedFeatures.features());
        //}
        //ci.cancel();
    }

}