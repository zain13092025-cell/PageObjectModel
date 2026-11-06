package Testpackage;

	import java.io.File;
	import java.time.Duration;
	import java.util.Scanner;

	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.google.common.io.Files;
	
	public class ProtoCommerceSite
	{
		WebDriver w;
		
	
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
		
		public void opensite()
		{
			w.get("https://rahulshettyacademy.com/angularpractice/");
			
			w.findElement(By.xpath("//input[@name='name']")).sendKeys("Rahul");
			w.findElement(By.xpath("//input[@name='email']")).sendKeys("qalead2026@testing.com");
			w.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Rahulshetty26");
			w.findElement(By.cssSelector("#exampleCheck1")).click();
			
			WebElement ele = w.findElement(By.cssSelector("#exampleFormControlSelect1"));
			
			Select s = new Select(ele);
			s.selectByVisibleText("Female");
			s.selectByVisibleText("Male");
			
			w.findElement(By.cssSelector("#inlineRadio2")).click();
			
			w.findElement(By.xpath("//input[@name='bday']")).sendKeys("15032020");
			
			w.findElement(By.xpath("//input[@type='submit']")).click();
		   
			
		}
		
		public void screenshot() throws Exception
		{
			TakesScreenshot tc = (TakesScreenshot)w;
			File src = tc.getScreenshotAs(OutputType.FILE);
			File dest = new File("ScreenShot/Protocommerce.png");
			
			Files.copy(src,dest);
		}
		
		public void shop() throws Exception
		{
			w.findElement(By.xpath("//a[text()='Shop']")).click();
			
			w.findElement(By.xpath("(//button[text()='Add '])[3]")).click();
			w.findElement(By.xpath("(//button[text()='Add '])[1]")).click();
			w.findElement(By.xpath("(//button[text()='Add '])[4]")).click();
			w.findElement(By.xpath("(//button[text()='Add '])[2]")).click();
			
			w.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
			w.findElement(By.xpath("//button[contains(., 'Checkout')]")).click();
			w.findElement(By.cssSelector("#country")).sendKeys("in");
			
			WebDriverWait wait = new WebDriverWait(w,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='India']"))).click();
			
			WebDriverWait Wait = new WebDriverWait(w, Duration.ofSeconds(10));
			WebElement checkboxLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='checkbox2']")));
			checkboxLabel.click();
			w.findElement(By.xpath("//input[@type='submit']")).click();
			
			TakesScreenshot tc = (TakesScreenshot)w;
			File src2 = tc.getScreenshotAs(OutputType.FILE);
			File dest2 = new File("ScreenShot/Shop.png");
			
			Files.copy(src2,dest2);
		}
		
		
		
		public void terminate()
		{
			w.close();
			w.quit();
		}
		
		
		
		
		public static void main(String[] args) throws Exception
		{
			ProtoCommerceSite p = new ProtoCommerceSite();
			p.launch();
			p.opensite();
			p.screenshot();
			p.shop();
			p.terminate();
		}
		
		
		
		
	}



