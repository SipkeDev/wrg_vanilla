package vanilla.wildsregrown.api.biome;

import net.minecraft.util.Identifier;
import vanilla.wildsregrown.api.IdentifiableRegistery;

public class VanillaBiome extends IdentifierBiome implements IdentifiableRegistery {

    public VanillaBiome(String name) {
        super("minecraft", name);
    }

    @Override
    public Identifier getIdentifier(){
        return Identifier.ofVanilla(getName());
    }

    @Override
    public String toString(){
        return getName();
    }

}
