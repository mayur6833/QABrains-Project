package ECommerceSiteTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import ECommerceSite.CartSection;
import ECommerceSite.CheckoutFlow;
import enterIntoSiteFunctionality.LoginPage;

public class CheckoutFlowTest extends BaseTest
{
	private LoginPage login;
	private CartSection CS;
	private CheckoutFlow co;
	
	@BeforeClass
	public void login() throws Exception
	{		
		CS = new CartSection(driver);
		CS.navigateToECommerceWebSite();
		
		login = new LoginPage(driver);
		login.login("practice@qabrains.com", "Password123");
	}
	
	@Test (priority = 1)
	public void addToCartTestCase() throws Exception
	{
		co = new CheckoutFlow(driver);
		co.addToCart();
	}
	
	@Test(priority = 2)
	public void checkoutForm() throws Exception
	{
		co = new CheckoutFlow(driver);
		co.checkoutInf("abc", "xyz", "411043");
	}
	
	@Test(priority = 3)
	public void checkPrices() throws Exception
	{
		co = new CheckoutFlow(driver);
		co.overview();
	}
}
