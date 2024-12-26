package org.lepigslayer.eventReffer.InventorySystem;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryTemplate {
    final Slot[] slots;
    final int rows;
    final String name;

    public InventoryTemplate(Slot[] items, String name, int rows) {
        this.slots = items;
        this.name = name;
        this.rows = rows;
    }
}
