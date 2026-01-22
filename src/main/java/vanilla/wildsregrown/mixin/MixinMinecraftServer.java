package vanilla.wildsregrown.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vanilla.wildsregrown.world.InitiationHandler;

@Mixin(value = MinecraftServer.class, priority = 991)
public class MixinMinecraftServer
{
    @Inject(method = "<init>", at = @At("RETURN"), require = 1)
    private void onInit(CallbackInfo ci) {
        InitiationHandler.initServer((MinecraftServer)(Object)this);
    }

}