package Pages;

import java.awt.print.PageFormat;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class greenkartchkout 
{
	public greenkartchkout(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w, this);	
	}
	WebDriver w;

	@FindBy (xpath = "//img[@alt='Cart']") WebElement cart_btn;
	@FindBy (xpath = "//button[text()='PROCEED TO CHECKOUT']") WebElement chkout_btn;
	@FindBy (xpath = "//input[@class='promoCode']") WebElement promo_code;
	@FindBy (xpath = "//button[text()='Apply']") WebElement promo_apply;
	@FindBy (xpath = "//button[text()='Place Order']") WebElement place_order;

	public void chkout() throws Exception
	{
//		w.findElement(By.xpath("//img[@alt='Cart']")).click();
		cart_btn.click();
//		w.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		chkout_btn.click();
//		w.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("kart25");
		promo_code.sendKeys("kart25");
		w.findElement(By.xpath("//button[text()='Apply']")).click();
		promo_apply.click();
//		w.findElement(By.xpath("//button[text()='Place Order']")).click();
		place_order.click();
		WebElement selectcountry = w.findElement(By.xpath("//select"));
		Select s = new Select(selectcountry);
		s.selectByVisibleText("Bangladesh");
		w.findElement(By.xpath("//input[@class='chkAgree']")).click();
		w.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./greenkarttest.png");
		
		Files.copy(src,dest);
	}
}
