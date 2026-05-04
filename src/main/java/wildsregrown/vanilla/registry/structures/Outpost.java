package wildsregrown.vanilla.registry.structures;

import com.sipke.api.features.structures.Structure;
import com.sipke.features.structures.SurfaceLitter;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class Outpost extends Structure {

    public Outpost() {
        super(vanillaId,"pillager_outpost", "", -24,0,-24, 48,32,48, 24, 128, 24);
        register(new SurfaceLitter(0.999f, -12, "tnt"));
        register(new SurfaceLitter(0.998f, -6, "campfire", "torch"));
    }

}
