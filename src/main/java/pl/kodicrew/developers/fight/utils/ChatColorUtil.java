package pl.kodicrew.developers.fight.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ChatColorUtil {

    public static String colored(String message){
        return ChatColor.translateAlternateColorCodes('&', message.replace(">>", "»").replace("<<", "«"));
    }

    public static boolean sendMessage(Player player, String message){
        player.sendMessage(colored(message));
        return true;
    }
}
