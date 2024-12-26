package org.lepigslayer.eventReffer.Inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.lepigslayer.eventReffer.InventorySystem.*;
import org.lepigslayer.eventReffer.InventorySystem.Slots.ItemSlot;

public class MainInventory extends CustomInventory {
    private static final InventoryTemplate TEMPLATE = new InventoryBuilder()
            .setTitle("Choose your action")
            .setRows(3)
            .setBackgroundMode(BackgroundMode.GRAY_PANES)
            .setSlots()
            .setSlot(10, new ItemSlot("Block Manager", Material.GOLD_BLOCK, 1))
            .setSlot(13, new ItemSlot("NBT Manager", Material.NAME_TAG, 1))
            .setSlot(16, new ItemSlot("Value Manager", Material.COMMAND_BLOCK, 1))
            .build();

    public MainInventory(Player p){
        super(TEMPLATE,p);
        bindAction(10,this::clickBlockManager);
        bindAction(13,this::clickNbtManager);
        bindAction(16,this::clickValueManager);
    }

    private void clickBlockManager(Slot s){
        player.sendMessage("Clicked Block Manager");
    }

    private void clickNbtManager(Slot s){
        new NBTManager(player).open();
    }

    private void clickValueManager(Slot s){
        player.sendMessage("Clicked Value Manager");
    }
}
