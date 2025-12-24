package CBS_Branch_Loan_IndividualLoan;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class LoanCycle_Create_ViewApproval extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 0)
	public void ApplyIndivdualLoan() throws Exception
	{
		//direct Navigation 
		driver.navigate().to("https://demo.techplex.in/branch-loan/applyloan");
		Thread.sleep(2000);
					
		//member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member-id"))).click();
		System.out.println("----------Add Member ID Manually for Apply Loan---------");
		Thread.sleep(10000);
					
		//Select Loan Product
		WebElement selectProduct = driver.findElement(By.id("loan_product"));
		Select selectProducts = new Select(selectProduct);
		List<WebElement> products = selectProducts.getOptions();
		String SP = "Vehicle Loan";
		for (int i = 0; i < products.size(); i++) 
		{
			if(products.get(i).getText().equalsIgnoreCase(SP))
			{
				products.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
					
		//Purpose Of Loan
		WebElement LoanPurpose = driver.findElement(By.id("loan-purpose"));
		Select selectPurpose = new Select(LoanPurpose);
		List<WebElement> purpose = selectPurpose.getOptions();
		String PL = "Vehicle Loan";
		for (int i = 0; i < purpose.size(); i++) 
		{
			if(purpose.get(i).getText().equalsIgnoreCase(PL))
			{
				purpose.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
					
		//Interest Rate Type
		WebElement interestRateType = driver.findElement(By.id("interest-rate-type"));
		Select selectInterestType = new Select(interestRateType);
		List<WebElement> Interest = selectInterestType.getOptions();
		String SIT = "Decline";
		for (int i = 0; i < Interest.size(); i++) 
		{
			if(Interest.get(i).getText().equalsIgnoreCase(SIT))
			{
				Interest.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
					
		//Loan Cycle
		WebElement loanCycle = driver.findElement(By.xpath("//div[@id='individual-loan-form']//div[1]//div[2]//div[6]//select[1]"));
		Select selectloanCycle = new Select(loanCycle);
		List<WebElement> Loans = selectloanCycle.getOptions();
		String SLC = "Monthly";
		for (int i = 0; i < Loans.size(); i++) 
		{
			if(Loans.get(i).getText().equalsIgnoreCase(SLC))
			{
				Loans.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
			
		//Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount"))).clear();		
		WebElement LoanAmount = driver.findElement(By.id("amount"));
		LoanAmount.click();
		System.out.println("----------Add Loan Amount----------");
		Thread.sleep(7000);
		String amountText = LoanAmount.getAttribute("value");
		amountText = amountText.replaceAll("[^\\d.]", "");
//		System.out.println("Loan amount = "+amountText);
			
		//InterestRate
		WebElement interestRate = driver.findElement(By.id("interest-rate"));
		interestRate.click();
		Thread.sleep(2000);
		String interestText = interestRate.getAttribute("value");
		interestText = interestText.replaceAll("[^\\d.]"," ");
//		System.out.println("Interest Rate = "+interestText);
			
			
		//Tenure
		WebElement tenure = driver.findElement(By.id("tenure"));
		tenure.click();
		System.out.println("----------Add Tenure----------");
		Thread.sleep(7000);
		String tenureText = tenure.getAttribute("value");
		tenureText = tenureText.replaceAll("[^\\d.]", " ");
//		System.out.println("Tenure Month = "+tenureText);
			
		//frequency
		WebElement Frequency = driver.findElement(By.id("frequency"));
		Select selectFrequency = new Select(Frequency);
		List<WebElement> frequencyOptions = selectFrequency.getOptions();
		String Fr= "Monthly";
		for (int i = 0; i < frequencyOptions.size(); i++) 
		{
			if (frequencyOptions.get(i).getText().equalsIgnoreCase(Fr))
			{
				frequencyOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
			
		//SelectCollector
		WebElement collector = driver.findElement(By.id("collector"));
		Select selectCollector = new Select(collector);
		List<WebElement> collectorOptions = selectCollector.getOptions();
		String C = "Collector 1";
		for (int i = 0; i < collectorOptions.size(); i++) 
		{
			if (collectorOptions.get(i).getText().equalsIgnoreCase(C))
			{
				collectorOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
			
		//Pre-EMIInterest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre-emi-interest"))).sendKeys("7");
		Thread.sleep(2000);
			
		//LSAccount
		//SelectNewAccount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='new-account2']"))).click();
		Thread.sleep(2000);
			
		//ClickOnCheckEMI
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check-emi"))).click();
		Thread.sleep(2000);
			
		
		//Calculation For Flat Interest Rate	
		double loanAmount = Double.parseDouble(amountText); // Loan Amount    
		double annualROI = Double.parseDouble(interestText); // Interest Rate            
		int tenureMonths = Integer.parseInt(tenureText); // Tenure
		
		double monthlyROI = annualROI / 12.0 / 100;
		double numerator = loanAmount * monthlyROI * Math.pow(1 + monthlyROI, tenureMonths);
		double denominator = Math.pow(1 + monthlyROI, tenureMonths) - 1;
		double reducingEMI = numerator / denominator;
		System.out.printf("Reducing ROI EMI: %.2f%n", reducingEMI);
  
		//System Generated EMI
	    WebElement SystemEMI = driver.findElement(By.xpath("//span[contains(text(),'₹')]"));
		String SystemsEMI = SystemEMI.getText().replaceAll("[^\\d.]", "");
	    double systememiValue = Double.parseDouble(SystemsEMI);
		System.out.println("System Generated EMI Value = " + systememiValue);
			
		if(Math.abs(systememiValue - reducingEMI) < 0.01)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("apply-loan-btn"))).click();
			Thread.sleep(2000);
			//ClickOnOk
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
			Thread.sleep(2000);
		}
		else
		{
			System.out.println("Wrong EMI Calculations");
			Thread.sleep(2000);
		}
	}
	
	//Pending
	@Test(priority = 1)
	public void viewApplyLoan() throws Exception
	{
		//Direct Navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/searchviewloan");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mem_id"))).click();
		System.out.println("----------Add Member ID Manually for View Loan----------");
		System.out.println("----------Copy Application ID----------");
		Thread.sleep(10000);
		
		//click On Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-btn"))).click();
		Thread.sleep(8000);
	}

	@Test(priority = 2)
	public void Pending_Loan_For_Approval_Actions() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigation 
		driver.navigate().to("https://demo.techplex.in/branch-loan/branch-showpending");
		Thread.sleep(2000);
		
//		//Member ID
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mem_id"))).click();
//		System.out.println("----------Add Member ID Manually For Pending loan----------");
//		Thread.sleep(10000);
		
		//Application ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("app_id"))).click();
		System.out.println("----------Add Application ID Manually For Pending loan--------");
		Thread.sleep(10000);
		
		//ClickOnSearch
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//Manage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[10]"))).click();
		Thread.sleep(2000);
	}
	
	//Form 1
	@Test(priority = 3)
	public void ApplicationInfo() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);
//		//ScrollDown
//		WebElement scrollDown = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
//		Actions act1 = new Actions(driver);
//		act1.moveToElement(scrollDown).build().perform();
//		Thread.sleep(2000);
		
//		//Next
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Next']"))).click();
//		Thread.sleep(2000);
		
		//Navigate to next Form 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Co-Application']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 2
	@Test(priority = 4)
	public void Co_Application() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//SelectCo-ApplicantType 
		WebElement coApplicantType = driver.findElement(By.id("dropdown"));
		Select selectCoApplicantType = new Select(coApplicantType);
		List<WebElement> applicantsTypes = selectCoApplicantType.getOptions();
		String CAT = "Co-Applicant";
		for (int i = 0; i < applicantsTypes.size(); i++) 
		{
			if(applicantsTypes.get(i).getText().equalsIgnoreCase(CAT))
			{
				applicantsTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//CoApplicantID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co-applicant-id1"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co-applicant-id1"))).sendKeys("003001100012");
		Thread.sleep(2000);
		
		//CoApplicantName
		//Automatically Fetched
		
		//CoApplicantID2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co-applicant-id2"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("co-applicant-id2"))).sendKeys("003001100010");
		Thread.sleep(2000);
		
		//CoAppllicantName2
		//Automatically Fetched
		
		//NoteText
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-text"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-text"))).sendKeys("Automation");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Enter Description']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Enter Description']"))).sendKeys("Form is Tested through Automation");
		Thread.sleep(2000);
		
		//clickOnSave
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Navigate to Next Form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Upload Document']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 3
	@Test(priority = 5)
	public void uploadDocument() throws Exception
	{
		Thread.sleep(5000);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Photo
		WebElement uploadPhoto1 = driver.findElement(By.id("fileInput1"));
		String photo1 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadPhoto1.sendKeys(photo1);
		Thread.sleep(2000);
		
		//Customer
		WebElement customer = driver.findElement(By.id("fileInput2"));
		String customerSign = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		customer.sendKeys(customerSign);
		Thread.sleep(2000);
		
		//Aadhar Card
		WebElement AdharCard = driver.findElement(By.id("fileInput3"));
		String AdharCardKYC = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		AdharCard.sendKeys(AdharCardKYC);
		Thread.sleep(2000);
		
		//Pan Card
		WebElement PanCard = driver.findElement(By.id("fileInput4"));
		String PanCardKYC = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		PanCard.sendKeys(PanCardKYC);
		Thread.sleep(2000);
		
		//PassPort
		WebElement Passport = driver.findElement(By.id("fileInput5"));
		String passportKYC = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		Passport.sendKeys(passportKYC);
		Thread.sleep(2000);
		
		//shop registration
		WebElement shopRegistration = driver.findElement(By.id("fileInput6"));
		String shopRegistrationProof = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		shopRegistration.sendKeys(shopRegistrationProof);
		Thread.sleep(2000);
		
		//GST
		WebElement GST = driver.findElement(By.id("fileInput7"));
		String GSTBusinessKYC = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		GST.sendKeys(GSTBusinessKYC);
		Thread.sleep(2000);
		
		//ITR
		WebElement ITR = driver.findElement(By.id("fileInput8"));
		String ITRFinancial = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		ITR.sendKeys(ITRFinancial);
		Thread.sleep(2000);
		
		//UpdateDocuments
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']"))).click();		
		Thread.sleep(2000);
		
		//SuccessPop-up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//NavigateToNextForm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='PDC/NACH Details'])[1]"))).click();
		Thread.sleep(2000);
		
		//NavigateToNextForm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='PDC/NACH Details'])[1]"))).click();
		Thread.sleep(2000);
	}
	
	//Form 4
	@Test(priority = 6)
	public void PDC_NACH_Details1() throws Exception
	{	
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//PDCDetails
		//AccountHolderName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_account_holder_name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_account_holder_name']"))).sendKeys("Automation QA");
		Thread.sleep(2000);
		
		//TypeOFAC
		WebElement TypeOfAccount = driver.findElement(By.name("pdc_acc_type"));
		Select selectAccount = new Select(TypeOfAccount);
		List<WebElement> accountOptions = selectAccount.getOptions();
		String SA ="Saving Account";
		for (int i = 0; i < accountOptions.size(); i++) 
		{
			if(accountOptions.get(i).getText().equalsIgnoreCase(SA))
			{
				accountOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//BankName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_bank_name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_bank_name']"))).sendKeys("ICICI Automation Bank");
		Thread.sleep(2000);
		
		//BranchName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_branch_name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_branch_name']"))).sendKeys("Satara Road,Pune");
		Thread.sleep(2000);
		
		//AccountNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pdc_account_no"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pdc_account_no"))).sendKeys("987810038128");
		Thread.sleep(2000);
		
		//ChequeNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cheque No']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cheque No']"))).sendKeys("987654");
		Thread.sleep(2000);
		
		//Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_amount']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_amount']"))).sendKeys("80000");
		Thread.sleep(2000);
		
		//OutBy
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Out by']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Out by']"))).sendKeys("80000");
		Thread.sleep(2000);
		
		//Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_date']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pdc_date']"))).sendKeys("2025-08-07");
		Thread.sleep(2000);
		
		//Remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Remarks']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Remarks']"))).sendKeys("OK");
		Thread.sleep(2000);
		
		//SavePDCDetails
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save PDC Details']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//E-NACH Details
		//Account Holder Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='nach_account_holder_name'])[1]"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='nach_account_holder_name'])[1]"))).sendKeys("Selenium Java");
		Thread.sleep(2000);
		
		//Type A/C
		WebElement TypeOfAccount1 = driver.findElement(By.xpath("//select[@name='nach_acc_type']"));
		Select selectAccount1 = new Select(TypeOfAccount1);
		List<WebElement> accountOptions1 = selectAccount1.getOptions();
		String SA1 ="Saving Account";
		for (int i = 0; i < accountOptions1.size(); i++) 
		{
			if(accountOptions1.get(i).getText().equalsIgnoreCase(SA1))
			{
				accountOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Bank Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_bank_name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_bank_name']"))).sendKeys("ICICI Automation Bank");
		Thread.sleep(2000);
		
		//Branch Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_branch_name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_branch_name']"))).sendKeys("Hinjewadi Pune");
		Thread.sleep(2000);
		
		//Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_account_no']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_account_no']"))).sendKeys("988776789876");
		Thread.sleep(2000);
		
		//Periodicity
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Periodicity']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Periodicity']"))).sendKeys("Monthly");
		Thread.sleep(2000);
		
		//Amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_amount']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='nach_amount']"))).sendKeys("25000");
		Thread.sleep(2000);
		
		//Reference
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Reference']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Reference']"))).sendKeys("CBS Bank");
		Thread.sleep(2000);
		
		//UMRN
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='UMRN']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='UMRN']"))).sendKeys("CBSB1234567890001");
		Thread.sleep(2000);
		
		//Note
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Note']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Note']"))).sendKeys("E-NACH is Greate Feature");
		Thread.sleep(2000);
		
		//Save NACH Details 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save NACH Details']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//Navigate to Next Form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Bank Account']"))).click();
		Thread.sleep(2000);	
	}

	//Form 5
	@Test(priority = 8)
	public void Bank_Account() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//NACH_Details
		//AccountHolderName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Account Holder Name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Account Holder Name']"))).sendKeys("Automation NACH Holder");
		Thread.sleep(2000);
		 
		//TypeOfAccount
		WebElement TypeOfAccount1 = driver.findElement(By.xpath("//select[@name='acc_type']"));
		Select selectAccount1 = new Select(TypeOfAccount1);
		List<WebElement> accountOptions1 = selectAccount1.getOptions();
		String TA1 ="Saving Account";
		for (int i = 0; i < accountOptions1.size(); i++) 
		{
			if(accountOptions1.get(i).getText().equalsIgnoreCase(TA1))
			{
				accountOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//BankName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Bank Name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Bank Name']"))).sendKeys("ICICI Automation Bank PVT LTD");
		Thread.sleep(2000);		
		
		//IFSC Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='ifsc' and @placeholder='IFSC Code']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='ifsc' and @placeholder='IFSC Code']"))).sendKeys("ICIC0001302");
		Thread.sleep(2000);
		
		//Branch Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Branch Name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Branch Name']"))).sendKeys("CBS Baner");
		Thread.sleep(2000);
		
		//Account No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Account No']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Account No']"))).sendKeys("998768768987");
		Thread.sleep(2000);
		
		//Banking Since
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Banking Since']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Banking Since']"))).sendKeys("1998");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Description']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Description']"))).sendKeys("Tested Through Automation");
		Thread.sleep(2000);	
		
		//Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']"))).click();
		Thread.sleep(2000);	
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//navigate to next form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Existing Loan']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 6
	@Test(priority = 9)
	public void ExistingLoan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("[Form No. 6]--Check Form Manually");
		Thread.sleep(10000);
		
		//ClickOnConfirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//navigate to next form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Credit Card Details']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 7
	@Test(priority = 10)
	public void CreditCardDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//TypeOfCard
		WebElement typeOfCard= driver.findElement(By.xpath("//select[@name='card_type']"));
		Select selectCard = new Select(typeOfCard);
		List<WebElement> cardOptions = selectCard.getOptions();
		String TOC = "Gold Credit Card";
		for (int i = 0; i < cardOptions.size(); i++) 
		{
			if(cardOptions.get(i).getText().equalsIgnoreCase(TOC))
			{
				cardOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//FinancialInstituationName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Financial Institution Name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Financial Institution Name']"))).sendKeys("CBS Finance PVT.LTD");
		Thread.sleep(2000);
		
		//CardHolderName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Card Holder Name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Card Holder Name']"))).sendKeys("Automation Tester");
		Thread.sleep(2000);
		
		//CardNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Card No']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Card No']"))).sendKeys("4111 1111 1111 1111");
		Thread.sleep(2000);
		
		//CardLimit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Card Limit']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Card Limit']"))).sendKeys("200000");
		Thread.sleep(2000);
		
		//BalanceP/O
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Balance P/O']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Balance P/O']"))).sendKeys("25000");
		Thread.sleep(2000);
		
		//AddEntry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/form[1]/div[3]/button[1]"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//navigate to next form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Reference Details']"))).click();
		Thread.sleep(2000);
		
	}
	
	//form 8
	@Test(priority = 11)
	public void ReferenceDetails() throws Exception
	{	
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Name1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name1"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name1"))).sendKeys("Auto QA Tester");
		Thread.sleep(2000);
		
		//Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='address1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='address1']"))).sendKeys("Pune mumbai delhi 234575");
		Thread.sleep(2000);
		
		//Telephone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='telephone1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='telephone1']"))).sendKeys("020456543");
		Thread.sleep(2000);
		
		//Mobile1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile1_1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile1_1']"))).sendKeys("8765456789");
		Thread.sleep(2000);
		
		//Mobile2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile1_2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile1_2']"))).sendKeys("9876543210");
		Thread.sleep(2000);

		//Landmark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='landmark1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='landmark1']"))).sendKeys("Ring Road");
		Thread.sleep(2000);
		
		//City
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city1']"))).sendKeys("Pune");
		Thread.sleep(2000);
		
		//Pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pincode1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pincode1']"))).sendKeys("987654");
		Thread.sleep(2000);
		
		//state
		WebElement State= driver.findElement(By.xpath("//select[@name='state1']"));
		Select selectState = new Select(State);
		List<WebElement> stateOptions = selectState.getOptions();
		String SS = "Maharashtra";
		for (int i = 0; i < stateOptions.size(); i++) 
		{
			if(stateOptions.get(i).getText().equalsIgnoreCase(SS))
			{
				stateOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Reference2
		//Name1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Name 2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Name 2']"))).sendKeys("Selenium QA Tester");
		Thread.sleep(2000);
				
		//Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='address2']"))).clear();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='address2']"))).sendKeys("delhi 234575");
		Thread.sleep(2000);
				
		//Telephone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='telephone2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='telephone2']"))).sendKeys("020496843");
		Thread.sleep(2000);
				
		//Mobile1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile2_1']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile2_1']"))).sendKeys("8765498789");
		Thread.sleep(2000);
				
		//Mobile2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile2_2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile2_2']"))).sendKeys("9876543210");
		Thread.sleep(2000);

		//Landmark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='landmark2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='landmark2']"))).sendKeys("Wipro Circle Road");
		Thread.sleep(2000);
				
		//City
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='city2']"))).sendKeys("Delhi");
		Thread.sleep(2000);
				
		//Pincode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pincode2']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pincode2']"))).sendKeys("987004");
		Thread.sleep(2000);
				
		//state
		WebElement State1= driver.findElement(By.xpath("//select[@name='state2']"));
		Select selectState1 = new Select(State1);
		List<WebElement> stateOptions1 = selectState1.getOptions();
		String SS1 = "Maharashtra";
		for (int i = 0; i < stateOptions1.size(); i++) 
		{
			if(stateOptions1.get(i).getText().equalsIgnoreCase(SS1))
			{
				stateOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
		Thread.sleep(2000);	
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	
		//NavigateToNextForm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Collateral Details']"))).click();
		Thread.sleep(2000);	
	}
	
	//form 9
	@Test(priority = 12)
	public void collateralDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//CategoryType
		WebElement Categories= driver.findElement(By.xpath("//select[@name='category_type']"));
		Select selectCategory = new Select(Categories);
		List<WebElement> categoryOptions = selectCategory.getOptions();
		String CT = "Residential Property";
		for (int i = 0; i < categoryOptions.size(); i++) 
		{
			if(categoryOptions.get(i).getText().equalsIgnoreCase(CT))
			{
				categoryOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Tittle
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']"))).sendKeys("Residential Property");
		Thread.sleep(2000);	
		
		//PolicyNo/ServeyNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Policy No/Servey No']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Policy No/Servey No']"))).sendKeys("S.No. 128/2B");
		Thread.sleep(2000);
		
		//DOC. Value
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Doc. Value']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Doc. Value']"))).sendKeys("769876");
		Thread.sleep(2000);
		
		//CreatedDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Created Date']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Created Date']"))).sendKeys("2025-08-07");
		Thread.sleep(2000);	
		
		//Expiry/MaturityDate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Expiry/Maturity Date']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Expiry/Maturity Date']"))).sendKeys("2027-08-07");
		Thread.sleep(2000);
		
		//Descrption
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Description']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Description']"))).sendKeys("Recedential Property in Prime Area");
		Thread.sleep(2000);
		
		//UploadDocument'
		WebElement uploadDOC = driver.findElement(By.xpath("//input[@name='document']"));
		String DOCPath ="C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadDOC.sendKeys(DOCPath);
		Thread.sleep(2000);
		
		//AddEntry
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Entry']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//navigate to next Form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Insurance Details']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 10
	@Test(priority = 13)
	public void insuranceDetails() throws Exception
	{	
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//named Insurance 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Named Insured']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Named Insured']"))).sendKeys("Star Insurance");
		Thread.sleep(2000);
		
		//Company
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Company']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Company']"))).sendKeys("Star PVT.LTD");
		Thread.sleep(2000);
		
		//Contact/Agent
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Contact/Agent']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Contact/Agent']"))).sendKeys("John Cena");
		Thread.sleep(2000);
		
		//Agent Phone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Agent Phone']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Agent Phone']"))).sendKeys("9876567898");
		Thread.sleep(2000);
		
		//Deductible amount
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Deductible Amount']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Deductible Amount']"))).sendKeys("15000");
		Thread.sleep(2000);
		
		//Policy No
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Policy Number']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Policy Number']"))).sendKeys("003001100011");
		Thread.sleep(2000);
		
		//Start Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='start_date']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='start_date']"))).sendKeys("2024-08-07");
		Thread.sleep(2000);
		
		//End Date 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='end_date']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='end_date']"))).sendKeys("2028-08-07");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Description']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Description']"))).sendKeys("Premium Health Insurance");
		Thread.sleep(2000);
		
		//UploadDocument
		WebElement uploadDOC1 = driver.findElement(By.xpath("//input[@id='document_file']"));
		String DOCPath1 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadDOC1.sendKeys(DOCPath1);
		Thread.sleep(2000);
		
		//Submit
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Insurance Details']"))).click();
		Thread.sleep(2000);
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//navigate to next Form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Vehicle Details']"))).click();
		Thread.sleep(2000);
	}
	
	//Pending
	//Form 11
	@Test(priority = 14)
	public void vehicalDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Form No 11 is Pending");
		
