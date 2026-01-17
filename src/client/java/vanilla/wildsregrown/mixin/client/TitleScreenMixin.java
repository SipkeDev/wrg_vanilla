package vanilla.wildsregrown.mixin.client;

import com.sipke.builder.WorldBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vanilla.wildsregrown.gui.menu.builder.WorldTypeScreen;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

	protected TitleScreenMixin() {
		super(Text.of("Mixin"));
	}

	@Inject(at = @At("TAIL"), method = "Lnet/minecraft/client/gui/screen/TitleScreen;init()V")
	public void init(CallbackInfo info) {
		this.addDrawableChild(ButtonWidget.builder(Text.literal("World Painter"), (button) -> this.client.setScreen(new WorldTypeScreen(new WorldBuilder(),this))).dimensions(0, 0, 200, 20).build());
	}

}