package net.novelmedia.chronicler;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.novelmedia.chronicler.datagen.ModBlockTagProvider;
import net.novelmedia.chronicler.datagen.ModItemTagProvider;
import net.novelmedia.chronicler.datagen.ModLootTableProvider;
import net.novelmedia.chronicler.datagen.ModModelProvider;
import net.novelmedia.chronicler.datagen.ModRecipeProvider;

public class ChroniclerDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}