package com.codex.selenium.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String testName) {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        Path screenshotPath = Paths.get(
                "target",
                "screenshots",
                "selenium",
                testName + "_" + timestamp + ".png"
        );

        try {
            Files.createDirectories(screenshotPath.getParent());
            Files.copy(sourceFile.toPath(), screenshotPath);
            System.out.println("Selenium screenshot saved at: " + screenshotPath.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture Selenium screenshot", e);
        }
    }
}