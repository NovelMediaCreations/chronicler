package net.novelmedia.chronicler.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.novelmedia.chronicler.block.ModBlocks;
import net.novelmedia.chronicler.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> SMELTABLES = List.of(ModBlocks.PALE_SAND);
                offerSmelting(SMELTABLES, RecipeCategory.DECORATIONS, Items.WHITE_STAINED_GLASS, 0.15f, 200, "stained_glass");

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_SANDSTONE, 4)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModBlocks.PALE_SAND)
                        .criterion(hasItem(ModBlocks.PALE_SAND), conditionsFromItem(ModBlocks.PALE_SAND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_SAND, 2)
                        .pattern("WS")
                        .pattern("SW")
                        .input('S', Items.SAND)
                        .input('W', Items.WHITE_DYE)
                        .criterion(hasItem(ModBlocks.PALE_SAND), conditionsFromItem(ModBlocks.PALE_SAND))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Chronicler Recipes";
    }
}
