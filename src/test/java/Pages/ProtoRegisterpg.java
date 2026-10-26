package Pages;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class ProtoRegisterpg 
{
	public ProtoRegisterpg(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w, this);
	}

	WebDriver w;
	
	@FindBy (xpath = "//input[@name='name']") WebElement name;
	@FindBy (xpath = "//input[@name='email']") WebElement email;
	@FindBy (xpath = "//input[@placeholder='Password']") WebElement pass;
	@FindBy (css = "#exampleCheck1") WebElement check;
	@FindBy (css = "#inlineRadio2") WebElement radio;
	@FindBy (xpath = "//input[@name='bday']") WebElement bday;
	@FindBy (xpath = "//input[@type='submit']") WebElement submit;
	
	
	public void ProtoRegister() throws Exception
	{
	//	w.findElement(By.xpath("//input[@name='name']")).sendKeys("Rahul");
		
		name.sendKeys("Rahul");
		
	//	w.findElement(By.xpath("//input[@name='email']")).sendKeys("qalead2026@testing.com");
		
		email.sendKeys("qalead2026@testing.com");
		
	//	w.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Rahulshetty26");
		
		pass.sendKeys("Rahulshetty26");
		
	//	w.findElement(By.cssSelector("#exampleCheck1")).click();
		
		check.click();
		
		WebElement ele = w.findElement(By.cssSelector("#exampleFormControlSelect1"));
		
		Select s = new Select(ele);
		s.selectByVisibleText("Female");
		s.selectByVisibleText("Male");
		
	//	w.findElement(By.cssSelector("#inlineRadio2")).click();
		
		radio.click();
		
	//	w.findElement(By.xpath("//input[@name='bday']")).sendKeys("15032020");
		
		bday.sendKeys("15032020");
		
	//	w.findElement(By.xpath("//input[@type='submit']")).click();
		
		submit.click();
		
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("ScreenShot/Protocommerce.png");
		
		Files.copy(src,dest);
	}
	
	
	
	
	

}
