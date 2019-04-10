package pl.kodicrew.developers.fight.configuration;

import java.util.Arrays;
import java.util.List;

/// CONFIGI UZYTE SA BY REDINGINIER_ //

public class Settings {

    public static String CONFIGURATION$PLUGIN_LOAD = "Ladowanie zasobow...";
    public static String CONFIGURATION$PLUGIN_ENABLE = "Wlaczono plugin poprawnie";
    public static String CONFIGURATION$PLUGIN_DISABLE = "Wylaczono plugin poprawnie";
    public static String CONFIGURATION$PLUGIN_CHECK_NAME = "FunnyGuilds";
    public static String CONFIGURATION$PLUGIN_CHECK_FUNNYGUILDS_CONNECT = "Polaczono z funnyguilds! plugin jest na serwerze";
    public static String CONFIGURATION$PLUGIN_CHECK_FUNNYGUILDS_DISABLE = "Brak polaczenie z funnyguilds plugin zostal wylaczony!";

    public static String CONFIGURATION$FIGHT_PERMISSIONS = "fightplugin.permissions";
    public static String CONFIGURATION$FIGHT_PERMISSIONS_MESSAGE = "&cBlad: Nie posiadasz permisji!";
    public static String CONFIGURATION$FIGHT_USAGE = "&cUzycie: &6/fights <enable/disable>";
    public static List<String> CONFIGURATION$FIGHT_ENABLE = Arrays.asList("&8>> &cWYSYLANIE WOJNY GILDIJNEJ ZOSTALO: &aWLACZONE!", "&8>> &7&oJuz mozesz wysylac wiadomosc twojej gildi na: &cWalke!");
    public static List<String> CONFIGURATION$FIGHT_DISABLE = Arrays.asList("&8>> &cWYSYLANIE WOJNY GILDIJNEJ ZOSTALO: WYLACZONE!", "&8>> &7&oNie mozesz wysylac wojny gildijnej z twoja gildia!");
    public static String CONFIGURATION$FIGHT_ISCOMMANDDISABLE = "&cBlad: Wysylanie walki jest wylaczone!";
    public static String CONFIGURATION$FIGHT_RELOAD = "&aPrzeladowano pomyslnie CONFIG.YML!";

    public static String CONFIGURATION$FIGHT_SENT_AFIGHT = "&aWyslales Informacje twojej gildi na walke!";
    public static List<String> CONFIGURATION$FIGHT_MESSAGE_BROADCAST = Arrays.asList("", "&8>> &7Gildia: &8(&6{TAG}&8) &7wyzywa cie na walke!", "&8>> &7&oChcialbys tam pojsc? i &cSpuscic im lomot?", "&8>> &aUdaj sie na podane kordy na tole informacji o gildi: &6{TAG}", "", "&8>> &7Gildia: &6{G-NAME} &7Tag: &6{TAG}", "&8>> &7Miejsce na Tabulatorze: &6{POSITION}", "&8>> &7Lider gildi: &6{LEADER}", "&8>> &7Kordy: &6X:{X} Y: {Y} Z: {Z}", "", "&cRUSZAJ IM NAJEBAC!", "");
    public static String CONFIGURATION$FIGHT_NOT_GUILD = "&cBlad: Nie posiadasz gildi! zaloz ja komenda /zaloz [TAG], [NAZWA]";

}
