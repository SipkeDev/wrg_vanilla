package vanilla.wildsregrown.gui.menu.builder;

import com.sipke.api.grid.GridLoader;
import com.sipke.api.grid.WRGConfig;
import com.sipke.builder.WorldBuilder;
import com.sipke.math.MathUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;
import vanilla.wildsregrown.gui.menu.camera.CameraRender;
import vanilla.wildsregrown.gui.menu.camera.WorldTypeCamera;
import vanilla.wildsregrown.gui.menu.widgets.ClimateWidget;
import vanilla.wildsregrown.world.builder.SpawnPicker;
import vanilla.wildsregrown.world.builder.WorldAge;
import vanilla.wildsregrown.world.builder.WorldType;

import java.util.Random;

public class WorldTypeScreen extends Screen {

    private final WorldBuilder builder;
    private final Screen parent;
    private final WorldTypeCamera camera;
    private TextFieldWidget worldName;

    public WorldTypeScreen(WorldBuilder builder, Screen parent){
        super(Text.literal("world_type"));
        this.builder = builder;
        this.parent = parent;
        this.camera = new WorldTypeCamera(MathUtil.min(client.getWindow().getScaledWidth(), client.getWindow().getScaledHeight()));
        this.camera.setRender(CameraRender.climate);
        this.camera.takeShot(builder.ctx);

        this.builder.ctx.config = GridLoader.getConfig("vanilla_plus");
        SystemToast toast = SystemToast.create(client, SystemToast.Type.PERIODIC_NOTIFICATION, Text.of("Loaded config"), Text.of("Vanilla plus"));
        client.getToastManager().add(toast);

    }

    protected void init(){

        this.addDrawable(camera);

        int y = 2, m = 22, dx = -180;
        int w = 160,h = 20;
        this.worldName = new TextFieldWidget(textRenderer, this.width + dx, y+=m, w , h, Text.literal(builder.ctx.name));
        worldName.setText(builder.ctx.name);
        worldName.setTooltip(Tooltip.of(Text.literal("Set world name")));
        worldName.setChangedListener((input)-> this.builder.ctx.name = input);
        this.addDrawableChild(worldName);

        this.addDrawableChild(ButtonWidget.builder(Text.literal(String.valueOf(this.builder.ctx.seed)), (button) -> {
            this.builder.ctx.seed = new Random().nextInt();
            button.setMessage(Text.literal(String.valueOf(this.builder.ctx.seed)));
            this.camera.takeShot(builder.ctx);
        }).tooltip(Tooltip.of(Text.literal("Set world seed"))).dimensions(this.width  + dx, y+=m, w, h).build());

        this.addDrawableChild(CyclingButtonWidget.builder(GameMode::getSimpleTranslatableName, GameMode.CREATIVE).values(GameMode.values()).build(this.width + dx, y+=m, w, h, Text.literal("Gamemode"), (button, type) -> {this.builder.ctx.gamemode = type.getIndex();})).setTooltip(Tooltip.of(Text.literal("Set the gamemode")));
        this.addDrawableChild(ClimateWidget.builder(SpawnPicker::getDisplayText).values(SpawnPicker.values()).initially(SpawnPicker.steppe).build(this.width + dx, y+=m, w, h, Text.literal("Spawn"), (button, type) -> {this.builder.ctx.spawnClimate = type.getClimate();})).setTooltip(Tooltip.of(Text.literal("Set world spawn")));
        this.addDrawableChild(CyclingButtonWidget.builder(WorldType::getDisplayText, WorldType.continent).values(WorldType.values()).build(this.width + dx, y+=m, w, h, Text.literal("World Type"), (button, type) -> {this.builder.ctx.type = type.getType();this.camera.takeShot(this.builder.ctx);})).setTooltip(Tooltip.of(Text.literal("Set world type")));
        this.addDrawableChild(CyclingButtonWidget.builder(WorldAge::getDisplayText, switch (builder.ctx.config.getWorldAge()){
            case 0 -> WorldAge.young;
            case 1 -> WorldAge.normal;
            case 2 -> WorldAge.old;
            case 3 -> WorldAge.ancient;
            case 4 -> WorldAge.max;
            default -> throw new IllegalStateException("Unexpected value: " + builder.ctx.config.getWorldAge());
        }).values(WorldAge.values()).build(this.width + dx, y+=m, w, h, Text.literal("World Age"), (button, type) -> {this.builder.ctx.config.setWorldAge(type.getId());})).setTooltip(Tooltip.of(Text.literal("Set erosion strength")));

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Advanced"), (button) -> this.client.setScreen(new ConfigScreen(builder, this))).dimensions(this.width + dx, y+=m, w , h).tooltip(Tooltip.of(Text.of("Settings"))).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Build"), (button) -> this.client.setScreen(new ConfirmBuildScreen(builder, this))).dimensions(this.width + dx, y+=m, w , h).tooltip(Tooltip.of(Text.of("Build world"))).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Back"), (button) -> this.client.setScreen(parent)).dimensions(this.width + dx, y+=m, w , h).tooltip(Tooltip.of(Text.literal("Main menu"))).build());
    }

    public WorldTypeCamera getCamera() {
        return camera;
    }
}
