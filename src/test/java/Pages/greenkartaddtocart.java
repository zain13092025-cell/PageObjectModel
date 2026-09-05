package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class greenkartaddtocart 
{
	WebDriver w;
	@FindBy (xpath = "//input[@type='search']") WebElement search;
	@FindBy (xpath = "//button[text()='ADD TO CART']") WebElement add_btn;
	
	public greenkartaddtocart(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w, this);
	}
	public void addtocart() throws Exception
	{
	//add to cart
			FileInputStream fis = new FileInputStream("ExcelData/VegList2.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(0);
			int rowcount = sh.getLastRowNum();
			
			for (int i = 1; i<rowcount; i++)
			{
				XSSFRow row = sh.getRow(i+1);
				String veg = row.getCell(0).getStringCellValue();
				
		//		w.findElement(By.xpath("//input[@type='search']")).sendKeys(veg);
		//		w.findElement(By.xpath("//input[@type='search']")).clear();
			
	
		//checkout journey
		search.sendKeys(veg);
//		w.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		add_btn.click();
		search.clear();

			}
	}

}
