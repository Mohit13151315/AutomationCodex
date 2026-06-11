package com.codex.playwright.utils;

import com.microsoft.playwright.Page;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlaywrightScreenshotUtils {

    public static void captureScreenshot(Page page, String testName) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        Path screenshotPath = Paths.get(
                "target",
                "screenshots",
                "playwright",
                testName + "_" + timestamp + ".png"
        );

        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));

        System.out.println("Playwright screenshot saved at: " + screenshotPath.toAbsolutePath());
    }
}