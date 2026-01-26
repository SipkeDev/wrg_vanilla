package vanilla.wildsregrown.gui.menu.builder;

import com.sipke.builder.WorldBuilder;
import com.sipke.math.MathUtil;
import com.sipke.api.grid.WRGConfig;
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
import vanilla.wildsregrown.world.builder.*;

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
                        //new Features(),
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
            int w = 80;
            this.grid.setRowSpacing(8);
            this.grid.setColumnSpacing(5);
            Positioner positioner = this.grid.copyPositioner();

            this.grid.add(new EmptyWidget(width/4,10), 1, 1, positioner);
            this.grid.add(new EmptyWidget(width/4,10), 1, 2, positioner);

            this.grid.add(CyclingButtonWidget.builder(WorldTypeRenderSelector::getDisplayText, WorldTypeRenderSelector.climate).values(WorldTypeRenderSelector.values()).build(0,0, w, 20, Text.literal("Camera"),
                    (button, value) -> {
                camera.setRender(switch (value){
                    case climate -> CameraRender.climate;
                    case height -> CameraRender.height;
                    case temperature -> CameraRender.temperature;
                    case rainfall -> CameraRender.rainfall;
                });
                camera.takeShot(builder.ctx);
            }), 1,3, positioner);
            this.grid.add(new TextWidget(0, 0, w, 20, Text.literal("Height"), textRenderer), 2,3, positioner);
            this.grid.add(new SliderWidget(0, 0, w, 20, Text.of(String.valueOf(builder.ctx.config.getHeightMod()).substring(0, 3)), builder.ctx.config.getHeightMod()+0.5) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value-0.5)));}
                @Override
                protected void applyValue() {
                    builder.ctx.config.setHeightMod((float)value-0.5f);
                    camera.takeShot(builder.ctx);
                }
            }, 3, 3, positioner);
            this.grid.add(new SliderWidget(0, 0, w, 20, Text.of(shortenSliderValue(builder.ctx.config.getHeightModClamp())), builder.ctx.config.getHeightModClamp()*2.0) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value/2.0)));}
                @Override
                protected void applyValue() {
                    builder.ctx.config.setHeightModClamp((float)(value/2.0));
                    camera.takeShot(builder.ctx);
                }
            }, 4,3, positioner);
            this.grid.add(CyclingButtonWidget.builder(MapSelector::getDisplayText, MapSelector.linear).values(MapSelector.values()).build(0,0, w, 20, Text.literal("Type"),
                    (button, value) -> {builder.ctx.config.setHeightType(value.getType());camera.takeShot(builder.ctx);}
            ), 5,3, positioner);


            this.grid.add(new EmptyWidget(w,10), 1, 4, positioner);
            this.grid.add(new TextWidget(0, 0, w, 20, Text.literal("Temperature"), textRenderer), 2, 4, positioner);
            this.grid.add(new SliderWidget(0, 0, w, 20, Text.of(String.valueOf(builder.ctx.config.getTemperature()).substring(0, 3)), builder.ctx.config.getTemperature()+0.5) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value-0.5)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setTemperature((float)value-0.5f);
                    camera.takeShot(builder.ctx);
                }
            }, 3,4, positioner);
            this.grid.add(new SliderWidget(0, 0, w, 20, Text.of(shortenSliderValue(builder.ctx.config.getTemperatureClamp())), builder.ctx.config.getTemperatureClamp()*2.0) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value/2.0)));}
                @Override
                protected void applyValue() {
                    builder.ctx.config.setTemperatureClamp((float)(value/2.0));
                    camera.takeShot(builder.ctx);
                }
            }, 4,4, positioner);
            this.grid.add(CyclingButtonWidget.builder(MapSelector::getDisplayText, MapSelector.linear).values(MapSelector.values()).build(0,0, w, 20, Text.literal("Type"),
                    (button, value) -> {builder.ctx.config.setTemperatureType(value.getType());camera.takeShot(builder.ctx);}
            ), 5,4, positioner);


            this.grid.add(new EmptyWidget(width/4,10), 1, 5, positioner);
            this.grid.add(new TextWidget(0, 0, w, 20, Text.literal("RainFall"), textRenderer), 2, 5, positioner);
            this.grid.add(new SliderWidget(0, 0, w, 20, Text.of(String.valueOf(builder.ctx.config.getRainfall()).substring(0, 3)), builder.ctx.config.getHeightMod()+0.5) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value-0.5)));}
                @Override
                protected void applyValue() {
                    builder.ctx.config.setRainfall((float)value-0.5f);
                    //camera.setRender(CameraRender.temperature);
                    camera.takeShot(builder.ctx);
                }
            }, 3,5, positioner);
            this.grid.add(new SliderWidget(0, 0, w, 20, Text.of(shortenSliderValue(builder.ctx.config.getRainfallClamp())), builder.ctx.config.getRainfallClamp()*2.0) {
                @Override
                protected void updateMessage() {
                    setMessage(Text.of(shortenSliderValue(value/2.0)));}
                @Override
                protected void applyValue() {
                    builder.ctx.config.setRainfallClamp((float)(value/2.0));
                    camera.takeShot(builder.ctx);
                }
            }, 4,5, positioner);
            this.grid.add(CyclingButtonWidget.builder(MapSelector::getDisplayText, MapSelector.linear).values(MapSelector.values()).build(0,0, w, 20, Text.literal("Type"),
                    (button, value) -> {builder.ctx.config.setRainfallType(value.getType());camera.takeShot(builder.ctx);}
            ), 5,5, positioner);

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
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Landform " + shortenSliderValue(builder.ctx.config.getLandformScale())), builder.ctx.config.getLandformScale()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Landform " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setLandformScale((float)value);
                }
            }, 2,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Ecosystem " + shortenSliderValue(builder.ctx.config.getEcoSystemScale())), builder.ctx.config.getEcoSystemScale()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Ecosystem " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setEcoSystemScale((float)value);
                }
            }, 3,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Biome " + shortenSliderValue(builder.ctx.config.getBiomeScale())), builder.ctx.config.getBiomeScale()) {
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
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Continent " + WRGConfig.calcContinentFactor(builder.ctx.config.getContinentFactor())), builder.ctx.config.getContinentFactor()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Continent " + shortenSliderValue(WRGConfig.calcContinentFactor((float)value)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setContinentFactor((float)value);
                }
            }, 2,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Landform " + WRGConfig.calcLandformFactor(builder.ctx.config.getBiomeFactor())), builder.ctx.config.getLandformFactor()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Landform: " + shortenSliderValue(WRGConfig.calcLandformFactor((float)value)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setLandformFactor((float)value);
                }
            }, 3,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Biome " + WRGConfig.calcBiomeFactor(builder.ctx.config.getBiomeFactor())), builder.ctx.config.getBiomeFactor()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Biome: " + shortenSliderValue(WRGConfig.calcBiomeFactor((float)value)));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setBiomeFactor((float)value);
                }
            }, 4,3, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("WaterLevel " + builder.ctx.config.getWaterLevel()), builder.ctx.config.getWaterLevel()) {
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
                    }), 2, 1, positioner).setTooltip(Tooltip.of(Text.of("Changes the amount of cycles, older means more erosion but slower performance.")));
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Inertia " + shortenSliderValue(builder.ctx.config.getErosionInertia())), builder.ctx.config.getErosionInertia()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Inertia " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionInertia((float)value);
                }
            }, 3,1, positioner).setTooltip(Tooltip.of(Text.of("Changes the tendency to move direction")));
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Friction " + shortenSliderValue(builder.ctx.config.getErosionFriction())), builder.ctx.config.getErosionFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Friction " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionFriction((float)value);
                }
            }, 4,1, positioner).setTooltip(Tooltip.of(Text.of("Changes how much velocity is kept for each step")));
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Capacity " + shortenSliderValue(builder.ctx.config.getErosionCapacity())), builder.ctx.config.getErosionCapacity()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Capacity " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionCapacity((float)value);
                }
            }, 5,1, positioner).setTooltip(Tooltip.of(Text.of("How much sediment the stream carries")));
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Rate " + shortenSliderValue(builder.ctx.config.getErosionRate())), builder.ctx.config.getErosionRate()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Rate " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setErosionRate((float)value);
                }
            }, 6,1, positioner).setTooltip(Tooltip.of(Text.of("Rate of picking up/depositing sediment")));

            this.grid.add(new TextWidget(0, 0, 100, 20, Text.literal("MainRivers"), textRenderer), 1, 2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Inertia " + shortenSliderValue(builder.ctx.config.getMainRiverInertia())), builder.ctx.config.getMainRiverInertia()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Inertia " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setMainRiverInertia((float)value);
                }
            }, 2,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Friction " + shortenSliderValue(builder.ctx.config.getMainRiverFriction())), builder.ctx.config.getMainRiverFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Friction " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setMainRiverFriction((float)value);
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
                    builder.ctx.config.setRiverInertia((float)value);
                }
            }, 5,2, positioner);
            this.grid.add(new SliderWidget(0, 0, 100, 20, Text.of("Friction " + shortenSliderValue(builder.ctx.config.getRiverFriction())), builder.ctx.config.getRiverFriction()) {
                @Override
                protected void updateMessage() {
                    message = Text.of("Friction " + shortenSliderValue(value));
                }
                @Override
                protected void applyValue() {
                    builder.ctx.config.setRiverFriction((float)value);
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
            adder.add(new TextWidget(Text.of("Disclaimer:"), textRenderer), positioner);
            adder.add(new TextWidget(Text.of("Settable values exceed safety bounds."), textRenderer), positioner);
            adder.add(new TextWidget(Text.of("Glitched terrain outside of the default settings are therefore a feature, not a bug."), textRenderer), positioner);
            adder.add(new TextWidget(Text.of("Have fun!"), textRenderer), positioner);
            adder.add(new TextWidget(Text.of("And don't forget to screenshot cool terrain."), textRenderer), positioner);
        }
    }


    private String shortenSliderValue(double value){
        String s = Double.toString(value);
        return s.substring(0, MathUtil.min(value < 0.0 ? 5 : 4, s.length()));
    }

}
