package org.lepigslayer.eventReffer.InventorySystem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryEvents implements Listener {

    @EventHandler
    private void clickInventory(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) return;
        if(e.getInventory()!=e.getClickedInventory()) return;
        if(e.getInventory().getHolder() instanceof CustomInventory){
            CustomInventory inv = ((CustomInventory) e.getInventory().getHolder());
            inv.runAction(e.getSlot());
            e.setCancelled(true);
        }
    }

    @EventHandler
    private void closeInventory(InventoryCloseEvent e) {
        if(e.getInventory().getHolder() instanceof CustomInventory){
            CustomInventory inv = ((CustomInventory) e.getInventory().getHolder());
            inv.runClose();
        }
    }
}
