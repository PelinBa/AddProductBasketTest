package com.pb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class AddProductBasketTest {

    private WebDriver webDriver;

    private MainPage mainPage;
    private ProductListPage productListPage;
    private ProductDetailPage productDetailPage;
    private BasketPage basketPage;

    private Actions actions;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/pelin/Downloads/chromedriver_mac64/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(webDriver);

        mainPage = new MainPage(webDriver);
        productListPage = new ProductListPage(webDriver);
        productDetailPage = new ProductDetailPage(webDriver);
        basketPage = new BasketPage(webDriver);
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @Test
    public void add_selected_shoes_product_in_basket() {

        // Check Main Page Title
        String mainPageTitle = "LC Waikiki | Türkiye’nin Moda ve Giyim Online Alışveriş Sitesi - LC Waikiki";
        Assert.assertEquals(mainPage.pageTitle(), mainPageTitle);

        // Reject Cookies
        mainPage.clickRejectCookies();

        // Open drop down menu, after than select category
        actions.moveToElement(webDriver.findElement(By.cssSelector("a[href='https://www.lcwaikiki.com/tr-TR/TR/lp/kadin-erkek-cocuk-bebek-ayakkabi']"))).build().perform();

        // Open Product List Page
        mainPage.openShoesCategoryPage();

        // Check Product List Page Title
        String productListPageTitle = "Ev Terliği, Panduf, Kadın Ev Botu - LC Waikiki";
        Assert.assertEquals(productListPage.pageTitle(), productListPageTitle);

        // Open Selected Product
        productListPage.openSelectedProduct();

        // Check Product Detail Page Title
        String productDetailPageTitle = "Mor Fiyonk Detaylı Kadın Ev Terliği - W2KD28Z8-10S - LC Waikiki";
        Assert.assertEquals(productDetailPage.pageTitle(), productDetailPageTitle);

        // Select Product Colour
        productDetailPage.selectColour();
        // Select Product size
        productDetailPage.selectSize();
        // Add Product in basket
        productDetailPage.addBasket();

        // Open Basket Page
        productDetailPage.openBasketPage();

        // Check Basket page title
        String basketPageTitle = "Sepetim - LC Waikiki";
        Assert.assertEquals(basketPage.pageTitle(), basketPageTitle);

        // Open Main page
        basketPage.openMainPage();

        // Check Main page title
        Assert.assertEquals(mainPage.pageTitle(), mainPageTitle);
    }
}
