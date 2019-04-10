package pl.kodicrew.developers.fight.configuration.impl;

import org.bukkit.configuration.file.YamlConfiguration;
import pl.kodicrew.developers.fight.configuration.managers.Configuration;

import java.io.File;

public class ConfigurationImpl implements Configuration {

    private final File file;
    private final Class<?> clazz;

    public ConfigurationImpl(File file, Class<?> clazz) {
        this.clazz = clazz;
        this.file = file;
        this.reload();
    }

    @Override
    public void reload() {
        File config = check(this.file);
        try {
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(config);
            parse(this.clazz, configuration);
            configuration.save(config);
        }catch (Exception ex) {}
    }

    @Override
    public void save() {
        File config = check(this.file);
        try {
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(config);
            parseSave(this.clazz, configuration);
            configuration.save(config);
        }catch (Exception ex) {}
    }
}
