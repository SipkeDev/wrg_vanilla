package wildsregrown.vanilla.registry.structures;

import com.sipke.api.features.structures.Structure;
import com.sipke.features.structures.Palisade;
import com.sipke.features.structures.SurfaceLitter;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class WalledOutpost extends Structure {

    public WalledOutpost() {
        super(vanillaId, "pillager_outpost", "", -22,0,-22, 22,32,22, 24, 128, 24);
        register(new Palisade("oak_log", 0, 4));
        register(new SurfaceLitter(0.985f, 8, "torch", "campfire"));
        register(new SurfaceLitter(0.998f, -12, "tnt"));
    }

}
