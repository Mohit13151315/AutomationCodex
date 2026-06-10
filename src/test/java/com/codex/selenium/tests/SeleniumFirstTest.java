package com.codex.selenium.tests;

import com.codex.selenium.base.SeleniumBaseTest;
import com.codex.selenium.pages.SeleniumExamplePage;
import com.codex.selenium.utils.SeleniumConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeleniumFirstTest extends SeleniumBaseTest {

    @Test
    public void openExampleWebsite() throws InterruptedException {
        SeleniumConfigReader configReader = new SeleniumConfigReader();
        SeleniumExamplePage examplePage = new SeleniumExamplePage(driver);

        examplePage.navigateToApplication(configReader.getProperty("url"));

        String actualTitle = examplePage.getPageTitle();
        String expectedTitle = configReader.getProperty("expectedTitle");

        Thread.sleep(5000);

        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}