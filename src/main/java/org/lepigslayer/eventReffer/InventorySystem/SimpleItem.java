package org.lepigslayer.eventReffer.InventorySystem;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SimpleItem {
    public String name;
    public int amount;
    public Material type;
    public boolean enchanted;

    public SimpleItem(String name, int amount, Material type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }

    public ItemStack assemble(){
        ItemStack i = new ItemStack(type, amount);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName("§f"+name);
        if(enchanted)
            meta.addEnchant(Enchantment.MENDING,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(meta);
        return i;
    }
}
