package com.codex.playwright.pages;

import com.microsoft.playwright.Page;

public class PlaywrightLoginPage {

    private final Page page;

    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String productsTitle = ".title";

    public PlaywrightLoginPage(Page page) {
        this.page = page;
    }

    public void navigateToApplication(String url) {
        page.navigate(url);
    }

    public void enterUsername(String username) {
        page.locator(usernameInput).fill(username);
    }

    public void enterPassword(String password) {
        page.locator(passwordInput).fill(password);
    }

    public void clickLoginButton() {
        page.locator(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getProductsTitle() {
        return page.locator(productsTitle).innerText();
    }
}