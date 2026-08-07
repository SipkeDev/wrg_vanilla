package wildsregrown.vanilla;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import wildsregrown.vanilla.data.VanillaBlockStateProvider;
import wildsregrown.vanilla.data.tags.VanillaBiomeTagGenerator;
import wildsregrown.vanilla.data.tags.VanillaBlockTagGenerator;
import wildsregrown.vanilla.data.tags.VanillaItemTagGenerator;

public class WRGVanillaDataGenerator implements DataGeneratorEntrypoint {

	public WRGVanillaDataGenerator() {}

	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(VanillaBlockStateProvider::new);
		pack.addProvider(VanillaBiomeTagGenerator::new);
		pack.addProvider(VanillaBlockTagGenerator::new);
		pack.addProvider(VanillaItemTagGenerator::new);
	}

}
