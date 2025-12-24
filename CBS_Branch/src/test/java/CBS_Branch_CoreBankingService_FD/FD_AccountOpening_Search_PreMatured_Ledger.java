package CBS_Branch_CoreBankingService_FD;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CBS_Branch_Transactions.Voucher_Approval;
import LoginBranch.BaseLoginForAllBranchModules;

//need to add tenure dynamically
//Change Compounding period according to Plan (Calculation method)

//Create (Calculation -> Transfer Money -> Accept voucher)
//Search
//Premature (Accept Voucher)
//Ledger
// using All data of 0030011100001 member ID

public class FD_AccountOpening_Search_PreMatured_Ledger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	double systemDepositAmount;
	double systemROIAmount;
	double SystemInterestAmount;
	double systemMaturityAmount;
	String FDAccountNo;
	String AccountDepositVoucherNo;
	String PreMaturedVoucher;

	//Convert to decimal
	DecimalFormat df = new DecimalFormat("###0.00");
	
	//all class Object that will use to run FD_Account_Opening
	Voucher_Approval accept = new Voucher_Approval();
	
	
	@Test(priority = 1)
	public void FD_AccountOpening() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/baccounts/open-fd");
		Thread.sleep(2000);
		
		//Member No 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
		System.out.println("=========================================");
		System.out.println("    Fixed Deposit (FD) Calculation   ");
		System.out.println("=========================================");
		
		//SelectPlanType
		WebElement selectPlanType = driver.findElement(By.id("plan-name"));
		Select selectPlan = new Select(selectPlanType);
		List<WebElement> planTypes = selectPlan.getOptions();
		String SPT = "FD 2YR(24 MONTH-ROI 8%)";
		for (int i = 0; i < planTypes.size(); i++) 
		{
			if(planTypes.get(i).getText().equalsIgnoreCase(SPT))
			{
				planTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//DepositAmount
		WebElement depositAmountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deposit-amount")));
		depositAmountInput.sendKeys("10000");
		//Taking Deposit amount Text
	    String depositAmountText = depositAmountInput.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemDepositAmount = Double.parseDouble(depositAmountText);
        System.out.println("System Deposit Amount = " + df.format(systemDepositAmount));
        Thread.sleep(2000);
        
	    //Taking ROI amount Text
        WebElement roiElement = driver.findElement(By.id("rate-of-interest"));
        String roiText = roiElement.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemROIAmount = Double.parseDouble(roiText);
        System.out.println("System ROI = " + systemROIAmount + "%");
        Thread.sleep(2000);
        
        //Taking Interest Amount        
        WebElement interestAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("interest-amount")));
        String interestAmountText = interestAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim(); // Use replaceAll to correctly remove non-numeric characters except for the decimal
        SystemInterestAmount = Math.round(Double.parseDouble(interestAmountText) * 100.0) / 100.0; // Round to two decimal places
        System.out.println("System Interest Amount = " + df.format(SystemInterestAmount));
        Thread.sleep(2000);
        
	    //Taking Maturity amount Text
        WebElement maturityAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("maturity-amount")));
        String maturityAmountText = maturityAmountElement.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemMaturityAmount = Math.round(Double.parseDouble(maturityAmountText) * 100.0) / 100.0;
        System.out.println("System Maturity Amount = "+ df.format(systemMaturityAmount));
		System.out.println("-----------------------------------------");
		
		//Referred Details
		//Agent ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0026");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2, dependsOnMethods = {"FD_AccountOpening"})
	public void FDcalculations() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
        double principal = systemDepositAmount;       // Deposit Amount (₹)
        double annualRate = systemROIAmount;        // Rate of Interest (% per annum)
        double tenureYears = 2;         // Tenure in years
        int compoundingPerYear = 4;     // Quarterly compounding
