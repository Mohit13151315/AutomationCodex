package com.codex.playwright.base;

import com.codex.playwright.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.codex.playwright.utils.PlaywrightScreenshotUtils;
import org.junit.jupiter.api.TestInfo;

public class PlaywrightBaseTest {

    protected Page page;
    private PlaywrightFactory playwrightFactory;

    @BeforeEach
    public void setUp() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initPage();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (page != null) {
            PlaywrightScreenshotUtils.captureScreenshot(page, testInfo.getDisplayName());
        }

        if (playwrightFactory != null) {
            playwrightFactory.closePlaywright();
        }
    }
}