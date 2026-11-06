package Testpackage;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class PhoneBasw 
{
	protected WebDriver w;
	
	@BeforeTest
	public void launch()
	{
		System.out.println("Enter Browser Name: ");
		Scanner sc = new Scanner(System.in);
		String browser = sc.next();
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");
			w = new ChromeDriver(op);
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions op = new EdgeOptions();
			op.addArguments("-inprivate");
			w = new EdgeDriver();
		}
		else 
		{
			System.out.println("Invalid Browser Name. Please enter Chrome or Edge");
			sc.close();
			return;
		}
		sc.close();
		w.manage().window().maximize();
		w.manage().deleteAllCookies();
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	
	@AfterTest
	public void terminate()
	{
		w.close();
		w.quit();
	}
	
}

