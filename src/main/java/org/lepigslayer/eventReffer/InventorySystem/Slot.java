package org.lepigslayer.eventReffer.InventorySystem;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Slot {
    private int slot;

    public int getLocation(){
        return slot;
    }

    void setSlot(int slot){
        this.slot = slot;
    }

    public abstract ItemStack get(Player p);
}
