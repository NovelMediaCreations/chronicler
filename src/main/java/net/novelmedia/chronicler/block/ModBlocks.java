package net.novelmedia.chronicler.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.novelmedia.chronicler.Chronicler;

public class ModBlocks {
    public static final Block PALE_SAND = registerBlock("pale_sand",
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.SAND)
            );
    public static final Block PALE_SANDSTONE = registerBlock("pale_sandstone",
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.STONE)
    );
    public static final Block PALE_DIRT = registerBlock("pale_dirt",
            AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.GRASS)
    );

    private static Block registerBlock(String name, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(Chronicler.MOD_ID, name);

        settings.registryKey(RegistryKey.of(Registries.BLOCK.getKey(), id));
        Block block = new Block(settings);

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Chronicler.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Chronicler.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Chronicler.MOD_ID, name)))
                ));
    }

    public static void registerBlocks() {
        Chronicler.LOGGER.info("Registering Blocks for " + Chronicler.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(PALE_SAND);
            entries.add(PALE_SANDSTONE);
            entries.add(PALE_DIRT);
        });
    }
}
