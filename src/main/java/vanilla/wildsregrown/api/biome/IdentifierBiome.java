package vanilla.wildsregrown.api.biome;

import com.sipke.api.terrain.Biome;
import net.minecraft.util.Identifier;
import vanilla.wildsregrown.api.IdentifiableRegistery;

public class IdentifierBiome extends Biome implements IdentifiableRegistery {

    private final String modid;
    private final String name;

    public IdentifierBiome(String modid, String name) {
        this.modid = modid;
        this.name = name;
    }

    public String getModid() {
        return modid;
    }

    public String getName() {
        return name;
    }

    @Override
    public Identifier getIdentifier(){
        return Identifier.of(modid, name);
    }

    @Override
    public String toString(){
        return modid + "_" + name;
    }

}
