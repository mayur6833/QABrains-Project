package enterIntoSiteTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClassForLogin.BaseTest;
import enterIntoSiteFunctionality.RegistrationPage;

public class RegistrationPageTest extends BaseTest
{
	private RegistrationPage obj;
	
	@BeforeClass
	public void registerIntoApp()
	{
		obj = new RegistrationPage(driver);
	}
	
	@Test
	public void RegistrationFunctionality() throws Exception
	{
		obj.signUpToApp("ABC", "abc@gmail.com", "Abc@123", "Abc@123");
	}
}
