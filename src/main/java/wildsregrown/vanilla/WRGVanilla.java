package wildsregrown.vanilla;

import com.sipke.api.geology.GeoMaterial;
import com.sipke.api.terrain.Ecosystem;
import com.sipke.registeries.WorldRegistries;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wildsregrown.vanilla.registry.*;

public class WRGVanilla implements ModInitializer, DedicatedServerModInitializer {

	public static final String modid = "wrg_vanilla";
	public static final String vanillaId = "minecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resocurces) may still be uninitialized.
		// Proceed with mild caution.

		VanillaBlocks.init();

		/// Spawnables
		VanillaMaterials.init();
		VanillaStructures.init();
		VanillaFloras.init();
		VanillaTrees.init();
		VanillaBushes.init();
		/// Spawns
		VanillaLandforms.init();
		VanillaBiomes.init();
		VanillaEcosystems.init();

		for (Ecosystem ecosystem : WorldRegistries.ECOSYSTEMS.getEntries().values()){
			LOGGER.info("Registry: " + ecosystem.getKey());
		}
		for (GeoMaterial material : WorldRegistries.MATERIALS.getEntries().values()){
			if (!GeoMaterial.validate(material)){
				throw new Error("Material registry invalidated!!!");
			}
		}

	}

	@Override
	public void onInitializeServer() {
		LOGGER.info("INIT SERVER");
	}

}