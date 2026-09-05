package Testpackage;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass 
{
	public WebDriver w;
	
	@BeforeTest
	public void launch()
	{
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		w = new ChromeDriver(op);
		
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	public ExtentReports extentObj()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./report/mytest.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	public String screenshot(WebDriver w2, String testname) 
	{
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM_dd_HH_mm_ss");
		String timestamp = now.format(formatter);
		
		TakesScreenshot tc = (TakesScreenshot) w2;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File(./ScreenShot/"+testname+"_".png");
		
		return dest.getAbsolutePath();
		}
	
	@AfterTest
	public void terminate()
	{
		w.close();
		w.quit();
	}
}
