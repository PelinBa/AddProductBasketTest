package com.pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {

    private final WebDriver webDriver;

    private final By categorySelectedProduct = By.cssSelector("a[data-optionid='2702146']");

    public ProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void openSelectedProduct() {
        webDriver.findElement(categorySelectedProduct).click();
    }
}
