package com.codex.selenium.tests;

import com.codex.selenium.base.SeleniumBaseTest;
import com.codex.selenium.utils.SeleniumConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeleniumFirstTest extends SeleniumBaseTest {

    @Test
    public void openExampleWebsite() throws InterruptedException {
        SeleniumConfigReader configReader = new SeleniumConfigReader();

        driver.get(configReader.getProperty("url"));

        String actualTitle = driver.getTitle();

        Thread.sleep(5000);

        String expectedTitle = configReader.getProperty("expectedTitle");
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}