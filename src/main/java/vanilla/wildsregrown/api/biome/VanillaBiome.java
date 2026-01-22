package vanilla.wildsregrown.api.biome;

import net.minecraft.util.Identifier;
import vanilla.wildsregrown.api.IdentifiableRegistery;

public class VanillaBiome extends IdentifierBiome implements IdentifiableRegistery {

    public VanillaBiome(String name) {
        super("minecraft", name);
    }

    public VanillaBiome(String name, boolean overgrown) {
        super("minecraft", name);
        setOvergrown(overgrown);
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
