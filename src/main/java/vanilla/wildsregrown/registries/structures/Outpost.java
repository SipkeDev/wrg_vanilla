package vanilla.wildsregrown.registries.structures;

import com.sipke.features.structures.SurfaceLitter;
import vanilla.wildsregrown.api.VanillaStructure;

public class Outpost extends VanillaStructure {

    public Outpost() {
        super("pillager_outpost", -24,0,-24, 48,32,48, 24, 128, 24);
        register(new SurfaceLitter(0.999f, -12, "tnt"));
        register(new SurfaceLitter(0.998f, -6, "campfire", "torch"));
    }

}
