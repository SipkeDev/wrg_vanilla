package vanilla.wildsregrown.mixin;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Structure.class)
public class StructureMixin {

    @Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/world/gen/structure/Structure;isBiomeValid(Lnet/minecraft/world/gen/structure/Structure$StructurePosition;Lnet/minecraft/world/gen/structure/Structure$Context;)Z", cancellable = true)
    private static void isBiomeValid(Structure.StructurePosition result, Structure.Context context, CallbackInfoReturnable<Boolean> cir) {
        BlockPos blockPos = result.position();
        cir.setReturnValue(context.biomePredicate().test(context.chunkGenerator().getBiomeSource().getBiome(blockPos.getX(), blockPos.getY(), blockPos.getZ(), null)));
    }

}
