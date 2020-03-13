package taber.core.TaberPortalManager.handlers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;




public class PlayerJoinHandler
        implements Listener
{
    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) { event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 0)); }
}
