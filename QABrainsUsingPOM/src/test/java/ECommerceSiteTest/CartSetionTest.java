package ECommerceSiteTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BaseClassForLogin.BaseTest;
import ECommerceSite.CartSection;
import enterIntoSiteFunctionality.LoginPage;

public class CartSetionTest extends BaseTest
{
	private LoginPage login;
	private CartSection CS;
	
	@BeforeClass
	public void login() throws Exception
	{
		CS = new CartSection(driver);
		CS.navigateToECommerceWebSite();
		
		login = new LoginPage(driver);
		login.login("test@qabrains.com", "Password123");
	}
	
	@Test(priority = 1)
	public void addItemToCart() throws Exception
	{
		CS = new CartSection(driver);
		CS.addToCart();
//		CS.verifyProduct();
	}
	@Test(priority = 2)
	public void verifyQuantityUpdate() throws Exception
	{
		CS = new CartSection(driver);
		CS.quantityUpdate();
	}
	
	@Test(priority = 3)
	public void itemRemoveFunctionality() throws Exception
	{
		CS = new CartSection(driver);
		CS.removeProducts();
	}
	
}
