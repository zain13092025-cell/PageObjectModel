package Pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class ProtoChkout
{
	
	WebDriver w;
	
	@FindBy (xpath = "//a[contains(text(), 'Checkout')]") WebElement chkout_page;
	@FindBy (xpath = "//button[contains(., 'Checkout')]") WebElement chkout_btn;
	@FindBy (css = "#country") WebElement country;
	@FindBy (xpath = "//input[@type='submit']") WebElement submit_btn;
	
	
	public ProtoChkout(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w, this);
	}


	public void chkout() throws Exception
	{
		
	//	w.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
		
		chkout_page.click();
		
	// w.findElement(By.xpath("//button[contains(., 'Checkout')]")).click();
		
		chkout_btn.click();
		
	//	w.findElement(By.cssSelector("#country")).sendKeys("in");
		
		country.sendKeys("in");
		
		WebDriverWait wait = new WebDriverWait(w,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='India']"))).click();
		
		WebDriverWait Wait = new WebDriverWait(w, Duration.ofSeconds(10));
		WebElement checkboxLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='checkbox2']")));
		checkboxLabel.click();
		
		w.findElement(By.xpath("//input[@type='submit']")).click();
		
		submit_btn.click();
		
		TakesScreenshot tc = (TakesScreenshot)w;
		File src2 = tc.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("ScreenShot/Shop.png");
		
		Files.copy(src2,dest2);
	}
	
	

}