//		//Vehicle Type 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_type']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_type']"))).sendKeys("SUV");
//		Thread.sleep(2000);
//		
//		//Model
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='model']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='model']"))).sendKeys("XUV700");
//		Thread.sleep(2000);
//		
//		//Color
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='color']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='color']"))).sendKeys("White");
//		Thread.sleep(2000);
//		
//		//Engine No
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='engine_no']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='engine_no']"))).sendKeys("SDU875678");
//		Thread.sleep(2000);
//		
//		//Vehicle Value
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_value']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_value']"))).sendKeys("2200000");
//		Thread.sleep(2000);
//		
//		//Reg No
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='reg_no']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='reg_no']"))).sendKeys("REG12345678");
//		Thread.sleep(2000);
//		
//		//Style
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='style']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='style']"))).sendKeys("SUV4X4");
//		Thread.sleep(2000);
//		
//		//Mfg.Year
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mfg_year']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mfg_year']"))).sendKeys("2024");
//		Thread.sleep(2000);
//		
//		//Chassis No
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='chassis_no']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='chassis_no']"))).sendKeys("CHA12345678");
//		Thread.sleep(2000);
//		
//		//Upload Document
//		WebElement uploadDocument2 = driver.findElement(By.xpath("(//input[@name='vehicle_document'])[1]"));
//		String UDPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
//		uploadDocument2.sendKeys(UDPath);
//		Thread.sleep(2000);
//		
//		//Description
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_description']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_description']"))).sendKeys("Premium SUV with Full Power");
//		Thread.sleep(2000);
//		
//		//Vehicle Insurance Details
//		//Name Insurance
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name_insuranced']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name_insuranced']"))).sendKeys("Bajaj Car Insurance");
//		Thread.sleep(2000);
//		
//		//Company
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='company']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='company']"))).sendKeys("Bajaj");
//		Thread.sleep(2000);
//		
//		//Contact/Agent
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='contact_agent']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='contact_agent']"))).sendKeys("998877");
//		Thread.sleep(2000);
//		
//		//Agent Phone
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='agent_phone']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='agent_phone']"))).sendKeys("9898989898");
//		Thread.sleep(2000);
//		
//		//Policy No
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='policy_no']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='policy_no']"))).sendKeys("003001200001");
//		Thread.sleep(2000);
//		
//		//Start Date 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='start_date']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='start_date']"))).sendKeys("2024-08-07");
//		Thread.sleep(2000);
//		
//		//End Date
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='end_date']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='end_date']"))).sendKeys("2028-08-07");
//		Thread.sleep(2000);
//		
//		//Upload Document
//		WebElement uploadDoc3 = driver.findElement(By.xpath("//input[@name='vehicle_insu_document']"));
//		String DOCPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
//		uploadDoc3.sendKeys(DOCPath);
//		Thread.sleep(2000);
//		
//		//Descriptions
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_insu_description']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='vehicle_insu_description']"))).sendKeys("Trusted Insurance Company");
//		Thread.sleep(2000);
//		
//		//Submit
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Vehicle Details']"))).click();
//		Thread.sleep(2000);
		
		//Navigate to Next Form 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='CIBIL Verification' and @data-step='12']\r\n"))).click();
		Thread.sleep(2000);
	}
	
	//Form 12
	//Pending
	@Test(priority = 15)
	public void CIBILVerfication() throws Exception
	{		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Form No 12 is Pending");
		
//		//Cibil Report
//		//Cibil Score
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cibil Score']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cibil Score']"))).sendKeys("850");
//		Thread.sleep(2000);
//		
//		//Cibil Description
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cibil Description']"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Cibil Description']"))).sendKeys("Excelent Cibil");
//		Thread.sleep(2000);
//		
//		//Upload Document
//		WebElement uploadDoc4 = driver.findElement(By.xpath("//input[@id='document_file']"));
//		String DOCPath4 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
//		uploadDoc4.sendKeys(DOCPath4);
//		Thread.sleep(2000);
//		
//		//Upload
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Upload']"))).click();
//		Thread.sleep(2000);
//		
//		//Are You Sure Pop-up
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Upload it!']"))).click();
//		Thread.sleep(2000);
//		
//		//ClickOnOk
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
		
		//Navigate to Next Form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Address Verification']"))).click();
		Thread.sleep(2000);
	}
		
	//Form 13
	@Test(priority = 17)
	public void AddressVerification() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ScrollDown
		WebElement scrollDown5 = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
		Actions act5 = new Actions(driver);
		act5.moveToElement(scrollDown5).build().perform();
		Thread.sleep(2000);
		
		//KYCDocumnetUpload
		//Aadhar Card 
		WebElement uploadAdhar = driver.findElement(By.xpath("//input[@id='aadhaar_card']"));
		String DOCPathA = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadAdhar.sendKeys(DOCPathA);
		Thread.sleep(2000);
		
		//Aadhar Card 
		WebElement uploadPAN = driver.findElement(By.xpath("//input[@id='pan_card']"));
		String DOCPathP = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadPAN.sendKeys(DOCPathP);
		Thread.sleep(2000);
		
		//Passport 
		WebElement uploadPassport = driver.findElement(By.xpath("//input[@id='passport']"));
		String DOCPathPP = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadPassport.sendKeys(DOCPathPP);
		Thread.sleep(2000);
		
		//Need To Change EveryTime When Run This Script
		//Applicant Type
		WebElement applicantType = driver.findElement(By.name("applicant_type"));
		Select selectTypes = new Select(applicantType);
		List<WebElement> Type1 = selectTypes.getOptions();
		String AT = "Applicant: ASTA BLACK";
		for (int i = 0; i < Type1.size(); i++) 
		{
			if(Type1.get(i).getText().equalsIgnoreCase(AT))
			{
				Type1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Verification Status
		WebElement verificationStatus = driver.findElement(By.xpath("//select[@name='verification_status']"));
		Select selectStatus = new Select(verificationStatus);
		List<WebElement> status1 = selectStatus.getOptions();
		String SS = "Approved";
		for (int i = 0; i < status1.size(); i++) 
		{
			if(status1.get(i).getText().equalsIgnoreCase(SS))
			{
				status1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Document Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='document_description']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='document_description']"))).sendKeys("Verified KYC Details");
		Thread.sleep(2000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']"))).click();
		Thread.sleep(2000);
		
		//Navigate to next Form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Document Verification']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 14
	@Test(priority = 18)
	public void DocumentVerification() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//ImageUpload
		WebElement ImageUpload = driver.findElement(By.xpath("//input[@id='fileInput2']"));
		String imagePath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		ImageUpload.sendKeys(imagePath);
		Thread.sleep(2000);
		
		//Sign Upload
		WebElement SignUpload = driver.findElement(By.xpath("//input[@id='fileInput3']"));
		String signPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		SignUpload.sendKeys(signPath);
		Thread.sleep(2000);
		
		//Business Proof Document
		WebElement BusinessProof = driver.findElement(By.xpath("//input[@id='fileInput4']"));
		String businessPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		BusinessProof.sendKeys(businessPath);
		Thread.sleep(2000);
		
		//Business KYC
		WebElement businessKYC = driver.findElement(By.xpath("//input[@id='fileInput5']"));
		String KYCPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		businessKYC.sendKeys(KYCPath);
		Thread.sleep(2000);
		
		//FinancialITR
		WebElement FinancialITR = driver.findElement(By.xpath("//input[@id='fileInput6']"));
		String ITRPath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		FinancialITR.sendKeys(ITRPath);
		Thread.sleep(2000);
		
		//DocumentDescription
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='document_description']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='document_description']"))).sendKeys("document uploaded through automation testing");
		Thread.sleep(2000);
		
		//AddNote
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Note']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Note']"))).sendKeys("Automation testing is Better than Manual");
		Thread.sleep(2000);
		
		//ClickOnConfirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']"))).click();
		Thread.sleep(2000);	
		
		//ClickOnOk
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		//NavigateToNextForm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Print Documents']"))).click();
		Thread.sleep(2000);
	}
	
	//Pending Form
	//Form 15
	@Test(priority = 19)
	public void printDouments() throws InterruptedException
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Form No 15 is Pending");
		
