package com.codex.playwright.tests;

import com.codex.common.utils.TestDataReader;
import com.codex.playwright.base.PlaywrightBaseTest;
import com.codex.playwright.pages.PlaywrightLoginPage;
import com.codex.playwright.utils.PlaywrightConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("playwright")
public class PlaywrightLoginTest extends PlaywrightBaseTest {

    private final PlaywrightConfigReader configReader = new PlaywrightConfigReader();
    private final TestDataReader testDataReader = new TestDataReader("login-test-data.properties");

    @Tag("smoke")
    @Test
    public void validLoginTest() {
        PlaywrightLoginPage loginPage = new PlaywrightLoginPage(page);

        loginPage.navigateToApplication(configReader.getEnvironmentUrl());
        loginPage.login(
                testDataReader.getData("validUsername"),
                testDataReader.getData("validPassword")
        );

        String actualProductsTitle = loginPage.getProductsTitle();
        String expectedProductsTitle = testDataReader.getData("expectedProductsTitle");

        Assertions.assertEquals(expectedProductsTitle, actualProductsTitle);
    }

    @Tag("regression")
    @Test
    public void lockedOutUserLoginTest() {
        PlaywrightLoginPage loginPage = new PlaywrightLoginPage(page);

        loginPage.navigateToApplication(configReader.getEnvironmentUrl());
        loginPage.login(
                testDataReader.getData("lockedOutUsername"),
                testDataReader.getData("lockedOutPassword")
        );

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage = testDataReader.getData("expectedLockedOutError");

        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}