package CBS_Branch_CoreBankingService_CurrentAccount;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Fund_Deposit;
import LoginBranch.BaseLoginForAllBranchModules;

//Account Open
//View Account 
//fund deposit
//view Ledger
//Closed Account

public class CAOpening_View_Ledger_FLOW extends BaseLoginForAllBranchModules
{
	WebDriver driver;
	WebDriverWait wait;
	
	//all class Object that will use to run Overall CA Flow
	Current_Account_Opening newAccountOpen = new Current_Account_Opening();
	Search_Current_Account searchAc = new Search_Current_Account();
	Fund_Deposit deposit = new Fund_Deposit();
	Current_Ledger ledgerView = new Current_Ledger();
	Clouser_Current_Account CAClosed = new Clouser_Current_Account();
	
	
	@Test(priority = 1)
	public void currentAccountOpening() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		newAccountOpen.currentAccountOpening();
	}
	
	
	
	//View CA [CBS Current Account -> Search_Current_Account]
	@Test(priority = 2)
	public void ViewAccount() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		searchAc.Search_Current_AC();
	}
	
	
 
	//Fund deposit [Transaction -> Fund Deposit]
	//Include Voucher approval & And balance check Calculation
	@Test(priority = 3)
	public void addFund() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		deposit.fundDeposit();
		deposit.approveVoucher();
		deposit.fundDeposit_ForBalanceCheckAfterDeposit();	
	}
	
	
	// Current Account Ledger [CBS Current Account -> Current_Ledger]
	@Test(priority = 4)
	public void viewCALedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		ledgerView.currentLedger();
	}
	
	
	
	// Account Closed [CBS Current Account -> Closure_Current_Account]
	@Test(priority = 5)
	public void closedAccount() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		CAClosed.ClouserCurrentAccount();
		CAClosed.checkAccountStatus();
	}
}
