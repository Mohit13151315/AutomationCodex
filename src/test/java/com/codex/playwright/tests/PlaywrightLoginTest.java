package com.codex.playwright.tests;

import com.codex.playwright.base.PlaywrightBaseTest;
import com.codex.playwright.pages.PlaywrightLoginPage;
import com.codex.playwright.utils.PlaywrightConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("playwright")
public class PlaywrightLoginTest extends PlaywrightBaseTest {
    @Tag("smoke")
    @Test
    public void validLoginTest() {
        PlaywrightConfigReader configReader = new PlaywrightConfigReader();
        PlaywrightLoginPage loginPage = new PlaywrightLoginPage(page);

        loginPage.navigateToApplication(configReader.getEnvironmentUrl());
        loginPage.login(
                configReader.getProperty("username"),
                configReader.getProperty("password")
        );

        String actualProductsTitle = loginPage.getProductsTitle();
        String expectedProductsTitle = configReader.getProperty("expectedProductsTitle");


        Assertions.assertEquals(expectedProductsTitle, actualProductsTitle);
    }
    @Tag("regression")
    @Test
    public void lockedOutUserLoginTest() {
        PlaywrightConfigReader configReader = new PlaywrightConfigReader();
        PlaywrightLoginPage loginPage = new PlaywrightLoginPage(page);

        loginPage.navigateToApplication(configReader.getEnvironmentUrl());
        loginPage.login(
                configReader.getProperty("invalidUsername"),
                configReader.getProperty("invalidPassword")
        );

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = configReader.getProperty("expectedLockedOutError");


        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}