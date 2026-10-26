package Testpackage.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoLoginPage {
    private static final String URL = "https://www.saucedemo.com/";

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginError = By.cssSelector("[data-test='error']");

    public SauceDemoLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    }

    public void login(String usernameValue, String passwordValue) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(usernameValue);
        driver.findElement(password).sendKeys(passwordValue);
        driver.findElement(loginButton).click();
    }

    public boolean isInventoryPageDisplayed() {
        return wait.until(ExpectedConditions.urlContains("/inventory.html"));
    }

    public String getLoginError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginError)).getText();
    }
}
