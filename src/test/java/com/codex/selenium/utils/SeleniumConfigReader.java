package com.codex.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SeleniumConfigReader {

    private final Properties properties;

    public SeleniumConfigReader() {
        properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/selenium-config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load selenium-config.properties file", e);
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Property not found or empty in selenium-config.properties: " + key);
        }

        return value;
    }
    public String getEnvironmentUrl() {
        String environment = System.getProperty("env");

        if (environment == null || environment.trim().isEmpty()) {
            environment = getProperty("env");
        }

        String urlKey = environment + ".url";
        return getProperty(urlKey);
    }
    public String getBrowser() {
        String browser = System.getProperty("browser");

        if (browser == null || browser.trim().isEmpty()) {
            browser = getProperty("browser");
        }

        return browser;
    }
}