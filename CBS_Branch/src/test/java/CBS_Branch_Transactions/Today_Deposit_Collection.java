package CBS_Branch_Transactions;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Pending

public class Today_Deposit_Collection extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void todayDepositCollection() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct navigation
		driver.navigate().to("https://demo.techplex.in/transaction/depositerecieve");
		Thread.sleep(2000);
		
		System.out.println("-----today Deposit Collection module are Pending-----");
	}
}
