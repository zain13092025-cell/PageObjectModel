package Testpackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Testpackage.pages.CartPage;
import Testpackage.pages.CheckoutPage;
import Testpackage.pages.GreenCartHomePage;

@Listeners(listen.class)
public class greenkart extends Baseclass {
    @Test
    public void addItemsAndCompleteCheckout() {
        GreenCartHomePage homePage = new GreenCartHomePage(w);
        CartPage cartPage = new CartPage(w);
        CheckoutPage checkoutPage = new CheckoutPage(w);

        homePage.open();
        homePage.searchAndAddProduct("Brocolli");
        homePage.searchAndAddProduct("Carrot");
        homePage.openCart();
        cartPage.proceedToCheckout();
        checkoutPage.applyPromoCode("rahulshettyacademy");
        Assert.assertTrue(checkoutPage.isPromoApplied(),
                "The promo code should be accepted before placing the order");
        checkoutPage.placeOrder();
        checkoutPage.completeCountryAndTerms("India");

        Assert.assertTrue(checkoutPage.getConfirmationMessage()
                        .contains("Thank you, your order has been placed successfully"));
    }
}
