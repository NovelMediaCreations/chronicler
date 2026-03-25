package net.novelmedia.chronicler.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.novelmedia.chronicler.Chronicler;

public class ModItems {
//    public static final Item TEST = registerItem("test", new Item.Settings());

    private static Item registerItem(String name, Item.Settings settings) {
        Item item = new Item(settings.registryKey(RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Chronicler.MOD_ID, name))));
        return Registry.register(Registries.ITEM, Identifier.of(Chronicler.MOD_ID, name), item);
    }
    public static void registerItems() {
        Chronicler.LOGGER.info("Registering Items for " + Chronicler.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.add(TEST);
        });
    }
}
