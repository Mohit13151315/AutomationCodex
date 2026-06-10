package com.codex.selenium.tests;

import com.codex.selenium.base.SeleniumBaseTest;
import com.codex.selenium.pages.SeleniumLoginPage;
import com.codex.selenium.utils.SeleniumConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeleniumLoginTest extends SeleniumBaseTest {

    @Test
    public void validLoginTest() throws InterruptedException {
        SeleniumConfigReader configReader = new SeleniumConfigReader();
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);

        loginPage.navigateToApplication(configReader.getProperty("url"));
        loginPage.login(
                configReader.getProperty("username"),
                configReader.getProperty("password")
        );

        String actualProductsTitle = loginPage.getProductsTitle();
        String expectedProductsTitle = configReader.getProperty("expectedProductsTitle");

        Thread.sleep(5000);

        Assertions.assertEquals(expectedProductsTitle, actualProductsTitle);
    }
}