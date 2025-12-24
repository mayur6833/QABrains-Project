package CBS_Branch_CoreBankingService_SavingAccount;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import CBS_Branch_Transactions.Fund_Deposit;
import LoginBranch.BaseLoginForAllBranchModules;

//Working
//Change credentials accordingly 
//drop down 
//(003001100023)

//Steps -> 
//1. Create Account
//2. View Account
//3. Check Ledger (First Add Fund & Accept voucher)

public class SB_OpeningANDSearchANDLedger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	SB_AccountOpening newAccountOpening = new SB_AccountOpening();
	Search_SB_Accounts searchSBAccount = new Search_SB_Accounts();
	Fund_Deposit deposit = new Fund_Deposit();
	SB_Ledger ledger = new SB_Ledger();
	Closure_SB_Accounts closeAC = new Closure_SB_Accounts();
	
	
	//Create Account [SavingAccount -> SB_AccountOpening]
	@Test(priority = 1)
	public void createSBAccount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		newAccountOpening.SB_Account();
	}
	
	
	
	//Search AC [SavingAccount -> Search_SB_Accounts]
	@Test(priority = 2, dependsOnMethods = {"createSBAccount"})
	public void searchSBAccount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		searchSBAccount.Search_SBAccount();
	}
	
	
	
	//For Ledger View/Process
	//Fund Deposit [Transactions -> Fund_Deposit]
	@Test(priority = 3, dependsOnMethods = {"searchSBAccount"})
	public void addFund() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		deposit.fundDeposit();
		deposit.approveVoucher();
	}

	
	
	//View AC Ledger [SavingAccount -> SB_Ledger]
	@Test(priority = 4, dependsOnMethods = {"addFund"})
	public void viewSBLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ledger.checkSBLedger();
	}
	
	
	
	//Closed AC [SavingAccount -> Closure_SB_Accounts]
	@Test(priority = 5, dependsOnMethods = "viewSBLedger")
	public void CloseSBAccount() throws Exception
	{	
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		closeAC.Closure_SB();
		closeAC.checkAccountStatus();
	}		
}
