package com.codex.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PlaywrightLoginPage {

    private final Page page;

    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator productsTitle;
    private final Locator errorMessage;

    public PlaywrightLoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.productsTitle = page.locator(".title");
        this.errorMessage = page.locator("[data-test='error']");
    }

    public void navigateToApplication(String url) {
        page.navigate(url);
    }

    public void enterUsername(String username) {
        usernameInput.fill(username);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getProductsTitle() {
        return productsTitle.innerText();
    }

    public String getErrorMessage() {
        return errorMessage.innerText();
    }
}