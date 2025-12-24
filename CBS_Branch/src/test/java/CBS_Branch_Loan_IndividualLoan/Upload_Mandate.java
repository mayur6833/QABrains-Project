package CBS_Branch_Loan_IndividualLoan;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Upload_Mandate extends BaseLoginForAllBranchModules
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void uploadMandate()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Upload Mandate Module are pending");
	}
}
