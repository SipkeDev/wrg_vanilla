package wildsregrown.vanilla.registry.structures;

import com.sipke.api.features.structures.Structure;
import com.sipke.features.structures.Palisade;
import com.sipke.features.structures.SurfaceLitter;

import static wildsregrown.vanilla.WRGVanilla.vanillaId;

public class WalledVillage extends Structure {

    public WalledVillage() {
        super(vanillaId,"village", "", -68,0,-68, 68,32,68, 32, 224, 12);
        register(new Palisade("oak_log", 0, 5));
        register(new SurfaceLitter(0.98f, -4,"potted_oxeye_daisy", "potted_azure_bluet", "potted_blue_orchid"));
        register(new SurfaceLitter(0.99785f, -8,"campfire"));
    }

}
