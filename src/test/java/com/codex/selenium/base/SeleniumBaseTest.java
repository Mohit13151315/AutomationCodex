package com.codex.selenium.base;

import com.codex.selenium.factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import com.codex.selenium.utils.SeleniumScreenshotUtils;
import org.junit.jupiter.api.TestInfo;

public class SeleniumBaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (driver != null) {
            SeleniumScreenshotUtils.captureScreenshot(driver, testInfo.getDisplayName());
            driver.quit();
        }
    }
}