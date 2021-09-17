package com.act.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader configReader = new ConfigReader();
        configReader.readProperties();
    }

    private void readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream =  new FileInputStream("src/main/java/com/act/framework/config/GlobalConfig.properties");
        //properties.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        properties.load(inputStream);
        Settings.logPath = properties.getProperty("LOG_PATH");
        Settings.mainUrl = properties.getProperty("MAIN_URL");
    }
}
