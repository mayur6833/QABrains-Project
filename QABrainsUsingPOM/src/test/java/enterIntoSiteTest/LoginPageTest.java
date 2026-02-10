package enterIntoSiteTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import enterIntoSiteFunctionality.LoginPage;

public class LoginPageTest extends BaseTest
{
	private LoginPage obj1;
	
	@BeforeClass
	public void loginToApp()
	{
		obj1 = new LoginPage(driver);
	}
	
	@Test
	public void LoginFunctionality() throws Exception
	{
		obj1.login("qa_testers@qabrains.com", "Password123");
	}
}
