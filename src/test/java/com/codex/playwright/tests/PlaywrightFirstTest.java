package com.codex.playwright.tests;

import com.codex.playwright.base.PlaywrightBaseTest;
import com.codex.playwright.pages.PlaywrightExamplePage;
import com.codex.playwright.utils.PlaywrightConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaywrightFirstTest extends PlaywrightBaseTest {

    @Test
    public void openExampleWebsite() {
        PlaywrightConfigReader configReader = new PlaywrightConfigReader();
        PlaywrightExamplePage examplePage = new PlaywrightExamplePage(page);

        examplePage.navigateToApplication(configReader.getProperty("url"));

        String actualTitle = examplePage.getPageTitle();
        String expectedTitle = configReader.getProperty("expectedTitle");

        page.waitForTimeout(5000);

        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}