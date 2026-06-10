package com.codex.selenium.pages;

import org.openqa.selenium.WebDriver;

public class SeleniumExamplePage {

    private final WebDriver driver;

    public SeleniumExamplePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToApplication(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}