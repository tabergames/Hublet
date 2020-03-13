package taber.core.TaberPortalManager.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;



public class ChatHandlers
        implements Listener
{
    @EventHandler
    public void onChatEvent(AsyncPlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("hublet.allow"))
            event.setCancelled(true);
    }
}
