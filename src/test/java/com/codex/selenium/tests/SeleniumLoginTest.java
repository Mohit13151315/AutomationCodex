package com.codex.selenium.tests;

import com.codex.selenium.base.SeleniumBaseTest;
import com.codex.selenium.pages.SeleniumLoginPage;
import com.codex.selenium.utils.SeleniumConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;


@Tag("selenium")
public class SeleniumLoginTest extends SeleniumBaseTest {

    @Tag("smoke")
    @Test
    public void validLoginTest()  {
        SeleniumConfigReader configReader = new SeleniumConfigReader();
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);

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
    public void lockedOutUserLoginTest()  {
        SeleniumConfigReader configReader = new SeleniumConfigReader();
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);

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