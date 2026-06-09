package com.codex.playwright.tests;

import com.codex.playwright.base.PlaywrightBaseTest;
import com.codex.playwright.utils.PlaywrightConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaywrightFirstTest extends PlaywrightBaseTest {

    @Test
    public void openExampleWebsite() {
        PlaywrightConfigReader configReader = new PlaywrightConfigReader();

        page.navigate(configReader.getProperty("url"));

        String actualTitle = page.title();

        page.waitForTimeout(5000);

        Assertions.assertEquals("Example Domain", actualTitle);
    }
}