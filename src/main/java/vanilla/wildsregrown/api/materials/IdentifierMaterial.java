package vanilla.wildsregrown.api.materials;

import net.minecraft.util.Identifier;
import vanilla.wildsregrown.api.IdentifiableRegistery;

public class IdentifierMaterial extends VanillaMaterial implements IdentifiableRegistery {

    private final String modid;

    public IdentifierMaterial(String modid, String name, float density, float friction, float thalusAngle, int weathers, int collapses, int transports) {
        super(name, density, friction, thalusAngle, weathers, collapses, transports);
        this.modid = modid;
    }

    public String getModid() {
        return modid;
    }

    @Override
    public Identifier getIdentifier(){
        return Identifier.of(modid, name);
    }
}
