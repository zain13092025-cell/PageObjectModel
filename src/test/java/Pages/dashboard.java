package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class dashboard 
{
	WebDriver w;
	@FindBy(xpath = "//h3")List<WebElement> mobilelist;
	@FindBy(xpath = "following-sibling::p") WebElement price_ele;
	public dashboard(WebDriver w2) 
	{
		this.w = w2;
		PageFactory.initElements(w,this);
	}

	public void addtocart()
	{
		List<WebElement> phones = mobilelist;
		
		for (WebElement temp: phones)
		{
			String name = temp.getText();
			System.out.println(name);
			
			if(name.equalsIgnoreCase("Motorola Edge 40 Ultra"))
		{
			String price = temp.findElement(By.xpath("following-sibling::p")).getText();
			
			System.out.println("Phone : " + name);
			System.out.println("Price : " + price);
			temp.click();
		
			break;
		}
		}
	}
	
	
}
