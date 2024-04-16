package com.amalitech.upskilling.week_two.lab_one.creational.singleton;

import com.amalitech.upskilling.OutPut;

import java.time.LocalDateTime;

// a singleton class for logging messages

public class SingletonLogger {

    private static SingletonLogger instance;
    private final ConfigurationManagerSingleton configurationManagerSingleton;
    private static Config config;

    private SingletonLogger() {
        configurationManagerSingleton = ConfigurationManagerSingleton.load();
    }
    public static synchronized SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
            config = instance.configurationManagerSingleton.getProperties();
        }
        return instance;
    }

    public void log(String message) {
        switch (config.logLevel()) {
            case "DEBUG":
                debug(message);
                break;
            case "INFO":
                info(message);
                break;
            case "WARNING":
                warning(message);
                break;
            case "ERROR":
                error(message);
                break;
            case "TRACE":
                trace(message);
                break;
            default:
                OutPut.printColoredTextBlock(message, getColor(config.colorDefault()));
                break;
        }
    }

    public void error(String message) {
        OutPut.printColoredTextBlock("[ " +LocalDateTime.now() + "] : " + message, getColor(config.colorError()));
    }

    public void info(String message) {
        OutPut.printColoredTextBlock("[ " +LocalDateTime.now() + "] : " + message, getColor(config.colorInfo()));
    }

    public void warning(String message) {
        OutPut.printColoredTextBlock("[ " +LocalDateTime.now() + "] : " + message, getColor(config.colorWarning()));
    }

    public void debug(String message) {
        OutPut.printColoredTextBlock("[ " +LocalDateTime.now() + "] : " + message, getColor(config.colorDebug()));
    }

    public void trace(String message) {
        OutPut.printColoredTextBlock("[ " +LocalDateTime.now() + "] : " + message, getColor(config.colorTrace()));
    }

    private String getColor(String configColor) {
        return switch (configColor) {
            case "BLUE" -> OutPut.Colors.BLUE;
            case "GREEN" -> OutPut.Colors.GREEN;
            case "YELLOW" -> OutPut.Colors.YELLOW;
            case "RED" -> OutPut.Colors.RED;
            case "MAGENTA" -> OutPut.Colors.MAGENTA;
            case "WHITE" -> OutPut.Colors.WHITE;
            default -> OutPut.Colors.CYAN;
        };
    }
}
