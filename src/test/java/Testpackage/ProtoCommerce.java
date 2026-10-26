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
import org.testng.annotations.Test;
import Pages.ProtoChkout;
import Pages.ProtoRegisterpg;
import Pages.ProtoShop;


public class ProtoCommerce 
{
	WebDriver w;
	
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
	
	@Test
	public void opensite() throws Exception
	{
		w.get("https://rahulshettyacademy.com/angularpractice/");
		
	    ProtoRegisterpg r = new ProtoRegisterpg(w);
        r.ProtoRegister();
	    ProtoShop s = new ProtoShop(w);
		s.add_to_cart();
		ProtoChkout c = new ProtoChkout(w);
		c.chkout();
		
	}
	
	
	@AfterTest
	public void terminate()
	{
		w.close();
		w.quit();
	}
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		ProtoCommerce p = new ProtoCommerce();
		p.launch();
		p.opensite();
		p.terminate();
	}
	
	
	
	
}
