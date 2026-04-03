package com.framework.config;

import com.framework.constants.FrameworkConstants;
import com.framework.utils.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final ThreadLocal<Properties> properties = new ThreadLocal<>();

    private ConfigManager() {}

    public static void init(String env) {
        Properties prop = new Properties();
        try {
            InputStream fis = ResourceLoader.getResourceAsStream(FrameworkConstants.CONFIG_PATH + env + ".properties");
            prop.load(fis);
            properties.set(prop);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String get(String key) {
        return properties.get().getProperty(key);
    }

    public static void unload() {
        properties.remove();
    }
}
