package com.amalitech.upskilling.week_two.lab_one.creational.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManagerSingleton {
    Properties properties;

    private ConfigurationManagerSingleton() {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/java/com/amalitech/upskilling/week_two/lab_one/creational/singleton/resources/logger_configurations.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConfigurationManagerSingleton load() {
        return new ConfigurationManagerSingleton();
    }

    public Config getProperties() {
        // Get the values from the properties
        return new Config(
                properties.getProperty("log.level"),
                properties.getProperty("color.debug"),
                properties.getProperty("color.info"),
                properties.getProperty("color.warning"),
                properties.getProperty("color.error"),
                properties.getProperty("color.trace"),
                properties.getProperty("color.default")
        );
    }
}
