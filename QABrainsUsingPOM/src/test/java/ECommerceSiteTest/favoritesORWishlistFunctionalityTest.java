package ECommerceSiteTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import ECommerceSite.CartSection;
import ECommerceSite.favoritesORWishlistFunctionality;
import enterIntoSiteFunctionality.LoginPage;

public class favoritesORWishlistFunctionalityTest extends BaseTest 
{
	private LoginPage login;
	private CartSection CS;
	private favoritesORWishlistFunctionality FW;
	
	@BeforeClass
	public void login() throws Exception
	{
		CS = new CartSection(driver);
		CS.navigateToECommerceWebSite();
		
		login = new LoginPage(driver);
		login.login("test@qabrains.com", "Password123");
	}
	
	@Test
	public void addRemoveFromFavList() throws Exception
	{
		FW = new favoritesORWishlistFunctionality(driver);
		FW.productAddRemoveFromFavList();
	}
}
