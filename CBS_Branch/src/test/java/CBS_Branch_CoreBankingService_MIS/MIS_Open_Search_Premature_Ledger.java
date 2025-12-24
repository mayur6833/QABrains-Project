package CBS_Branch_CoreBankingService_MIS;

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

// Create (calculation -> Transfer -> Voucher accept)
// Search 
// premature (voucher accept)
// ledger

public class MIS_Open_Search_Premature_Ledger extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	double systemDepositAmount;
	double systemROI;
	double systemMaturityAmount;
	double systemTotalInterest;
	double monthlyInterest;
	String MISAccountNo;
	String MISVoucherNo;
	String preMaturedVoucherNo;
	
	
	//Convert To Decimal
	DecimalFormat df = new DecimalFormat("###00.00");
	
	//all class Object that will use to run MIS_AccountOpening
	Voucher_Approval accept = new Voucher_Approval();
	
	@Test(priority = 1)
	public void MISAccountOpening() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Navigate to Account Opening
		driver.navigate().to("https://demo.techplex.in/baccounts/open-mis");
		Thread.sleep(2000);
		
		//MemberNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-no"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
		System.out.println("=========================================");
		System.out.println("    Monthly Income Scheme (MIS) Calculation   ");
		System.out.println("=========================================");
		
		//SelectPlanType
		WebElement selectPlanType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-name")));
		Select selectPlan = new Select(selectPlanType);
		List<WebElement> planTypes = selectPlan.getOptions();
		String SPT = "MIS 2YR(24 MONTH-ROI 7%)";
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
		depositAmountInput.sendKeys("100000");
		//Taking Deposit amount Text
	    String depositAmountText = depositAmountInput.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemDepositAmount = Double.parseDouble(depositAmountText);
        System.out.println("System Deposit Amount: "+ df.format(systemDepositAmount));
        Thread.sleep(2000);
        
        //Rate of interest
        WebElement roiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rate-of-interest")));
        String roiText = roiElement.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemROI = Math.round(Double.parseDouble(roiText) * 100.0) / 100.0;
        System.out.println("System ROI: "+ df.format(systemROI));
        Thread.sleep(2000);
        
        //Maturity Amount
        WebElement maturityAmountElement = driver.findElement(By.id("maturity-amount"));
        String maturityAmountText = maturityAmountElement.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemMaturityAmount = Math.round(Double.parseDouble(maturityAmountText) * 100.0) / 100.0;
        System.out.println("System Maturity Amount: " + df.format(systemMaturityAmount));
        Thread.sleep(2000);
        
        //total Interest Amount
        WebElement totalInterestAmount = driver.findElement(By.id("interest-amount"));
        String  totalInterestAmountText =  totalInterestAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        systemTotalInterest = Math.round(Double.parseDouble(totalInterestAmountText) * 100.0) / 100.0;
        System.out.println("System Total Interest Amount: "+ df.format(systemTotalInterest));
        Thread.sleep(2000);
        
        //Interest amount(monthly)
        WebElement interestMonthlyAmount = driver.findElement(By.id("interest-amount-month"));
        String interestMonthlyAmountText = interestMonthlyAmount.getAttribute("value").replaceAll("[^\\d.]", "").trim();
        monthlyInterest = Math.round(Double.parseDouble(interestMonthlyAmountText) * 100.0) / 100.0;
        System.out.println("System Monthly Interest Amount: "+ df.format(monthlyInterest));
        Thread.sleep(2000);
				
		//Referred Details
		//Agent ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reffered-by"))).sendKeys("SWMT-A0037");
		Thread.sleep(2000);
		
		System.out.println("=========================================");
	}
	

	@Test(priority = 2, dependsOnMethods = {"MISAccountOpening"})
	public void MISCalculation() throws Exception
	{
		double depositAmount = systemDepositAmount;  // Principal amount
        double roi = systemROI; // Annual rate of interest (7%)
        int tenure = 2;           // Time in years

        // Calculate Simple Interest (SI)
        double interestAmount = (depositAmount * roi * tenure) / 100;

        // Monthly interest (divide total interest by number of months in 2 years)
        double monthlyIncome = interestAmount / (12 * tenure);

        // Output the result
        System.out.println();
        System.out.println("----Simple Interest----");
        System.out.println("Annual Interest Rate: "+ df.format(roi)); // Display the rate as 7%
        System.out.println("Monthly Income: "+ df.format(monthlyIncome));
        System.out.println("=========================================");
        System.out.println();
        
        if(Math.abs(monthlyIncome - monthlyInterest) < 0.01)
        {
        	System.out.println("MIS Calculations is right");        	
    		//Submit
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Application']"))).click();
    		WebElement copyAccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='mb-3 large-text'])[1]")));
    		MISAccountNo = copyAccountNo.getText().replaceAll("Account No: ", "").trim();
    		//System.out.println("MIS Account No: "+MISAccountNo);
    		Thread.sleep(2000);
    				
    		//OK
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
    		Thread.sleep(2000);
        }
        else
        {
        	System.out.println("Wrong MIS Calculations");
        }
	}
	
	@Test(priority = 3, dependsOnMethods = {"MISAccountOpening"})
	public void transferMoneyToFDAC() throws Exception
	{
		wait = new  WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Transfer Account From
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).sendKeys("003001100001");
		Thread.sleep(2000);
		
		//From Account Number
		WebElement transferAccountNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no")));
		Select selectAc = new Select(transferAccountNo);
		selectAc.selectByValue("003001200001");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("Testing through Automation");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitTransferBtn"))).click();
		WebElement copyMISVoucher = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='swal2-html-container'])[1]")));
		MISVoucherNo = copyMISVoucher.getText().replaceAll("Voucher Created successfully. Voucher No: ", "").trim();
		//System.out.println("MIS Voucher Number: "+MISVoucherNo);
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4, dependsOnMethods = {"MISAccountOpening"})
	public void acceptTransferVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(MISVoucherNo);
		Thread.sleep(2000);
		
		accept.VoucherApprove();
	}
	
	@Test(priority = 5)
	public void SearchMIS() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Navigate to View MIS Account
		driver.navigate().to("https://demo.techplex.in/baccounts/viewmis");
		Thread.sleep(2000);
		
		//Search Type
		WebElement searchType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='search_type']")));
		Select selectSearchType = new Select(searchType);
		selectSearchType.selectByValue("account_no");
		
			
		//Search Content
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter value']"))).sendKeys(MISAccountNo);
		Thread.sleep(2000);
			
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-submit']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(7000);
		
	}
	
	@Test(priority = 6)
	public void PreMaturity() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/mispre");
		Thread.sleep(2000);
		
		//Policy No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("policy-number"))).sendKeys(MISAccountNo);
		Thread.sleep(2000);
		
		//Fetch PreMaturity Details 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='Fetch PreMaturity Details']"))).click();
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Transfer Account
		WebElement transferAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='amount_transfer_to_acc']")));
		Select selectAccount = new Select(transferAccount);
		selectAccount.selectByValue("003001200001");
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='addButton']"))).click();
		WebElement copyVoucherNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='mb-3 large-text'])[1]")));
		preMaturedVoucherNo = copyVoucherNo.getText().replaceAll("Voucher No: ", "").trim();
		//System.out.println(preMaturedVoucherNo);
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='OK'])[1]"))).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 7)
	public void acceptPreMaturityVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Automatically fetch Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).sendKeys(preMaturedVoucherNo);
		Thread.sleep(2000);
		
		accept.VoucherApprove();
	}
	
	@Test(priority = 8)
	public void MISledger() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Account Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acc_no"))).sendKeys(MISAccountNo);
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(7000);
	}
}

