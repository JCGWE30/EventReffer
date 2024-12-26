package org.lepigslayer.eventReffer.InventorySystem.Slots;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.lepigslayer.eventReffer.InventorySystem.SimpleItem;
import org.lepigslayer.eventReffer.InventorySystem.Slot;

import java.util.function.Function;

public class DynamicSlot extends Slot {
    private Function<Player,SimpleItem> playerModifier;

    public DynamicSlot(Function<Player, SimpleItem> playerModifier) {
        this.playerModifier = playerModifier;
    }

    @Override
    public ItemStack get(Player p) {
        return playerModifier.apply(p).assemble();
    }
}
