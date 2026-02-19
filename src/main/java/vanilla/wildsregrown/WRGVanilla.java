package vanilla.wildsregrown;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vanilla.wildsregrown.commands.Locate;
import vanilla.wildsregrown.network.Networking;
import vanilla.wildsregrown.registries.*;
import vanilla.wildsregrown.world.WRGChunkGenerator;
import vanilla.wildsregrown.world.biomes.WRGBiomeProvider;

public class WRGVanilla implements ModInitializer {

	public static final String modid = "wrg_vanilla";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(modid);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		/// Networking
		Networking.init();
		/// Spawnables
		Materials.init();
		Structures.init();
		Floras.init();
		/// Spawns
		Landforms.init();
		Ecosystems.init();
		Biomes.init();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			Locate.register(dispatcher);
		});

		//Register custom world classes
		Registry.register(Registries.BIOME_SOURCE, Identifier.of(modid, "wrg_biome"), WRGBiomeProvider.CODEC);
		Registry.register(Registries.CHUNK_GENERATOR, Identifier.of(modid, "wrg_chunk"), WRGChunkGenerator.CODEC);

		if (PreWRGVanilla.frame != null) {
			PreWRGVanilla.frame.setVisible(false);
			PreWRGVanilla.frame.dispose();
			PreWRGVanilla.frame = null;
		}

	}

}