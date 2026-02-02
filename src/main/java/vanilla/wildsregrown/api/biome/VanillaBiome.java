package vanilla.wildsregrown.api.biome;

import com.sipke.api.features.structures.Structure;
import net.minecraft.util.Identifier;
import vanilla.wildsregrown.api.IdentifiableRegistery;
import vanilla.wildsregrown.registries.Structures;

public class VanillaBiome extends IdentifierBiome implements IdentifiableRegistery {

    public VanillaBiome(String name) {
        super("minecraft", name);
        if (name.contains("snow") || name.contains("ice")){
            register(Structures.igloo);
            register(Structures.stronghold);
        }
        if (name.contains("jungle")){
            register(Structures.jungle_temple);
            register(Structures.mansion);
        }
        if (name.contains("ocean")){
            register(Structures.shipwreck);
            register(Structures.ocean_ruin);
            register(Structures.monument);
        }
        if (name.contains("pale_garden")){
            register(Structures.mansion);
        }
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
        return getName() + this.getClass().getSimpleName();
    }

}
