package com.codex.playwright.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    public Page initPage() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("msedge")
                        .setHeadless(false)
        );

        browserContext = browser.newContext();
        page = browserContext.newPage();

        return page;
    }

    public void closePlaywright() {
        if (page != null) {
            page.close();
        }

        if (browserContext != null) {
            browserContext.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}