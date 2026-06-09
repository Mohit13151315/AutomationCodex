package com.codex.selenium.factory;

import com.codex.selenium.utils.SeleniumConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver initDriver() {
        SeleniumConfigReader configReader = new SeleniumConfigReader();

        String browser = configReader.getProperty("browser");
        int implicitWait = Integer.parseInt(configReader.getProperty("implicitWait"));
        int pageLoadTimeout = Integer.parseInt(configReader.getProperty("pageLoadTimeout"));

        WebDriver driver;

        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        return driver;
    }
}