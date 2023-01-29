package com.pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private final WebDriver webDriver;

    private final By selectedColour = By.cssSelector("a[href*='2702145']");
    private final By selectedSize = By.cssSelector("a[key='2']");
    private final By addBasketButton = By.id("pd_add_to_cart");
    private final By basketButton = By.cssSelector("a[href$='sepetim']");

    public ProductDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void selectColour() {
        webDriver.findElement(selectedColour).click();
    }

    public void selectSize() {
        webDriver.findElement(selectedSize).click();
    }

    public void addBasket() {
        webDriver.findElement(addBasketButton).click();
    }

    public void openBasketPage() {
        webDriver.findElement(basketButton).click();
    }
}
