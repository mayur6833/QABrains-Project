package CBS_Admin_BankingMaster;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loginAdmin.baseLoginForAllAdminModules;

//Pending
public class Deposit_TDS_Parameter extends baseLoginForAllAdminModules
{
	WebDriverWait wait;
	
	@BeforeTest
	public void depositTDSParameterNavigation()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/depositTds-transfer");
	}
	
	@Test(priority = 1)
	public void depositTDSParameter()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Deposit_TDS_Parameter is not working");
	}
}
