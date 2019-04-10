package pl.kodicrew.developers.fight.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.kodicrew.developers.fight.FightPlugin;
import pl.kodicrew.developers.fight.configuration.Settings;
import pl.kodicrew.developers.fight.utils.ChatColorUtil;

public class PlayerCommandPreprocessListener implements Listener {

    private final FightPlugin plugin;

    public PlayerCommandPreprocessListener(FightPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        if (!this.plugin.isSystem() && (event.getMessage().startsWith("/walka"))) {
            ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$FIGHT_ISCOMMANDDISABLE);
            event.setCancelled(true);
        }
    }
}
