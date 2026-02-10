package enterIntoSiteTest;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import enterIntoSiteFunctionality.forgotPasswordPage;

public class forgotPasswordPageTest extends BaseTest
{
	private forgotPasswordPage obj;
	
	
	@BeforeClass
	public void forgotPreviousPassword()
	{
		obj = new forgotPasswordPage(driver);
	}
	
	@Test
	public void forgotPasswordFunctionality() throws Exception
	{
		obj.forgotpasswords("abc@gmail.com");
	}
}

