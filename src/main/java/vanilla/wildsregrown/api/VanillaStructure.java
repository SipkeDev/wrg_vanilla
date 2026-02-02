package vanilla.wildsregrown.api;

import com.sipke.api.features.structures.Structure;
import net.minecraft.util.Identifier;

public class VanillaStructure extends Structure implements IdentifiableRegistery {

    public VanillaStructure(String identifier, int x0, int y0, int z0, int x1, int y1, int z1, float spawnRadius, int terrainRadius, int terrainOffset) {
        super("minecraft", identifier, x0, y0, z0, x1, y1, z1, spawnRadius, terrainRadius, terrainOffset);
    }

    @Override
    public Identifier getIdentifier(){
        return Identifier.ofVanilla(this.getName());
    }

}
