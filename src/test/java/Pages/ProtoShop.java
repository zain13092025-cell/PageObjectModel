package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProtoShop 
{
	WebDriver w;
	
	@FindBy (xpath = "//a[text()='Shop']") WebElement shop;
	@FindBy (xpath = "(//button[text()='Add '])[3]") WebElement add_nokia;
	@FindBy (xpath = "(//button[text()='Add '])[1]") WebElement add_iphone;	
	@FindBy (xpath = "(//button[text()='Add '])[4]") WebElement add_blackberry;
	@FindBy (xpath = "(//button[text()='Add '])[2]") WebElement add_samsung;
	
	
	
	
	
	public ProtoShop(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w, this);
	}





	public void add_to_cart() 
	{
		
	//	w.findElement(By.xpath("//a[text()='Shop']")).click();
		
		shop.click();
		
	//	w.findElement(By.xpath("(//button[text()='Add '])[3]")).click();
		
		add_nokia.click();
		
	//	w.findElement(By.xpath("(//button[text()='Add '])[1]")).click();
		
		add_iphone.click();
		
	//	w.findElement(By.xpath("(//button[text()='Add '])[4]")).click();
		
		add_blackberry.click();
		
	//	w.findElement(By.xpath("(//button[text()='Add '])[2]")).click();
		
		add_samsung.click();
		
	//	w.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
	}

}
