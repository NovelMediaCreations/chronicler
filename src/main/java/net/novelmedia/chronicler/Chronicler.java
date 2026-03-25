package net.novelmedia.chronicler;

import net.fabricmc.api.ModInitializer;

import net.novelmedia.chronicler.block.ModBlocks;
import net.novelmedia.chronicler.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronicler implements ModInitializer {
	public static final String MOD_ID = "chronicler";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModBlocks.registerBlocks();
	}
}