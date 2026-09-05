package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Testpackage.Baseclass;

public class greenkartsite extends Baseclass
{
	
	@Test
	public void dashboard() throws Exception
	{
		w.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		greenkartaddtocart ad = new greenkartaddtocart(w);
		ad.addtocart();
		greenkartchkout ch = new greenkartchkout(w);
		ch.chkout();
	}
}
