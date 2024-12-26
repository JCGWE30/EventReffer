package org.lepigslayer.eventReffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.lepigslayer.eventReffer.Inventories.MainInventory;

public class TestEvents implements Listener {

    @EventHandler
    public void chat(PlayerChatEvent event) {
        new MainInventory(event.getPlayer()).open();
    }
}
