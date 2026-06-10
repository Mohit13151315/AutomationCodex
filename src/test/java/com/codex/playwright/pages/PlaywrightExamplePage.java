package com.codex.playwright.pages;

import com.microsoft.playwright.Page;

public class PlaywrightExamplePage {

    private final Page page;

    public PlaywrightExamplePage(Page page) {
        this.page = page;
    }

    public void navigateToApplication(String url) {
        page.navigate(url);
    }

    public String getPageTitle() {
        return page.title();
    }
}