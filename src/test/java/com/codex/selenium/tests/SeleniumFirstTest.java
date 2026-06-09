package com.codex.selenium.tests;

import com.codex.selenium.base.SeleniumBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SeleniumFirstTest extends SeleniumBaseTest {

    @Test
    public void openExampleWebsite() {
        driver.get("https://example.com");

        String actualTitle = driver.getTitle();

        Assertions.assertEquals("Example Domain", actualTitle);
    }
}