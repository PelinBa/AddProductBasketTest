package com.pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {

    private final WebDriver webDriver;

    private final By mainPageButton = By.className("header__middle__left");

    public BasketPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void openMainPage() {
        webDriver.findElement(mainPageButton).click();
    }
}
