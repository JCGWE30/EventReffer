package org.lepigslayer.eventReffer;

import org.bukkit.plugin.java.JavaPlugin;
import org.lepigslayer.eventReffer.InventorySystem.InventoryEvents;

public final class EventReffer extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TestEvents(),this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
