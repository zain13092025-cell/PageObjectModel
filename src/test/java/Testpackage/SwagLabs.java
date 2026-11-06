package Testpackage;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SwagLabs extends PhoneBasw
{
	
	@Test
	public void loginpage() throws Exception
	{	
		
		FileInputStream fis = new FileInputStream("ExcelData/SauceLogin.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int lastrow = sh.getLastRowNum();
		
		for (int i = 1; i < lastrow; i++)
		{
			XSSFRow row = sh.getRow(i+1);
			String user = row.getCell(0).getStringCellValue();
			String pass = row.getCell(1).getStringCellValue();
			
			
			w.get("https://www.saucedemo.com");

			w.findElement(By.cssSelector("#user-name")).sendKeys(user);
			w.findElement(By.cssSelector("#password")).sendKeys(pass);
			w.findElement(By.cssSelector("#login-button")).click();
		}
	}
}
