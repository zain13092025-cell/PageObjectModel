package Pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class chkoutpage 
{
	WebDriver w;
	@FindBy(xpath = "//button[contains(text(),'Add to Cart')]")WebElement cart_btn;
    @FindBy(xpath = "//a[contains(text(),'Proceed to Payment')]")WebElement pay_btn;
    @FindBy(css = "#card")WebElement card;
    @FindBy(css = "#expiry")WebElement exp;
    @FindBy(css = "#cvc")WebElement cvc;
    @FindBy(css = "#name")WebElement name;
    @FindBy(xpath = "//button[contains(text(),'Pay')]")WebElement submit;
    @FindBy(xpath = "//a[contains(text(),'Back to Home')]")WebElement home_page;
    
	public chkoutpage(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w,this);
	}

	public void checkout() throws Exception
	{
	//	w.findElement(By.xpath("//button[contains(text(),'Add to Cart')].click();
		cart_btn.click();
	//	w.findElement(By.xpath("//a[contains(text(),'Proceed to Payment')]")).click();
		pay_btn.click();
	//	w.findElement(By.cssSelector("#card")).sendKeys("1234 5678 9876 5432");
		card.sendKeys("1234 5678 9876 5432");
	//	w.findElement(By.cssSelector("#expiry")).sendKeys("11/27");
		exp.sendKeys("11/27");
	//	w.findElement(By.cssSelector("#cvc")).sendKeys("123");
		cvc.sendKeys("123");
	//	w.findElement(By.cssSelector("#name")).sendKeys("John Doe");
		name.sendKeys("John Doe");
	//	w.findElement(By.cssSelector("#submit-btn")).click();
		submit.click();
		
		TakesScreenshot tc = (TakesScreenshot) w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/test.png");
	    Files.copy(src, dest);
	    
		w.findElement(By.xpath("//a[contains(text(),'Back to Home')]")).click();
		home_page.click();
		
		
}
}