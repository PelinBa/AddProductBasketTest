package com.pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver webDriver;

    private final By rejectCookies = By.xpath("//button[text()='Tüm Çerezleri Reddet']");
    private final By typeOfShoes = By.xpath("(//a[@href='/tr-TR/TR/kategori/kadin/ev-terligi-ve-panduf-196'])[2]");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void clickRejectCookies() {
        webDriver.findElement(rejectCookies).click();
    }

    public void openShoesCategoryPage() {
        webDriver.findElement(typeOfShoes).click();
    }
}
