package Testpackage.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenCartHomePage {
    private static final String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By searchBox = By.cssSelector("input.search-keyword");
    private final By cartIcon = By.cssSelector("a.cart-icon");

    public GreenCartHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
    }

    public void searchAndAddProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox)).clear();
        driver.findElement(searchBox).sendKeys(productName);
        By addButton = By.xpath("//div[contains(@class,'product')][.//h4[normalize-space()='" +
                productName + " - 1 Kg']]//button[normalize-space()='ADD TO CART']");
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}
