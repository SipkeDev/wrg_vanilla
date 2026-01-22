package vanilla.wildsregrown;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import vanilla.wildsregrown.gui.menu.world.SelectWorld;

public class WRGVanillaClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
			if (screen instanceof TitleScreen titleScreen) {}
			if (screen instanceof SelectWorldScreen selectWorldScreen){
				client.setScreen(new SelectWorld(new TitleScreen()));
			}
		});
	}
}