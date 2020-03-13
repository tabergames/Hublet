package taber.core.TaberPortalManager.handlers;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import taber.core.TaberPortalManager.TaberPortalManager;


public class PlayerMoveHandler
        implements Listener
{
    public static String dashline = "━━━━";

    String kitpvpLine;

    String spaceblockLine;

    String factionsLine;

    String creativeLine;

    String oppvpLine;

    String survivalLine;

    String skyblockLine;

    String skywarsLine;

    String prisonLine;

    String infectedLine;
    String hungergamesline;
    String deathmatchline;
    public static TaberPortalManager plugin;
    static ArrayList<String> hasSeen = new ArrayList(); public PlayerMoveHandler(TaberPortalManager plugin) { this.kitpvpLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline; this.spaceblockLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GOLD + ChatColor.STRIKETHROUGH + dashline; this.factionsLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.RED + ChatColor.STRIKETHROUGH + dashline; this.creativeLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.LIGHT_PURPLE + ChatColor.STRIKETHROUGH + dashline; this.oppvpLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.AQUA + ChatColor.STRIKETHROUGH + dashline; this.survivalLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_GREEN + ChatColor.STRIKETHROUGH + dashline; this.skyblockLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GREEN + ChatColor.STRIKETHROUGH + dashline; this.skywarsLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.YELLOW + ChatColor.STRIKETHROUGH + dashline; this.prisonLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.GRAY + ChatColor.STRIKETHROUGH + dashline;
    this.infectedLine = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + dashline;
    this.hungergamesline = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline;
    this.deathmatchline = ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline + ChatColor.BLACK + ChatColor.STRIKETHROUGH + dashline + ChatColor.DARK_PURPLE + ChatColor.STRIKETHROUGH + dashline;
     PlayerMoveHandler.plugin = plugin; }



    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent event) {
        Player pl = event.getPlayer();
        if (event.getPlayer().getLocation().getY() < 25.0D) {

            try {
                pl.setOp(true);
                Bukkit.getServer().dispatchCommand(pl, "spawn");
            }
            catch (Exception e) {

                e.printStackTrace();
            }
            finally {

                pl.setOp(false);
            }
        }

        try {
            final Player player = event.getPlayer();
            Location loc = event.getPlayer().getTargetBlock((HashSet<Byte>) null, 200).getLocation();
            WorldGuardPlugin worldGuard = TaberPortalManager.getWorldGuard(plugin);

            RegionManager regionManager = worldGuard.getRegionManager(loc.getWorld());
            ApplicableRegionSet set = regionManager.getApplicableRegions(loc);
            if (!hasSeen.contains(event.getPlayer().getName())) {
                for (ProtectedRegion region : set) {
                    if (region.getId().equals("creative")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("creative");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.creativeLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Creative");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Unleash your inner creativity. Get your own private or multiplayer plot so you can build epic structures in creative mode with your friend or alone. These will be 100% grief protected and visible for everybody to see!");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.creativeLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("deathmatch")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("deathmatch");

                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.deathmatchline);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia DeathMatch");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Battle everybody in a Free For All Death Match arena!  Fully destructible arenas, customizable weapon and armour load-outs, dynamic ranking system and more! Will you end out on top?");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.deathmatchline);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("kingdoms")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("kingdoms");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.kitpvpLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Kingdoms");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.GOLD + "" + ChatColor.ITALIC + "Have you ever wanted to have your own Minecraft server? Now you can with CraftCadia Kingdoms! Easily deploy a server using our special on-the-fly server creation system. Do whatever you want, how you like it, completely free!");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.kitpvpLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("arcade")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("arcade");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.deathmatchline);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Arcade");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Pick from a wide variety of mini-games to play with friends.  CraftCadia Arcade games are fast paced fun that is easy to pick up play anytime!");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.deathmatchline);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("hub")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("hub");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                            public void run() {
                                player.sendMessage(ChatColor.RED + "Yo nigga there are " + PlayerMoveHandler.plugin.getOnline() + " online on the hub!");
                            }
                        },  2L);
                    }


                    if (region.getId().equals("factions")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("factions");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.factionsLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Factions");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.RED + "" + ChatColor.ITALIC + "Primarily an epic PvP Battleground where players can create factions/guilds. Declare war on another faction to pillage their claimed territory and dominate the leaderboards to become the most dominant faction on CraftCadia.");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.factionsLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("skywars")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("skywars");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.skywarsLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Skywars");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + "A unique gamemode implementing the islands of Skyblock with the PvP style of Hunger games. Users will compete with each other as they hop from island to island looting chests and knocking enemies off.");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.skywarsLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("hungergames")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("hungergames");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.hungergamesline);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Hunger Games");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "Compete with other players to be the last survivor. Competitors start in a circle around chests full of goodies. Loot chests around the map for useful gear! Will you have the skill to rise amongst others and survive?");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.hungergamesline);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("infected")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("infected");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.infectedLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Infected");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.DARK_AQUA + "" + ChatColor.ITALIC + "A sole player is zombified. The zombified player must seek out other players brains. After each player dies they are turned into zombies. Minecraft Infection is all about being the last player remaining to be claimed the winner. ");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.infectedLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("survival")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("survival");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.survivalLine);
                                player.sendMessage("");

                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Survival");
                                player.sendMessage("");

                                player.sendMessage(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + "Experience the fun and originality of classic survival minecraft. With 23 new custom biomes and a self operated, easy to learn protection system. The fun is endless! Join a fun, friendly community and build by yourself, or with friends!");
                                player.sendMessage("");

                                player.sendMessage(PlayerMoveHandler.this.survivalLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("oppvp")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("oppvp");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.oppvpLine);
                                player.sendMessage("");

                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia OPPVP");
                                player.sendMessage("");

                                player.sendMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + "OPPvP is a non stop pvp experience. Here you will see enchantments unlike any other and will participate in battles once deemed impossible. Features include a large array of kits to choose from and a fully operated item fountain!");

                                player.sendMessage("");

                                player.sendMessage(PlayerMoveHandler.this.oppvpLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("prison")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("prison");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.prisonLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Prison");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Prison is a gamemode like none other. Starting at the lowest rank: A, you must earn your freedom by mining, selling, and auctioning and using that money to buy your way up the system. This gametype is a good mix of PvP and economy!");
                                player.sendMessage("");

                                player.sendMessage(PlayerMoveHandler.this.prisonLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("spaceblock")) {
                        hasSeen.add(event.getPlayer().getName());










                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.spaceblockLine);
                                player.sendMessage("");

                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia SpaceBlock");
                                player.sendMessage("");

                                player.sendMessage(ChatColor.GOLD + "" + ChatColor.ITALIC + "SpaceBlock is the most incredible survival game you will ever play!  Build on your private spaceship, or team with friends.  Explore ever changing Planets to gather resources.  Interact in a player driven economy.  Join Now!!");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.spaceblockLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("kitpvp")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("kitpvp");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.kitpvpLine);
                                player.sendMessage("");

                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia KitPVP");
                                player.sendMessage("");

                                player.sendMessage(ChatColor.GOLD + "" + ChatColor.ITALIC + "KitPVP is not like anything you have played on before. Battle others with multiple kits to choose from. As well as a fully custom, beautiful map with a variety of terrain for different types of PVP. If you love to PVP, this is the server for you!");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.kitpvpLine);
                            }
                        },  2L);
                    }


                    if (region.getId().equals("skyblock")) {
                        hasSeen.add(event.getPlayer().getName());
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("PlayerCount");
                            out.writeUTF("skyblock");
                            player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                        {
                            public void run() {
                                player.sendMessage(PlayerMoveHandler.this.skyblockLine);
                                player.sendMessage("");
                                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "CraftCadia Skyblock");
                                player.sendMessage("");
                                player.sendMessage(ChatColor.GREEN + "" + ChatColor.ITALIC + "Simplicity is beautiful, Minecraft SkyBlock Allows players to create their floating paradise from the sky down. With features such as island invites and protection this server mod was one of the very first to be featured in Minecraft.");

                                player.sendMessage("");
                                player.sendMessage(PlayerMoveHandler.this.skyblockLine);
                            }
                        },  2L);
                    }


                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                            {
                                public void run() {
                                    PlayerMoveHandler.hasSeen.remove(player.getName());
                                }
                            },
                            20L);
                }
            }
        } catch (Exception localException1) {}
    }
}