package Testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class greenkart extends Baseclass
{
	
	@Test
	public void greenkartTest() throws Exception
	{
		//site launch
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//add to cart
		FileInputStream fis = new FileInputStream("ExcelData/VegList2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
		
		for (int i = 1; i<rowcount; i++)
		{
			XSSFRow row = sh.getRow(i+1);
			String veg = row.getCell(0).getStringCellValue();
			
			w.findElement(By.xpath("//input[@type='search']")).sendKeys(veg);
			w.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
			w.findElement(By.xpath("//input[@type='search']")).clear();
		}
		
		//checkout journey
		w.findElement(By.xpath("//img[@alt='Cart']")).click();
		w.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		w.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("kart25");
		w.findElement(By.xpath("//button[text()='Apply']")).click();
		w.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebElement selectcountry = w.findElement(By.xpath("//select"));
		Select s = new Select(selectcountry);
		s.selectByVisibleText("Bangladesh");
		w.findElement(By.xpath("//input[@class='chkAgree']")).click();
		w.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		TakesScreenshot tc = (TakesScreenshot)w;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("ScreenShot/greenkarttest.png");
		
		Files.copy(src,dest);
	}
	
}
