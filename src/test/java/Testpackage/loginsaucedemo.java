package Testpackage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Testpackage.pages.SauceDemoLoginPage;

@Listeners(listen.class)
public class loginsaucedemo extends Baseclass {

    @Test
    public void validCredentialsShouldOpenInventory() {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(w);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(loginPage.isInventoryPageDisplayed(),
                "Valid credentials should open the SauceDemo inventory page");
    }

    @Test(dataProvider = "invalidCredentials")
    public void invalidCredentialsShouldShowError(String username, String password, String expectedError) {
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(w);

        loginPage.open();
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.getLoginError().contains(expectedError),
                "Invalid credentials should display the expected login error");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
                { "invalid_user", "invalid_password", "Username and password do not match" },
                { "locked_out_user", "secret_sauce", "Sorry, this user has been locked out" }
        };
    }
}
