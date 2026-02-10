package ECommerceSiteTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import ECommerceSite.CartSection;
import ECommerceSite.CheckPriceRange;
import enterIntoSiteFunctionality.LoginPage;

public class CheckPriceRangeTest extends BaseTest
{
	private LoginPage login;
	private CartSection CS;
	private CheckPriceRange CPR;
	
	@BeforeClass
	public void login()
	{
		CS = new CartSection(driver);
		CS.navigateToECommerceWebSite();
		
		login = new LoginPage(driver);
		login.login("test@qabrains.com", "Password123");
	}
	
	@Test(priority = 1)
	public void checkPriceLowToHigh() throws Exception
	{
		CPR = new CheckPriceRange(driver);
		CPR.validatePriceLowToHigh();
	}
	
	@Test(priority = 2)
	public void checkPriceHighToLow()
	{
		CPR = new CheckPriceRange(driver);
		CPR.validatePriceHighToLow();
	}
}

