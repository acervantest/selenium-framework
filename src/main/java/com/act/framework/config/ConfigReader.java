package com.act.framework.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader configReader = new ConfigReader();
        configReader.readProperties();
    }

    private void readProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        Settings.logPath = properties.getProperty("LOG_PATH");
        Settings.mainUrl = properties.getProperty("MAIN_URL");
    }
}