//      int compoundingPeriod = 1;   // Compounded yearly  
//      int compoundingPeriod = 2;   // Compounded half yearly
//      int compoundingPeriod = 4;   // Compounded Quarterly
//      int compoundingPeriod = 12;  // Compounded Monthly
//      int compoundingPeriod = 365; // Compounded Daily

        // Convert rate to decimal
        double r = annualRate / 100;

        // Compound Interest Formula: A = P * (1 + r/n)^(n*t)
        double amount = principal * Math.pow((1 + r / compoundingPerYear), compoundingPerYear * tenureYears);

        // Calculate interest earned
        double interest = amount - principal;
        
        System.out.println("------------------------------------------------");
        System.out.println("Total Interest Earned: "+ df.format(interest));
        System.out.println("Maturity Amount: "+ df.format(amount));
        System.out.println("------------------------------------------------");
        
        if(Math.abs(amount - systemMaturityAmount) < 0.01)
	     {
        	if(Math.abs(interest - SystemInterestAmount) < 0.01)
        	{
        		System.out.println("FD Calculation is Right");
            	//Submit application
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
        		WebElement copyFDAccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/p[2]")));
        		FDAccountNo = copyFDAccountNo.getText().replaceAll("Account No: ", "").trim();
        		//System.out.println("FD Account No: "+FDAccountNo);
        		
        		//OK
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
        		Thread.sleep(2000);
        	}
	     }
	     else
	     {
	    	 System.out.println("FD calculations is wrong");
	     }	
        
        System.out.println("=========================================");
	}
	
	@Test(priority = 3)
	public void transferMoneyToFDAC() throws Exception
	{
		wait = new  WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Transfer Account From
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
		//From Account Number
		WebElement chooseAcNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no")));
		Select selectACNO = new Select(chooseAcNo);
		selectACNO.selectByValue("003001200001");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Testing through Automation");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitTransferBtn"))).click();
	    WebElement copyVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]")));
	    AccountDepositVoucherNo = copyVoucherNo.getText().replaceAll("Voucher Created successfully. Voucher No: ", "").trim();
	    //System.out.println("Voucher No: "+voucherNo);
	    Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void acceptTransferVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clickOnVoucher
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(AccountDepositVoucherNo);
		Thread.sleep(2000);
		
		accept.VoucherApprove();
	}
	
	@Test(priority = 5)
	public void SearchAccount() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			
		//direct navigate
		driver.navigate().to("https://demo.techplex.in/View_fd_account");
		Thread.sleep(2000);	
			
		//AccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_no"))).sendKeys(FDAccountNo);
		Thread.sleep(2000);
			
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
			
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(10000);
	}
	
	@Test(priority = 6)
	public void FDPrematurity() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate 
		driver.navigate().to("https://demo.techplex.in/baccounts/fdPreMaturity");
		Thread.sleep(2000);
		
		//FD/Policy Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number"))).sendKeys(FDAccountNo);
		Thread.sleep(2000);
		
		//Fetch Pre-Maturity Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch PreMaturity Details']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Per-Maturity Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='toggle_prematurity_interest']"))).click();
		Thread.sleep(2000);
		
		//Penalty Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='toggle_penalty_rate']"))).click();
		Thread.sleep(2000);
		
		//Transfer To Account
		WebElement selectTransferAC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount_transfer_to_acc")));
		Select selectTAccount = new Select(selectTransferAC);
		selectTAccount.selectByValue("003001200001");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addButton']"))).click();
		WebElement copyPreMatureVoucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/p[2]")));
		PreMaturedVoucher = copyPreMatureVoucher.getText().replaceAll("Voucher No: ", "").trim();
		System.out.println("Pre-Matured Voucher: "+PreMaturedVoucher);
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);	
	}
	
	@Test(priority = 7)
	public void acceptPreMaturedVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clickOnVoucher
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(PreMaturedVoucher);
		Thread.sleep(2000);
		
		accept.VoucherApprove();
	}
	
	@Test(priority = 8)
	public void FDLedger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/fd_ledger");
		Thread.sleep(2000);
		
		//Account NO
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).sendKeys(FDAccountNo);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(8000);
	}
}
