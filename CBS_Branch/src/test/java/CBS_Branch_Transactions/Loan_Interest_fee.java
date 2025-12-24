package CBS_Branch_Transactions;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;
//Pending

public class Loan_Interest_fee extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void LoanInterestFee() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loandisbursefee");
		Thread.sleep(2000);
		
		System.out.println("----------Loan Interest fee Module Are Pending---------");
	}
}
