package Testpackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PhoneBasw 
{
	WebDriver w;
	
	@BeforeTest
	public void launch()
	{
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incogito");
		w = new ChromeDriver(op);
		
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		System.out.println("This is a new change in zain-project");
	}
	
	@AfterTest
	public void terminate()
	{
		w.close();
		w.quit();
	}
	
}