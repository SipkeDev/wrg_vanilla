package vanilla.wildsregrown.gui.menu.builder;

import com.sipke.builder.WorldBuilder;
import com.sipke.math.MathUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tab.GridScreenTab;
import net.minecraft.client.gui.tab.Tab;
import net.minecraft.client.gui.tab.TabManager;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.*;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jspecify.annotations.Nullable;
import vanilla.wildsregrown.gui.menu.camera.CameraRender;
import vanilla.wildsregrown.gui.menu.camera.WorldTypeCamera;
import vanilla.wildsregrown.world.builder.WorldAge;
import vanilla.wildsregrown.world.builder.WorldMultiplier;
import vanilla.wildsregrown.world.builder.WorldSize;

import static com.sipke.WorldConstants.chunkSize;

public class ConfigScreen extends Screen {

    private WorldTypeCamera camera;
    private final WorldBuilder builder;
    private final Screen parent;

    public static final Identifier TAB_HEADER_BACKGROUND_TEXTURE = Identifier.ofVanilla("textures/gui/tab_header_background.png");

    private final ThreePartsLayoutWidget layout = new ThreePartsLayoutWidget(this);
    private @Nullable TabNavigationWidget tabNavigation;
    private final TabManager tabManager = new TabManager((clickableWidget) -> {
        ClickableWidget var10000 = this.addDrawableChild(clickableWidget);
    }, (child) -> this.remove(child));

    public ConfigScreen(WorldBuilder builder, Screen parent){
        super(Text.literal("config"));
        this.builder = builder;
        this.parent = parent;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        context.drawTexture(RenderPipelines.GUI_TEXTURED, Screen.FOOTER_SEPARATOR_TEXTURE, 0, this.height - this.layout.getFooterHeight() - 2, 0.0F, 0.0F, this.width, 2, 32, 2);
        if (camera != null){
            if (tabManager.getCurrentTab() == tabNavigation.getTabs().getFirst()) {
                camera.render(context, mouseX, mouseY, deltaTicks);
            }
        }
    }

    @Override
    protected void renderDarkening(DrawContext context) {
        context.drawTexture(RenderPipelines.GUI_TEXTURED, TAB_HEADER_BACKGROUND_TEXTURE, 0, 0, 0.0F, 0.0F, this.width, this.layout.getHeaderHeight(), 16, 16);
        this.renderDarkening(context, 0, this.layout.getHeaderHeight(), this.width, this.height);
    }

    protected void init() {
        //Camera
        camera = new WorldTypeCamera(layout.getContentHeight()-10);
        camera.setRender(CameraRender.climate);
        camera.takeShot(builder.ctx);
        camera.setPosition(0, layout.getHeaderHeight());

        this.tabNavigation = TabNavigationWidget.builder(this.tabManager, this.width).tabs(
                new Tab[]{
                        new Climate(),
                        new WorldTab(),
                        new Filters(),
                        new Features(),
                        new Disclaimer()
                }).build();
        this.addDrawableChild(this.tabNavigation);
        DirectionalLayoutWidget directionalLayoutWidget = this.layout.addFooter(DirectionalLayoutWidget.horizontal().spacing(8));
        directionalLayoutWidget.add(ButtonWidget.builder(Text.of("Accept"), (button) -> {
            if (parent instanceof WorldTypeScreen screen){
                screen.getCamera().takeShot(builder.ctx);
            }
            this.client.setScreen(parent);
        }).build());
        this.layout.forEachChild((child) -> {
            child.setNavigationOrder(1);
            this.addDrawableChild(child);
        });
        this.tabNavigation.selectTab(0, false);
        this.refreshWidgetPositions();

    }

    protected void setInitialFocus() {}

    public void refreshWidgetPositions() {
        if (this.tabNavigation != null) {
            this.tabNavigation.setWidth(this.width);
            this.tabNavigation.init();
            int i = this.tabNavigation.getNavigationFocus().getBottom();
            ScreenRect screenRect = new ScreenRect(0, i, this.width, this.height - this.layout.getFooterHeight() - i);
            this.tabManager.setTabArea(screenRect);
            this.layout.setHeaderHeight(i);
            this.layout.refreshPositions();
        }
    }

    @Environment(EnvType.CLIENT)
    class Climate extends GridScreenTab {

