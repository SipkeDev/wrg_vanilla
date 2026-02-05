package vanilla.wildsregrown.registries.structures;

import com.sipke.features.structures.Palisade;
import com.sipke.features.structures.SurfaceLitter;
import vanilla.wildsregrown.api.VanillaStructure;

public class WalledOutpost extends VanillaStructure {

    public WalledOutpost() {
        super("pillager_outpost", -22,0,-22, 22,32,22, 24, 128, 24);
        register(new Palisade("oak_log", 0, 4));
        register(new SurfaceLitter(0.985f, 8, "torch", "campfire"));
        register(new SurfaceLitter(0.998f, -12, "tnt"));
    }

}
