package Testpackage;

import org.testng.annotations.Test;

import Pages.chkoutpage;
import Pages.dashboard;

public class mobilechkout extends PhoneBasw 
{
	@Test
	public void mobilejourney() throws Exception
	{
		w.get("https://vinothqaacademy.com/ecommerce-demo/home.html");
		
		dashboard d = new dashboard(w);
		d.addtocart();
		chkoutpage chk = new chkoutpage(w);
		chk.checkout();
	}
	
	

}
