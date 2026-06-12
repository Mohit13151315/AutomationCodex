package com.codex.selenium.tests;

import com.codex.common.utils.TestDataReader;
import com.codex.selenium.base.SeleniumBaseTest;
import com.codex.selenium.pages.SeleniumLoginPage;
import com.codex.selenium.utils.SeleniumConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("selenium")
public class SeleniumLoginTest extends SeleniumBaseTest {

    private final SeleniumConfigReader configReader = new SeleniumConfigReader();
    private final TestDataReader testDataReader = new TestDataReader("login-test-data.properties");

    @Tag("smoke")
    @Test
    public void validLoginTest() {
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);

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
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);

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