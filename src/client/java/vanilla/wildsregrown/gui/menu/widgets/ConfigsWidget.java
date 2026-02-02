package vanilla.wildsregrown.gui.menu.widgets;

import com.sipke.api.grid.WRGConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.EntryListWidget;

public class ConfigsWidget extends EntryListWidget {


    public ConfigsWidget(MinecraftClient client, int width, int height, int y, int itemHeight) {
        super(client, width, height, y, itemHeight);
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {}

    @Environment(EnvType.CLIENT)
    public static final class ConfigEntry extends ConfigsWidget.Entry{

        @Override
        public void render(DrawContext context, int mouseX, int mouseY, boolean hovered, float deltaTicks) {

        }
    }

}
