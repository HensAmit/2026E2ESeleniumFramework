package com.framework.config;

import com.framework.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final ThreadLocal<Properties> properties = new ThreadLocal<>();

    private ConfigManager() {}

    public static void init(String env) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                    FrameworkConstants.CONFIG_PATH + env + ".properties");
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
