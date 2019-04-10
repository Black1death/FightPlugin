package pl.kodicrew.developers.fight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.fight.FightPlugin;
import pl.kodicrew.developers.fight.configuration.Settings;
import pl.kodicrew.developers.fight.utils.ChatColorUtil;

public class FightAdminCommand implements CommandExecutor {

    private final FightPlugin plugin;

    public FightAdminCommand(FightPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("gafight").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;

        if (!player.hasPermission(Settings.CONFIGURATION$FIGHT_PERMISSIONS)) return ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$FIGHT_PERMISSIONS_MESSAGE);

        if (args.length == 0) return ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$FIGHT_USAGE);

        if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("wlacz")){

            this.plugin.setSystem(true);
            final String message = String.join("\n", Settings.CONFIGURATION$FIGHT_ENABLE);
            Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendMessage(players, message));
            return true;
        }

        if (args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("wylacz")){

            this.plugin.setSystem(false);
            final String message = String.join("\n", Settings.CONFIGURATION$FIGHT_DISABLE);
            Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendMessage(players, message));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("przeladuj")){
            this.plugin.saveConfiguration();
            this.plugin.reloadConfig();
            return ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$FIGHT_RELOAD);
        }
        return true;
    }

}
