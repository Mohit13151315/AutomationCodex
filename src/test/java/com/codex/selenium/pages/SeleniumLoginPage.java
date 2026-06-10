package com.codex.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumLoginPage {

    private final WebDriver driver;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsTitle = By.className("title");

    public SeleniumLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToApplication(String url) {
        driver.get(url);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }
}