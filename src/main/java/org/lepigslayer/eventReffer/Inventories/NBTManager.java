package org.lepigslayer.eventReffer.Inventories;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.lepigslayer.eventReffer.InventorySystem.*;
import org.lepigslayer.eventReffer.InventorySystem.Slots.DynamicSlot;
import org.lepigslayer.eventReffer.InventorySystem.Slots.ItemSlot;

public class NBTManager extends CustomInventory {
    private static final SimpleItem NO_SAVES = new SimpleItem("§cNo Saved NBTs",1,Material.BEDROCK);

    private static final InventoryTemplate MAIN_TEMPLATE = new InventoryBuilder()
            .setTitle("NBT Manager")
            .setRows(3)
            .setBackgroundMode(BackgroundMode.GRAY_PANES)
            .setSlots()
            .setSlot(10,new DynamicSlot(NBTManager::saveChecker))
            .setSlot(16,new ItemSlot("§6Create new NBT Object", Material.GOLD_BLOCK,1))
            .build();

    private static final InventoryTemplate NEW_NBT = new InventoryBuilder()
            .setTitle("Create new NBT Object")
            .setRows(3)
            .setBackgroundMode(BackgroundMode.GRAY_PANES)
            .setSlots()
            .setSlot(10,new ItemSlot("§eItem",Material.STICK,1))
            .setSlot(12,new ItemSlot("§eBlock",Material.COBBLESTONE,1))
            .setSlot(14,new ItemSlot("§eEntity",Material.ARMOR_STAND,1))
            .setSlot(16,new ItemSlot("§eTrade",Material.EMERALD,1))
            .build();
    private boolean hasSaves = false;

    public NBTManager(Player player) {
        super(MAIN_TEMPLATE, player);

        if(hasSaves) bindAction(10,this::loadNbts);

        bindAction(16,this::createNewNbt);
    }

    private NBTManager(InventoryTemplate t,Player player){
        super(t,player);
    }

    private NBTManager getFromState(int state){
        switch(state){
            case 0: //Create new NBT
                NBTManager nbtManager = new NBTManager(NEW_NBT,player);
                nbtManager.bindAction(10,this::makeNewNbt);
                nbtManager.bindAction(12,this::makeNewNbt);
                nbtManager.bindAction(14,this::makeNewNbt);
                nbtManager.bindAction(16,this::makeNewNbt);
                return nbtManager;
            case 1: //Load Saved NBT
                break;
        }
        throw new UnsupportedOperationException();
    }

    public static SimpleItem saveChecker(Player p){
        return NO_SAVES;
    }

    private void loadNbts(Slot s){

    }

    private void createNewNbt(Slot s){
        getFromState(0).open();
    }

    private void makeNewNbt(Slot s){
        switch (s.getLocation()){
            case 0: //Item
                player.sendMessage("Making");
                new NBTItemFactory(player).open();
                return;
            case 1: //Block
                break;
            case 2: //Entity
                break;
            case 3: //Trade
                break;
        }
    }
}
