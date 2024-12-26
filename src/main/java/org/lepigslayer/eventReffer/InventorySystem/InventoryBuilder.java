package org.lepigslayer.eventReffer.InventorySystem;

import org.lepigslayer.eventReffer.InventorySystem.Slots.ItemSlot;

import java.util.HashMap;

public class InventoryBuilder {
    public class InventorySlots{
        private InventoryBuilder builder;
        private HashMap<Integer,Slot> slotMap = new HashMap<>();

        InventorySlots(InventoryBuilder builder){
            this.builder = builder;
        }

        public InventorySlots setSlot(int location,Slot slot){
            slotMap.put(location,slot);
            return this;
        }

        public InventoryTemplate build(){
            int cellCount = builder.rows*9;
            Slot[] slots = new Slot[cellCount];
            for(int i = 0;i<cellCount;i++){
                slots[i] = slotMap.getOrDefault(i,builder.backgroundMode.fetch(rows,i));
            }
            return builder.build(slots);
        }
    }
    private String title;
    private int rows;
    private BackgroundMode backgroundMode;

    private InventorySlots slots;

    public InventoryBuilder() {
        slots = new InventorySlots(this);
    }

    public InventoryBuilder setTitle(String title){
        this.title = title;
        return this;
    }

    public InventoryBuilder setRows(int amount){
        this.rows = amount;
        return this;
    }

    public InventoryBuilder setBackgroundMode(BackgroundMode mode){
        this.backgroundMode = mode;
        return this;
    }

    public InventorySlots setSlots(){
        return slots;
    }

    private InventoryTemplate build(Slot[] slots){
        return new InventoryTemplate(slots,title,rows);
    }
}
