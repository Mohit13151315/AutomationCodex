package com.codex.playwright.base;

import com.codex.playwright.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PlaywrightBaseTest {

    protected Page page;
    private PlaywrightFactory playwrightFactory;

    @BeforeEach
    public void setUp() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initPage();
    }

    @AfterEach
    public void tearDown() {
        if (playwrightFactory != null) {
            playwrightFactory.closePlaywright();
        }
    }
}