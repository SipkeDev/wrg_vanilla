package vanilla.wildsregrown.gui.menu.camera;

import com.sipke.api.categorization.Climate;
import com.sipke.builder.GridCtx;
import com.sipke.core.Seed;
import com.sipke.math.MathUtil;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.texture.TextureSetup;

import java.awt.*;

public class WorldTypeCamera extends Camera<GridCtx> implements Drawable, IRenderType {

    public WorldTypeCamera(int size){
        super(256, size);
    }

    public void takeShot(GridCtx ctx) {

        Seed seed = new Seed(ctx.seed);

        for (int x = 0; x < res; x++) {
            for (int y = 0; y < res; y++) {

                switch (cameraRender) {
                    case climate -> {
                        setPixel(x, y, Climate.getRegion(
                                MathUtil.float01(ctx.config.getTemperature()+ctx.type.temparature(seed, res).getNoise(x, y)),
                                MathUtil.float01(ctx.config.getRainfall()+ctx.type.rainfall(seed, res).getNoise(x, y)),
                                ctx.type.continent(seed, res).getNoise(x, y)
                        ).getRgb());
                    }
                    case elevation -> {
                        setPixel(x, y, getElevationRGB(ctx.type.continent(seed, res).getNoise(x, y)));
                    }
                    case height -> {
                        setPixel(x, y, Color.HSBtoRGB(0f, 0f, ctx.type.continent(seed, res).getNoise(x, y)));
                    }
                    case moisture -> {
                        setPixel(x, y, Color.HSBtoRGB(0f, 0f,  MathUtil.float01(ctx.config.getRainfall()+ctx.type.rainfall(seed, res).getNoise(x, y))));
                    }
                    case temperature -> {
                        setPixel(x, y, Color.HSBtoRGB(0f, 0f,  MathUtil.float01(ctx.config.getTemperature()+ctx.type.temparature(seed, res).getNoise(x, y))));
                    }
                }

            }
        }

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        //int size = MathUtil.min(parent.width, parent.height);
        context.state.addSimpleElement(new RenderWorldMap(RenderPipelines.GUI, TextureSetup.empty(), context.getMatrices(), this.getImage(), size, res, this.getX(), this.getY(), null));
    }

}