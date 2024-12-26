package org.lepigslayer.eventReffer.Inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.lepigslayer.eventReffer.InventorySystem.BackgroundMode;
import org.lepigslayer.eventReffer.InventorySystem.CustomInventory;
import org.lepigslayer.eventReffer.InventorySystem.InventoryBuilder;
import org.lepigslayer.eventReffer.InventorySystem.InventoryTemplate;
import org.lepigslayer.eventReffer.InventorySystem.Slots.ItemSlot;

public class NBTItemFactory extends CustomInventory {
    private static final int ITEM_LOCATION = 2;
    private static final int AMOUNT_LOCATION = 4;
    private static final int CLEAR_LOCATION = 6;

    private static final InventoryTemplate TEMPLATE = new InventoryBuilder()
            .setTitle("Editing NBT")
            .setRows(6)
            .setBackgroundMode(BackgroundMode.INNER_GRAY_PANES)
            .setSlots()
            .setSlot(ITEM_LOCATION,new ItemSlot("§cNo Item Selected", Material.BEDROCK,1))
            .setSlot(AMOUNT_LOCATION,new ItemSlot("§ex1 Amount",Material.GOLD_BLOCK,1)) // Change to int slot
            .setSlot(CLEAR_LOCATION,new ItemSlot("§cClear all components",Material.REDSTONE_BLOCK,1))
            .build();

    public NBTItemFactory(Player player) {
        super(TEMPLATE, player);
    }
}
