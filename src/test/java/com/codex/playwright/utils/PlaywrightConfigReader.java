package com.codex.playwright.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightConfigReader {

    private final Properties properties;

    public PlaywrightConfigReader() {
        properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/playwright-config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load playwright-config.properties file", e);
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Property not found or empty in playwright-config.properties: " + key);
        }

        return value;
    }
}