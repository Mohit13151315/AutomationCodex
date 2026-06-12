package com.codex.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {

    private final Properties properties;

    public TestDataReader(String fileName) {
        properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("testdata/" + fileName)) {
            if (inputStream == null) {
                throw new RuntimeException("Test data file not found: " + fileName);
            }

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data file: " + fileName, e);
        }
    }

    public String getData(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException("Test data not found or empty: " + key);
        }

        return value;
    }
}