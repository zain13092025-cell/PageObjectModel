package Testpackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Baseclass {
    protected WebDriver w;

    @BeforeMethod
    public void launch() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        w = new ChromeDriver(options);
        w.manage().window().maximize();
        w.manage().deleteAllCookies();
        w.manage().timeouts().implicitlyWait(Duration.ZERO);
    }

    @AfterMethod(alwaysRun = true)
    public void terminate() {
        if (w != null) {
            w.quit();
            w = null;
        }
    }
}
