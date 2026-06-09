package com.codex.selenium.base;

import com.codex.selenium.factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class SeleniumBaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}