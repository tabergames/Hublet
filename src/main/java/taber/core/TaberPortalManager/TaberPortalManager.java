package taber.core.TaberPortalManager;

import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import taber.core.TaberPortalManager.handlers.*;


public class TaberPortalManager
        extends JavaPlugin
        implements PluginMessageListener, Listener
{
    public static String dashline = "━━━━";
    public static int online;
    PlayerMoveHandler pm = new PlayerMoveHandler(this);
    int factions;
    int kitpvp;
    int oppvp;
    int infected;
    int skyblock;
    int skywars;
    int hub;
    int creative;
    int survival;
    int prison;
    int hungergames;
    List<Player> playeys = new ArrayList();

    PermissionManager pex = null;


    public static WorldGuardPlugin getWorldGuard(TaberPortalManager plugin) {
        Plugin wg = plugin.getServer().getPluginManager().getPlugin("WorldGuard");
        if (wg == null || !(wg instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin)wg;
    }
    public static WorldEditPlugin getWorldEdit(TaberPortalManager plugin) {
        Plugin wg = plugin.getServer().getPluginManager().getPlugin("WorldEdit");
        if (wg == null || !(wg instanceof WorldEditPlugin)) {
            return null;
        }
        return (WorldEditPlugin)wg;
    }


    public void onEnable() {
        this.factions = 0;
        this.pex = PermissionsEx.getPermissionManager();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerMoveHandler(this), this);
        getServer().getPluginManager().registerEvents(new RightClickHandler(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinHandler(), this);
        getServer().getPluginManager().registerEvents(new ChatHandlers(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
    }



    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
            String subchannel = in.readUTF();

            if (subchannel.equals("PlayerCount")) {
                String server = in.readUTF();
                int playerCount = in.readInt();
                if (server.equals("factions")) {
                    this.factions = playerCount;
                }
                if (server.equals("kitpvp")) {
                    this.kitpvp = playerCount;
                }
                if (server.equals("infected")) {
                    this.infected = playerCount;
                }
                if (server.equals("oppvp")) {
                    this.oppvp = playerCount;
                }
                if (server.equals("skywars")) {
                    this.skywars = playerCount;
                }
                if (server.equals("skyblock")) {
                    this.skyblock = playerCount;
                }
                if (server.equals("creative")) {
                    this.creative = playerCount;
                }
                if (server.equals("survival")) {
                    this.survival = playerCount;
                    System.out.println("Good");
                }
                if (server.equals("prison")) {
                    this.prison = playerCount;
                }
                if (server.equals("hungergames")) {
                    this.hungergames = playerCount;
                }
            }
        } catch (IOException e) {

            getLogger().severe("Error during reception of plugin message! Cause: IOException\nPlease report this stacktrace :");
            e.printStackTrace();
        }
    }

    public int getOnline() { return online; }


    public void setOnline(int online) { online = online; }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        String loginLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLUE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline;
        Player player = event.getPlayer();
        PermissionUser user = PermissionsEx.getUser(player);
        player.sendMessage(loginLine);
        player.sendMessage(ChatColor.GREEN + "           Welcome " + ChatColor.translateAlternateColorCodes('&', user.getName()) + ChatColor.GREEN + " to" + ChatColor.YELLOW + " CraftCadia!");
        player.sendMessage(ChatColor.GREEN + "        Check out our Site! " + ChatColor.YELLOW + ChatColor.ITALIC + "CadiaHQ.com");
        player.sendMessage(ChatColor.LIGHT_PURPLE + "     Donate:" + ChatColor.AQUA + " /donate" + ChatColor.LIGHT_PURPLE + " Vote: " + ChatColor.AQUA + "/vote" + ChatColor.LIGHT_PURPLE + " Rules: " + ChatColor.AQUA + "/rules");
        player.sendMessage(ChatColor.YELLOW + "              Enjoy Your Stay!");

        player.sendMessage(loginLine);
    }



    public int getFactions() { return this.factions; }


    public void setFactions(int factions) { this.factions = factions; }


    public int getKitpvp() { return this.kitpvp; }


    public void setKitpvp(int kitpvp) { this.kitpvp = kitpvp; }


    public int getOppvp() { return this.oppvp; }


    public void setOppvp(int oppvp) { this.oppvp = oppvp; }


    public int getInfected() { return this.infected; }


    public void setInfected(int infected) { this.infected = infected; }


    public int getSkyblock() { return this.skyblock; }


    public void setSkyblock(int skyblock) { this.skyblock = skyblock; }


    public int getSkywars() { return this.skywars; }


    public void setSkywars(int skywars) { this.skywars = skywars; }


    public int getHub() { return this.hub; }


    public void setHub(int hub) { this.hub = hub; }


    public int getCreative() { return this.creative; }


    public void setCreative(int creative) { this.creative = creative; }


    public int getSurvival() { return this.survival; }


    public void setSurvival(int survival) { this.survival = survival; }


    public int getPrison() { return this.prison; }


    public void setPrison(int prison) { this.prison = prison; }


    public int getHungergames() { return this.hungergames; }


    public void setHungergames(int hungergames) { this.hungergames = hungergames; }
}