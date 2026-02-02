package vanilla.wildsregrown.api;

import com.sipke.api.features.flora.Flora;
import net.minecraft.util.Identifier;

public class VanillaFlora extends Flora implements IdentifiableRegistery {

    public VanillaFlora(String name, int key, int placement) {
        super(name, key, placement);
    }

    @Override
    public Identifier getIdentifier() {
        return Identifier.ofVanilla(getName());
    }

}
