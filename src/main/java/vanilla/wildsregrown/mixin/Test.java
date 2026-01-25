package vanilla.wildsregrown.mixin;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructureSet;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.chunk.placement.ConcentricRingsStructurePlacement;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mixin(StructurePlacementCalculator.class)
public class Test {

    @Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/world/gen/chunk/placement/StructurePlacementCalculator;calculateConcentricsRingPlacementPos(Lnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/world/gen/chunk/placement/ConcentricRingsStructurePlacement;)Ljava/util/concurrent/CompletableFuture;", cancellable = true)
    private void calculateConcentricsRingPlacementPos(RegistryEntry<StructureSet> structureSetEntry, ConcentricRingsStructurePlacement placement, CallbackInfoReturnable<CompletableFuture<List<ChunkPos>>> cir) {
        cir.setReturnValue(CompletableFuture.completedFuture(List.of()));
    }

}