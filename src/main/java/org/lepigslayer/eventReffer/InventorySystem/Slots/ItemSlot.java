package org.lepigslayer.eventReffer.InventorySystem.Slots;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.lepigslayer.eventReffer.InventorySystem.SimpleItem;
import org.lepigslayer.eventReffer.InventorySystem.Slot;

public class ItemSlot extends Slot {
    private SimpleItem item;

    public ItemSlot(String name, Material type, int amount){
        item = new SimpleItem(name,amount,type);
    }

    @Override
    public ItemStack get(Player p) {
        return item.assemble();
    }
}
