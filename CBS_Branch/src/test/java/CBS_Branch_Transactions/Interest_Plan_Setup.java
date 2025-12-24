package CBS_Branch_Transactions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Interest_Plan_Setup extends BaseLoginForAllBranchModules
{
	WebDriverWait wait ;
	
	@Test(priority = 1)
	public void interestPlanSetup() throws Exception
	{
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/loaninteresttype");
		Thread.sleep(2000);
		
		System.out.println("----------Interest Plan Setup Module Are Pending---------");
	}
}
