package vanilla.wildsregrown.api;

import com.sipke.api.categorization.Climate;
import com.sipke.api.terrain.Biome;
import com.sipke.api.terrain.Ecosystem;
import com.sipke.registeries.core.RegistryObject;
import vanilla.wildsregrown.api.biome.IdentifierBiome;

public class SingleBiomeEcosystem extends Ecosystem {

    private final String name;

    public SingleBiomeEcosystem(Climate climate, RegistryObject<Biome> biome) {
        super(climate, biome);
        if (biome.getInstance() instanceof IdentifierBiome identifierBiome){
            this.name = identifierBiome.getName();
        }else {
            this.name = biome.toString();
        }
    }

    @Override
    public String toString(){
        return name;
    }

}
