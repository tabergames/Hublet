package taber.core.TaberPortalManager.handlers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import taber.core.TaberPortalManager.TaberPortalManager;


public class JoinEvent
        implements Listener
{
    public static TaberPortalManager plugin;

    public JoinEvent(TaberPortalManager plugin) {
        JoinEvent.plugin = plugin; }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("PlayerCount");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Player player = event.getPlayer();
        player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
        Player me = event.getPlayer();
    }
}
