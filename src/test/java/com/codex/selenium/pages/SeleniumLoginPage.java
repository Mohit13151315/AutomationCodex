package com.codex.selenium.pages;

import com.codex.selenium.utils.SeleniumWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumLoginPage {

    private final WebDriver driver;
    private final SeleniumWaitUtils waitUtils;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.className("title");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public SeleniumLoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new SeleniumWaitUtils(driver);
    }

    public void navigateToApplication(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        waitUtils.waitForElementVisible(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUtils.waitForElementVisible(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        waitUtils.waitForElementClickable(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getProductsTitle() {
        return waitUtils.waitForElementVisible(productsTitle).getText();
    }

    public String getErrorMessage() {
        return waitUtils.waitForElementVisible(errorMessage).getText();
    }
}