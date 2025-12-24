package CBS_Admin_BankingMaster;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loginAdmin.baseLoginForAllAdminModules;

public class OD_Account_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@BeforeTest
	public void ODAccountParameterNavigation()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/oddAccount-parameter");
	}
	
	@Test(priority = 1)
	public void ODAccountParameter()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("OD_Account_Parameter is not working");
	}
}
