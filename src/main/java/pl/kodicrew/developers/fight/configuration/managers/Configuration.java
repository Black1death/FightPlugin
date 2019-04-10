package pl.kodicrew.developers.fight.configuration.managers;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface Configuration {

    default void parseSave(Class<?> clazz, YamlConfiguration config) {
        try {
            for (Field f : clazz.getFields()) {
                if (Modifier.isStatic(f.getModifiers()) && Modifier.isPublic(f.getModifiers())) {
                    String path = f.getName().toLowerCase();
                    path = StringUtils.replace(path, "$", ".");
                    path = StringUtils.replace(path, "_", "-");

                    Object value = f.get(null);
                    config.set(path, value);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    default void parse(Class<?> clazz, YamlConfiguration config) {
        try {
            for (Field f : clazz.getFields()) {
                if (Modifier.isStatic(f.getModifiers()) && Modifier.isPublic(f.getModifiers())) {
                    String path = f.getName().toLowerCase();
                    path = StringUtils.replace(path, "$", ".");
                    path = StringUtils.replace(path, "_", "-");

                    Object def = f.get(null);
                    Object value = config.get(path, def);
                    config.set(path, value);
                    f.set(null, value);
                }

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    default File check(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return file;
    }

    void reload();

    void save();
}
