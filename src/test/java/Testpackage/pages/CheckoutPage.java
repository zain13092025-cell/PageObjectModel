package Testpackage.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By promoCode = By.cssSelector("input.promoCode");
    private final By applyButton = By.xpath("//button[normalize-space()='Apply']");
    private final By promoInfo = By.cssSelector("span.promoInfo");
    private final By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");
    private final By country = By.cssSelector("select");
    private final By terms = By.cssSelector("input.chkAgree");
    private final By proceedButton = By.xpath("//button[normalize-space()='Proceed']");
    private static final String CONFIRMATION_MESSAGE =
            "Thank you, your order has been placed successfully";

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void applyPromoCode(String code) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoCode)).sendKeys(code);
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

    public boolean isPromoApplied() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(promoInfo, "Code applied ..!"));
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void completeCountryAndTerms(String countryName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(country));
        new Select(driver.findElement(country)).selectByVisibleText(countryName);
        wait.until(ExpectedConditions.elementToBeClickable(terms)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }

    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("body"), CONFIRMATION_MESSAGE));
        return CONFIRMATION_MESSAGE;
    }
}
