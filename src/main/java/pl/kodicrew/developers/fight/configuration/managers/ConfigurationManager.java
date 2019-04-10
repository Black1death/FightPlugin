package pl.kodicrew.developers.fight.configuration.managers;

import pl.kodicrew.developers.fight.configuration.impl.ConfigurationImpl;

import java.io.File;

public class ConfigurationManager {

    public static ConfigurationImpl create(File file, Class clazz) {
        return new ConfigurationImpl(file, clazz);
    }
}
