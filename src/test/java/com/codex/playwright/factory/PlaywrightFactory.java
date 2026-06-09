package com.codex.playwright.factory;

import com.codex.playwright.utils.PlaywrightConfigReader;
import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    public Page initPage() {
        PlaywrightConfigReader configReader = new PlaywrightConfigReader();

        String browserName = configReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(configReader.getProperty("headless"));

        playwright = Playwright.create();

        if (browserName.equalsIgnoreCase("edge")) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("msedge")
                            .setHeadless(headless)
            );
        } else {
            throw new RuntimeException("Unsupported browser: " + browserName);
        }

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