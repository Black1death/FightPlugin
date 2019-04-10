package pl.kodicrew.developers.fight;

import org.bukkit.plugin.java.JavaPlugin;
import pl.kodicrew.developers.fight.commands.FightAdminCommand;
import pl.kodicrew.developers.fight.commands.FightCommand;
import pl.kodicrew.developers.fight.configuration.Settings;
import pl.kodicrew.developers.fight.configuration.managers.Configuration;
import pl.kodicrew.developers.fight.configuration.managers.ConfigurationManager;
import pl.kodicrew.developers.fight.events.PlayerCommandPreprocessListener;
import java.io.File;
import java.util.Objects;

public class FightPlugin extends JavaPlugin {

    private Configuration settings = ConfigurationManager.create(new File(this.getDataFolder(), "config.yml"), Settings.class);
    private boolean system = true;

    @Override
    public void onLoad() {
        this.getLogger().info(Settings.CONFIGURATION$PLUGIN_LOAD);
    }

    @Override
    public void onEnable() {
        this.onLoad();
        this.registerCommands();
        this.registerEvents();
        this.registerCheckFunnyGuildsPlugin();
        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();
        this.getLogger().info(Settings.CONFIGURATION$PLUGIN_ENABLE);
    }

    private void registerCommands(){
        new FightCommand(this);
        new FightAdminCommand(this);

    }

    private void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessListener(this), this);
    }

    private void registerCheckFunnyGuildsPlugin(){
        if (this.getServer().getPluginManager().getPlugin(Settings.CONFIGURATION$PLUGIN_CHECK_NAME) != null){
            this.getLogger().info(Settings.CONFIGURATION$PLUGIN_CHECK_FUNNYGUILDS_CONNECT);
        }else if (this.getServer().getPluginManager().getPlugin(Settings.CONFIGURATION$PLUGIN_CHECK_NAME) == null){
            this.getLogger().info(Settings.CONFIGURATION$PLUGIN_CHECK_FUNNYGUILDS_DISABLE);
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    public void saveConfiguration(){
        if (Objects.nonNull(settings)) settings.save();
    }

    public Configuration getSettings() {
        return settings;
    }

    public void setSystem(boolean system){
        this.system = system;
    }

    public boolean isSystem() {
        return system;
    }

    @Override
    public void onDisable() {
        this.getLogger().info(Settings.CONFIGURATION$PLUGIN_DISABLE);
    }

}
