package vanilla.wildsregrown.api.materials;

import com.sipke.api.geology.GeoMaterial;
import net.minecraft.util.Identifier;
import vanilla.wildsregrown.api.IdentifiableRegistery;

public class VanillaMaterial extends GeoMaterial implements IdentifiableRegistery {

    public VanillaMaterial(String name, float density, float friction, float thalusAngle, int weathers, int collapses, int transports) {
        super(name.replace("block.minecraft.", ""), 0, density, friction, thalusAngle, weathers, collapses, transports);
    }

    @Override
    public Identifier getIdentifier(){
        return Identifier.ofVanilla(name);
    }

}
