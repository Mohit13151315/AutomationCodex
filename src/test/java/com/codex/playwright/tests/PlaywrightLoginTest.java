package com.codex.playwright.tests;

import com.codex.playwright.base.PlaywrightBaseTest;
import com.codex.playwright.pages.PlaywrightLoginPage;
import com.codex.playwright.utils.PlaywrightConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaywrightLoginTest extends PlaywrightBaseTest {

    @Test
    public void validLoginTest() {
        PlaywrightConfigReader configReader = new PlaywrightConfigReader();
        PlaywrightLoginPage loginPage = new PlaywrightLoginPage(page);

        loginPage.navigateToApplication(configReader.getProperty("url"));
        loginPage.login(
                configReader.getProperty("username"),
                configReader.getProperty("password")
        );

        String actualProductsTitle = loginPage.getProductsTitle();
        String expectedProductsTitle = configReader.getProperty("expectedProductsTitle");

        page.waitForTimeout(5000);

        Assertions.assertEquals(expectedProductsTitle, actualProductsTitle);
    }
}