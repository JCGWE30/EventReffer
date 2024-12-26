package org.lepigslayer.eventReffer.InventorySystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.lepigslayer.eventReffer.InventorySystem.Slots.ItemSlot;

import java.util.HashMap;
import java.util.function.Consumer;

public class CustomInventory implements InventoryHolder {
    private final Inventory inventory;
    private final Slot[] slots;
    private HashMap<Integer, Consumer<Slot>> bindedActions = new HashMap<>();
    private Runnable closeAction;

    protected Player player;

    public CustomInventory(InventoryTemplate template, Player player) {
        this.player = player;
        slots = template.slots;
        inventory = Bukkit.createInventory(this, template.rows * 9, template.name);
        for (int i = 0; i < slots.length; i++) {
            Slot slot = slots[i];
            slot.setSlot(i);
            inventory.setItem(i, slots[i].get(player));
        }
    }

    public void open() {
        player.openInventory(inventory);
    }

    protected void bindAction(int slot, Consumer<Slot> runnable) {
        bindedActions.put(slot, runnable);
    }

    protected void bindClose(Runnable runnable) {
        if (closeAction != null)
            closeAction = runnable;
    }

    protected void updateSlot(int location, Slot slot){
        inventory.setItem(location,slot.get(player));
    }

    public void runAction(int slot) {
        if (!bindedActions.containsKey(slot)) return;
        bindedActions.get(slot).accept(slots[slot]);
    }

    public void runClose() {
        if (closeAction != null)
            closeAction.run();
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