//		//Add Note 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Add Note']"))).click();
//		Thread.sleep(2000);
//		
//		//Select Product
//		WebElement selectProduct = driver.findElement(By.xpath("//select[@name='select_product']"));
//		Select selectProducts = new Select(selectProduct);
//		List<WebElement> products = selectProducts.getOptions();
//		String SP = "Application Info";
//		for (int i = 0; i < products.size(); i++) 
//		{
//			if(products.get(i).getText().equalsIgnoreCase(SP))
//			{
//				products.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(2000);
//		
//		//Enter Note
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/input[1]"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/input[1]"))).sendKeys("OK");
//		Thread.sleep(2000);
//		
//		//Descriptions
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[4]/input[1]"))).clear();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[4]/input[1]"))).sendKeys("OK, Thanks..!");
//		Thread.sleep(2000);
		
		//ClickOnNextForm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Payment Setting']"))).click();
		Thread.sleep(2000);	
	}
	
	//form 16
	@Test(priority = 20)
	public void PaymentSetting() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		System.out.println("Form NO 16 is Pending");
//		//Mode Of Payment
//		//Cash
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Cash']"))).click();
//		Thread.sleep(2000);
//		
//		//ClickOnConfirm
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']"))).click();
//		Thread.sleep(2000);
		
		//ClickOnNextForm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add Product']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 17
	@Test(priority = 21)
	public void addProductDetails() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//SelectVendor
		WebElement vendor = driver.findElement(By.xpath("//select[@name='vendor']"));
		Select seletVendor = new Select(vendor);
		List<WebElement> vendorOptions = seletVendor.getOptions();
		String SV="Dr Pawan Badgujar";
		for (int i = 0; i < vendorOptions.size(); i++) 
		{
			if(vendorOptions.get(i).getText().equalsIgnoreCase(SV))
			{
				vendorOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//SelectCategory
		WebElement Categories1= driver.findElement(By.xpath("//select[@name='category_name']"));
		Select selectCategory1 = new Select(Categories1);
		List<WebElement> categoryOptions1 = selectCategory1.getOptions();
		String ST = "New_Category";
		for (int i = 0; i < categoryOptions1.size(); i++) 
		{
			if(categoryOptions1.get(i).getText().equalsIgnoreCase(ST))
			{
				categoryOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//ProductName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Product Name']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Product Name']"))).sendKeys("Car Loan");
		Thread.sleep(2000);
			
		//ProductModel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Product Model']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Product Model']"))).sendKeys("Maruti Suzuki Swift ZXi 2024");
		Thread.sleep(2000);
		
		//ProductCost
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='product_cost']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='product_cost']"))).sendKeys("750000");
		Thread.sleep(2000);
		
		//MarginMoney
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='margin_money']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='margin_money']"))).sendKeys("175000");
		Thread.sleep(2000);
		
		//FinanceAmount
		//Auto Fetch
		
		//DeductionByCompany
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Deduction by Company']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Deduction by Company']"))).sendKeys("175000");
		Thread.sleep(2000);
		
		//TotalAmountCollectedFromCustomer
		//Auto Fetch
		
		//FinalDisbursmentAmount
		//Auto Fetch (After Adding Advance EMI)
		
		//NetLoanAmount
		//Auto Fetch (After Adding Advance EMI)
		
		//GST
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gst']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gst']"))).sendKeys("8");
		Thread.sleep(2000);
		
		//ProductCategory
		WebElement Categories2= driver.findElement(By.xpath("//select[@name='product_category']"));
		Select selectCategory2 = new Select(Categories2);
		List<WebElement> categoryOptions2 = selectCategory2.getOptions();
		String PT = "ABCD";
		for (int i = 0; i < categoryOptions2.size(); i++) 
		{
			if(categoryOptions2.get(i).getText().equalsIgnoreCase(PT))
			{
				categoryOptions2.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//ProductBrand
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Product Brand']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Product Brand']"))).sendKeys("Maruti Suzuki");
		Thread.sleep(2000);
		
		//SchemeCode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Scheme Code']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Scheme Code']"))).sendKeys("SCH-10012");
		Thread.sleep(2000);
		
		//ProcessingFee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='processing_fees']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='processing_fees']"))).sendKeys("10000");
		Thread.sleep(2000);
		
		//AdvanceEMI
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='advance_emi']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='advance_emi']"))).sendKeys("25100");
		Thread.sleep(2000);
		
		//DelarSubvention
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='delar_subvention']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='delar_subvention']"))).sendKeys("1.5");
		Thread.sleep(2000);
		
		//OtherChargesIfAny
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='other_charges_ifany']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='other_charges_ifany']"))).sendKeys("2500");
		Thread.sleep(2000);
		
		//ExtendedDownpayment
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='extended_warranty']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='extended_warranty']"))).sendKeys("5");
		Thread.sleep(2000);
		
		//InsuranceDownpayment
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='insurance']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='insurance']"))).sendKeys("15000");
		Thread.sleep(2000);
		
		//SumOFDeduction
		//Auto Fetch
		
		//GSTForProcessingFee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gstfor_processing_fees']"))).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gstfor_processing_fees']"))).sendKeys("18");
		Thread.sleep(2000);
		
		//ClickOnSend
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Send for Approval to Admin']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	//Approve Loan From Admin
	@Test(priority = 22, alwaysRun = true)
	public void NavigateToAdmin() throws Exception
	{
		//clear session cookies and local storage
		driver.manage().deleteAllCookies(); 
	    ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
	    ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
	    Thread.sleep(2000);
	    
		//Navigation
	    FileInputStream fis3 = new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\configAdmin.properties");
	    Properties pro3 = new Properties();
	    pro3.load(fis3);
		Thread.sleep(2000);
		driver.navigate().to(pro3.getProperty("URL"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(pro3.getProperty("USERNAME"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(pro3.getProperty("PASSWORD"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']"))).click();
		Thread.sleep(2000);
	}
	
	//Form 18
	@Test(priority = 23)
	public void ApprovePendingLoan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Loans -> Reports ->
		//Pending Loans For Approval
		driver.navigate().to("https://demo.techplex.in/admin-loan/showpending");
		Thread.sleep(2000);	
		
		//Member ID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mem_id"))).click();
		System.out.println("----------Add Member ID Manually For Approve Pending Loan----------");
		Thread.sleep(10000);
		
		//click On Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);	
		
		//Manage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[12]"))).click();
		System.out.println("----------Check Form Manually----------");
		Thread.sleep(10000);
		
		//click on Add Product
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add Product']//i[@class='las la-check tick-icon']"))).click();
		Thread.sleep(2000);
		
		//Proceed to Approve
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("approveloan"))).click();
		Thread.sleep(2000);
		
		//Loan Product Summary
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[4]"))).sendKeys("Testing Loan Through automation");
		Thread.sleep(2000);
		
		//Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("admin_remark"))).sendKeys("Approved");
		Thread.sleep(2000);
		
		//Approve
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'][normalize-space()='Approve'])[1]"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 24)
	public void LoginInToBranchAgain() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clear session cookies and local storage
		driver.manage().deleteAllCookies(); 
	    ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
	    ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
	    Thread.sleep(2000);
	    
		//Navigation
	    FileInputStream fis4 = new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\configBranch.properties");
	    Properties pro4 = new Properties();
	    pro4.load(fis4);
		Thread.sleep(2000);
		driver.navigate().to(pro4.getProperty("URL"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(pro4.getProperty("USERNAME"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(pro4.getProperty("PASSWORD"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']"))).click();
		Thread.sleep(2000);
	}
	
	//Pending
	@Test(priority = 25)
	public void disburseLoan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/branch-loan/viewdisburseloan");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//Disburse Loan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]/button[1]"))).click();
		Thread.sleep(2000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Confirm']"))).click();
		System.out.println("----------Copy Voucher No Manually----------");
		Thread.sleep(8000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	//Approve Voucher 
	public void approveVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).click();
		System.out.println("------------Add Voucher No Manually------------");
		Thread.sleep(7000);
		
		//Search Transaction 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search Transaction']"))).click();
		Thread.sleep(2000);
		
		//Action (Approve Voucher)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Voucher']"))).click();
		Thread.sleep(2000);
		
		//Approve Transaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Transaction']"))).click();
		Thread.sleep(2000);
		
		//Confirm Pop-up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Approve']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);	
	}
}