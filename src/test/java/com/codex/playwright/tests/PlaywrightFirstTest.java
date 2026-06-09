package com.codex.playwright.tests;

import com.codex.playwright.base.PlaywrightBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaywrightFirstTest extends PlaywrightBaseTest {

    @Test
    public void openExampleWebsite() {
        page.navigate("https://example.com");

        String actualTitle = page.title();
        page.waitForTimeout(5000);

        Assertions.assertEquals("Example Domain", actualTitle);
    }
}