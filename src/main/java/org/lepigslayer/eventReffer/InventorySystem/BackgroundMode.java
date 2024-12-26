package org.lepigslayer.eventReffer.InventorySystem;

import org.bukkit.Material;
import org.lepigslayer.eventReffer.InventorySystem.Slots.ItemSlot;

import java.util.function.BiFunction;
import java.util.function.Function;

public enum BackgroundMode {
    GRAY_PANES((r,i)-> new ItemSlot(" ", Material.GRAY_STAINED_GLASS_PANE,1)),
    INNER_GRAY_PANES((r,i)->{
        int row = (int)Math.floor(i/9.0);
        int col = i % 9;

        boolean isInner = (row>0&&row<r-1) && (col>0&&col<8);

        return new ItemSlot(" ", isInner ? Material.BLACK_STAINED_GLASS_PANE : Material.GRAY_STAINED_GLASS_PANE,1);
    });

    private final BiFunction<Integer,Integer,Slot> slotFunction;

    BackgroundMode(BiFunction<Integer,Integer,Slot> func) {
        slotFunction = func;
    }

    public Slot fetch(int rows,int location){
        return slotFunction.apply(rows,location);
    }
}