        Climate() {
            super(Text.of("Climate"));
            GridWidget.Adder adder = this.grid.setSpacing(5).createAdder(2);
            Positioner positioner = adder.copyPositioner().alignRight();

            adder.add(new EmptyWidget(width/2, 10), 1);

            adder.add(new TextWidget(0, 0, 100, 20, Text.literal("Temperature"), textRenderer), 2, positioner);
            adder.add(new SliderWidget(0, 0, 100, 20, Text.of(String.valueOf(builder.ctx.config.getTemperature()).substring(0, 3)), 0.5f) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value-0.5)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setTemperature((float)value-0.5f);
                    camera.takeShot(builder.ctx);
                }
            }, 2, positioner);

            adder.add(new TextWidget(0, 0, 100, 20, Text.literal("RainFall"), textRenderer), 2, positioner);
            adder.add(new SliderWidget(0, 0, 100, 20, Text.of(String.valueOf(builder.ctx.config.getRainfall()).substring(0, 3)), 0.5f) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value-0.5)));}
                @Override
                protected void applyValue() {
                    builder.ctx.config.setRainfall((float)value-0.5f);
                    //camera.setRender(CameraRender.temperature);
                    camera.takeShot(builder.ctx);
                }
            }, 2, positioner);

        }

    }

    @Environment(EnvType.CLIENT)
    class WorldTab extends GridScreenTab {

        WorldTab() {
            super(Text.of("World"));
            this.grid.setSpacing(8);
            Positioner positioner = this.grid.copyPositioner();

            TextWidget totalSize = new TextWidget(0, 0, 100, 20, Text.literal("Total size: " + builder.ctx.config.getScaleMultiplier()*(builder.ctx.size*chunkSize)), textRenderer);
            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("World Scale"), textRenderer), 1, 1);
            this.grid.add(CyclingButtonWidget.builder(WorldSize::getDisplayText, WorldSize.medium).values(WorldSize.values()).build(0,0, 100, 20, Text.literal("World Size"),
                    (button, size) -> {
                builder.ctx.setSize(size.getSize());
                totalSize.setMessage(Text.literal("Total size: " + builder.ctx.config.getScaleMultiplier()*(builder.ctx.size*chunkSize)));
            }), 2, 1, positioner);
            this.grid.add(CyclingButtonWidget.builder(WorldMultiplier::getDisplayText, WorldMultiplier.Normal).values(WorldMultiplier.values()).build(0,0, 100, 20, Text.literal("Scale multiplier"),
                    (button, v) -> {
                            builder.ctx.config.setScaleMultiplier(v.getValue());
                            totalSize.setMessage(Text.literal("Total size: " + builder.ctx.config.getScaleMultiplier()*(builder.ctx.size*chunkSize)));
            }), 3, 1, positioner);
            this.grid.add(totalSize, 4,1, positioner);

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Cell scale"), textRenderer), 1, 2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Landform " + 0.5), 0.5f) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Landform " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setLandformScale((float)value);
                }
            }, 2,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Ecosystem " + 0.5), 0.5f) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Ecosystem " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 3,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Biome " + 0.5), 0.5f) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Biome " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setBiomeScale((float)value);
                }
            }, 4,2, positioner);

            //Height/factor
            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Height Factors"), textRenderer), 1, 3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Continent " + MathUtil.range(builder.ctx.config.getContinentFactor(), 0, 1, 128, 384)), builder.ctx.config.getContinentFactor()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Continent " + shortenSliderValue(MathUtil.range((float)value, 0, 1, 128, 384)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setLandformScale((float)value);
                }
            }, 2,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Landform " + MathUtil.range(builder.ctx.config.getLandformFactor(), 0, 1, 128, 512)), builder.ctx.config.getLandformFactor()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Landform: " + shortenSliderValue(MathUtil.range((float)value, 0, 1, 128, 512)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 3,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Biome " + MathUtil.range(builder.ctx.config.getBiomeFactor(), 0, 1, 8, 32)), builder.ctx.config.getBiomeFactor()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Biome: " + shortenSliderValue(MathUtil.range((float)value, 0, 1, 8, 32)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 4,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("WaterLevel " + builder.ctx.config.getWaterlevel()), builder.ctx.config.getWaterlevel()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Waterlevel " + shortenSliderValue(MathUtil.range((float)value, 0, 1, 0, 384)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setWaterLevel((float)value);
                }
            }, 5,3, positioner);

        }
    }

    @Environment(EnvType.CLIENT)
    class Filters extends GridScreenTab {

        Filters() {
            super(Text.of("Filters"));
            this.grid.setSpacing(8);

            Positioner positioner = this.grid.copyPositioner();

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Erosion"), textRenderer), 1, 1, positioner);
            this.grid.add(CyclingButtonWidget.builder(WorldAge::getDisplayText, WorldAge.normal).values(WorldAge.values()).build(0,0, 100, 20, Text.literal("World Age"),
                    (button, v) -> {
                        builder.ctx.config.setWorldAge(v.getId());
                        builder.ctx.age = v.getId();
                    }), 2, 1, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Inertia " + shortenSliderValue(builder.ctx.config.getErosionInertia())), builder.ctx.config.getErosionInertia()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Inertia " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 3,1, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Friction " + shortenSliderValue(builder.ctx.config.getErosionFriction())), builder.ctx.config.getErosionFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Friction " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 4,1, positioner);

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("MainRivers"), textRenderer), 1, 2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Inertia " + shortenSliderValue(builder.ctx.config.getMainRiverInertia())), builder.ctx.config.getMainRiverInertia()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Inertia " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 2,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Friction " + shortenSliderValue(builder.ctx.config.getMainRiverFriction())), builder.ctx.config.getMainRiverFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Friction " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 3,2, positioner);

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Rivers"), textRenderer), 4, 2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Inertia " + shortenSliderValue(builder.ctx.config.getRiverInertia())), builder.ctx.config.getRiverInertia()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Inertia " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 5,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Friction " + shortenSliderValue(builder.ctx.config.getRiverFriction())), builder.ctx.config.getRiverFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Friction " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 6,2, positioner);

        }
            
    }

    @Environment(EnvType.CLIENT)
    class Features extends GridScreenTab {

        Features() {
            super(Text.of("Features"));
            this.grid.setSpacing(8);

            Positioner positioner = this.grid.copyPositioner();

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Caves").setStyle(Style.EMPTY.withBold(true)), textRenderer), 1, 1, positioner);
            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Branchworks"), textRenderer), 2, 1, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Node Distance " + 0.5), 0.5) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Node Distance " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 3,1, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Size " + shortenSliderValue(builder.ctx.config.getErosionFriction())), builder.ctx.config.getErosionFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Size " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 4,1, positioner);

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Elongated"), textRenderer), 5, 1, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Node Distance " + 0.5), 0.5) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Node Distance " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 6,1, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Size " + shortenSliderValue(builder.ctx.config.getErosionFriction())), builder.ctx.config.getErosionFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Size " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 7,1, positioner);

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Facture network"), textRenderer), 1, 3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Node distance " + shortenSliderValue(builder.ctx.config.getMainRiverInertia())), builder.ctx.config.getMainRiverInertia()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Node distance " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 2,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Size " + shortenSliderValue(builder.ctx.config.getMainRiverFriction())), builder.ctx.config.getMainRiverFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Size " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 3,3, positioner);

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Structures").setStyle(Style.EMPTY.withBold(true)), textRenderer), 1, 4, positioner);
            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("Distance? Map structures by type/category?"), textRenderer), 2, 4, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Distance " + 0.5), 0.5) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Distance " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 3,4, positioner);

        }
    }

    @Environment(EnvType.CLIENT)
    class Disclaimer extends GridScreenTab {
        Disclaimer() {
            super(Text.of("Disclaimer"));
            GridWidget.Adder adder = this.grid.setRowSpacing(8).createAdder(1);
            Positioner positioner = adder.copyPositioner();
            adder.add(new TextFieldWidget(textRenderer, width,layout.getContentHeight(),
                    Text.of(
                            "Disclaimer: \n" +
                                    "Settable values exceed safety bounds. \n" +
                                    "Glitched terrain outside of the default settings are therefore a feature, not a bug. \n" +
                                    "Have fun!"
                    )
            ), positioner);
        }
    }


    private String shortenSliderValue(double value){
        String s = Double.toString(value);
        return s.substring(0, MathUtil.min(value < 0.0 ? 5 : 4, s.length()));
    }

}
