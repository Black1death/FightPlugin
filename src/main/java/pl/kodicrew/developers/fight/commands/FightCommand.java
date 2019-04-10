package pl.kodicrew.developers.fight.commands;

import net.dzikoysk.funnyguilds.basic.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.kodicrew.developers.fight.FightPlugin;
import pl.kodicrew.developers.fight.configuration.Settings;
import pl.kodicrew.developers.fight.utils.ChatColorUtil;
import java.util.stream.Collectors;

import static pl.kodicrew.developers.fight.configuration.Settings.CONFIGURATION$FIGHT_MESSAGE_BROADCAST;

public class FightCommand implements CommandExecutor {

    private final FightPlugin plugin;

    public FightCommand(FightPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("fight").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("ONLY PLAYER");
            return true;
        }
        final Player player = (Player) sender;
        final User user = User.get(player.getName());

        if (user.hasGuild()) {

            ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$FIGHT_SENT_AFIGHT);
            final String message = CONFIGURATION$FIGHT_MESSAGE_BROADCAST.stream()
                    .map(s -> s.replace("{TAG}", user.getGuild().getTag()).replace("{POSITION}", user.getGuild().getRank().getPosition() + "").replace("{G-NAME}", user.getGuild().getName()).replace("{LEADER}", user.getGuild().getOwner() + "").replace("{X}", user.getGuild().getHome().getBlockX() + "").replace("{Y}", user.getGuild().getHome().getBlockY() + "").replace("{Z}", user.getGuild().getHome().getBlockZ() + ""))
                    .collect(Collectors.joining("\n"));

            Bukkit.getOnlinePlayers().forEach(players -> ChatColorUtil.sendMessage(players, message));
        } else {
            return ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$FIGHT_NOT_GUILD);
        }
        return true;
    }
}

//                    .replace("{TAG}", user.getGuild().getTag()).replace("{POSITION}", user.getGuild().getRank().getPosition() + "").replace("{G-NAME}", user.getGuild().getName()).replace("{LEADER}", user.getGuild().getOwner() + "").replace("{X}", user.getGuild().getHome().getBlockX() + "").replace("{Y}", user.getGuild().getHome().getBlockY() + "").replace("{Z}", user.getGuild().getHome().getBlockZ() + "")));

