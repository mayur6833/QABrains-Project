package CBS_Branch_Loan_GoldLoan;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//AllDONE
//Change Member ID on every Run
//viewGoldLoanApplication -> Manage button Xpath always change
//disbursmentOfApproveLoan -> Change Member name according to customer
//Copy voucher number Manually

//Pending from Dev Side


public class Create_NewLoan_ViewGoldLoan_Disbursment extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void CreateGoldLoan_Actions() throws Exception 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigate
		driver.navigate().to("https://demo.techplex.in/branch-loan/showgoldloanapply");
		Thread.sleep(2000);

		//MemberID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='member_id']"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//Select Payment Basis
		WebElement paymentBasis1 = driver.findElement(By.id("payment_basis"));
		Select selectPaymentBasis1 = new Select(paymentBasis1);
		List<WebElement> payment1 = selectPaymentBasis1.getOptions();
		String PB1 = "Interest";
		for (int i = 0; i < payment1.size(); i++) 
		{
			if(payment1.get(i).getText().equalsIgnoreCase(PB1))
			{
				payment1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		//ROI set based on Scheme
		//Select Scheme
		WebElement scheme = driver.findElement(By.id("scheme"));
		Select selectScheme = new Select(scheme);
		List<WebElement> schemes = selectScheme.getOptions();
		String SS = "New Gold Scheme";
		for (int i = 0; i < schemes.size(); i++) 
		{
			if(schemes.get(i).getText().equalsIgnoreCase(SS))
			{
				schemes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//tenure 
		WebElement Tenure = driver.findElement(By.id("tenure"));
		Tenure.click();
		Thread.sleep(2000);
		String tenureText = Tenure.getAttribute("value");
		tenureText = tenureText.replaceAll("[^\\d.]"," ");
		System.out.println("Loan Tenure = "+ tenureText);
		Thread.sleep(2000);
		
		//Interest Rate
		WebElement interestRate = driver.findElement(By.xpath("//input[@id='interest_rate']"));
		interestRate.click();
		String interestRateText = interestRate.getAttribute("value");
		interestRateText = interestRateText.replaceAll("[^\\d.]", " ");
		System.out.println("Interest Rate = "+interestRateText);
		Thread.sleep(2000);
		
		//frequency
		WebElement frequency = driver.findElement(By.id("installment_frequency"));
		Select selectFrequency = new Select(frequency);
		List<WebElement> frequencyOptions = selectFrequency.getOptions();
		String SF = "Monthly";
		for (int i = 0; i < frequencyOptions.size(); i++) 
		{
			if(frequencyOptions.get(i).getText().equalsIgnoreCase(SF))
			{
				frequencyOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Loan Date
		//Auto Fetch
		
		//Loan Amount;
		WebElement loanAmount = driver.findElement(By.id("loan_amount"));
		loanAmount.sendKeys("300000");
		String loanAmountText = loanAmount.getAttribute("value");
		loanAmountText = loanAmountText.replaceAll("[^\\d.]"," ");
		System.out.println("Loan Amount = "+loanAmountText);
		Thread.sleep(2000);
		
		//Interest Type
		WebElement interestType = driver.findElement(By.id("interest_type"));
		Select selectInterestType = new Select(interestType);
		List<WebElement> interestTypes = selectInterestType.getOptions();
		String IT = "Flat";
		for (int i = 0; i < interestTypes.size(); i++) 
		{
			if(interestTypes.get(i).getText().equalsIgnoreCase(IT))
			{
				interestTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
	    //ShowEMI
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calculate_emi_btn"))).click();
	    Thread.sleep(2000);
      
        //clickOnOK
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
        Thread.sleep(3000);
        
        //getTextThatSystemGenratedEMI
        WebElement SystemEMI = driver.findElement(By.id("calculate_emi_btn"));
        String ShowEMIText = SystemEMI.getText();
        ShowEMIText = ShowEMIText.replaceAll("[^\\d.]"," ").trim();
        double systememiValue = Double.parseDouble(ShowEMIText);
        System.out.println("System Generated EMI For Flat ROI = "+ShowEMIText);
        
        //Calculations for Flat ROI
        double LoanAmount = Double.parseDouble(loanAmountText);
        double LoanTenure = Double.parseDouble(tenureText);
        double loanROI = Double.parseDouble(interestRateText);
        
        double tenureYears = LoanTenure / 12.0;
		double totalInterest = (LoanAmount * loanROI * tenureYears) / 100;
		double totalPayment = LoanAmount + totalInterest;
		double flatEMIForGOLDLoan = totalPayment / LoanTenure;
	    System.out.printf("Flat Actual ROI EMI FOR Gold Loan: %.2f%n", flatEMIForGOLDLoan);
	    
	    if(Math.abs(systememiValue - flatEMIForGOLDLoan) < 0.01)
	    {
	    	//Submit
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit']"))).click();
	        Thread.sleep(4000);
	        //OK
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		    Thread.sleep(2000);
	    }
	    else
	    {
	    	System.out.println("Wrong EMI Calculations for Flat Interest Rate ");
	    }		
	}
	
	@Test(priority = 2)
	public void viewGoldLoanApplication() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/branch-loan/branchshowpending");
		Thread.sleep(2000);
		
		//Loan Type
		WebElement loanType = driver.findElement(By.id("loanType"));
		Select selectLoanType = new Select(loanType);
		List<WebElement> loanTypes = selectLoanType.getOptions();
		String LT = "Interest";
		for (int i = 0; i < loanTypes.size(); i++) 
		{
			if(loanTypes.get(i).getText().equalsIgnoreCase(LT))
			{
				loanTypes.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(5000);
		
		//Change Every Time
		//Click On Manage
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='even']//a[@class='btn-submit'][normalize-space()='Manage']"))).click();
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 3)
	public void Form1() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Application Info(Form 1)
		//Click On Next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Next']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void Form2() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Add Item Info(Form 2)
		//Item Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='item_details']"))).sendKeys("Gold Chain");
		Thread.sleep(2000);
		
		//No Of Items 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='no_of_items']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//SelectType
		WebElement type = driver.findElement(By.xpath("//select[@name='select_type']"));
		Select selectType = new Select(type);
		List<WebElement> types = selectType.getOptions();
		String ST = "Karrot";
		for (int i = 0; i < types.size(); i++) 
		{
			if(types.get(i).getText().equalsIgnoreCase(ST))
			{
				types.get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		//Purity in Karat
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='purity_karat']"))).sendKeys("23");
		Thread.sleep(2000);
		
		//Gross Weight
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='gross_weight']"))).sendKeys("20");
		Thread.sleep(2000);
		
		//Stone Weight
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stone_weight"))).sendKeys("1");
		Thread.sleep(2000);
		
		//Current Rate (per Gm)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_rate"))).sendKeys("7000");
		Thread.sleep(2000);
		
		//lendingRate (per gm)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lending_rate']"))).sendKeys("6000");
		Thread.sleep(2000);
		
		//Remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='remarks']"))).sendKeys("OK");
		Thread.sleep(2000);
		
		//uploadImage
		WebElement uploadImage = driver.findElement(By.id("imageUpload"));
		String path = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG" ;
		uploadImage.sendKeys(path);
		Thread.sleep(2000);
		
		//Save Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Details']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();	
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void form3() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//send For Approval
//		driver.navigate().to("https://development.techplex.in/branch-loan/approval/1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step-3']//a[1]"))).click();
		Thread.sleep(2000);
		
		//Appraiser Name 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[11]/input[1]"))).sendKeys("Mayur");
		Thread.sleep(2000);
		
		//Appraiser's Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[12]/input[1]"))).sendKeys("MA-0007");
		Thread.sleep(2000);
		
		//Approve
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"))).click();	
		Thread.sleep(2000);
	}
	
//	@Test(priority = 6)
	public void disbursmentOfApproveLoan() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Naviagte
		driver.navigate().to("https://demo.techplex.in/branch-loan/viewgoldloandisburse");
		Thread.sleep(2000);
		
		//Change Name According to member 
		//Client Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Client Name']"))).sendKeys("Automation AI");
		Thread.sleep(2000);
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		//Create Account
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Create Acc No']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"))).click();	
		Thread.sleep(2000);
		
		//Disburse Loan
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Disburse Loan']"))).click();
		Thread.sleep(2000);
		
		//Deposit Account
		WebElement depositAmount = driver.findElement(By.id("accountDropdown"));
		Select selectdepositAmount = new Select(depositAmount);
		List<WebElement> amount = selectdepositAmount.getOptions();
		String DA = "Cash";
		for (int i = 0; i < amount.size() ; i++) 
		{
			if(amount.get(i).getText().equalsIgnoreCase(DA))
			{
				amount.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Disburse
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='submitDisbursement()']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"))).click();	
		System.out.println("Copy Vucher Number");
		Thread.sleep(5000);
	}
	
	//Change Credentials Accordingly
	@Test(priority = 7)
	public void DisburseFromVoucher() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/transaction/showpendingvoucher");
		Thread.sleep(2000);
		
		//Voucher Number
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voucher_no"))).click();
		System.out.println("Add Voucher Number manually");
		Thread.sleep(6000);
		
		//Search Transaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search Transaction']"))).click();
		Thread.sleep(2000);
		
		//Approve voucher
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Voucher']"))).click();
		Thread.sleep(5000);
		
		//Approve Transaction
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Approve Transaction']"))).click();
		Thread.sleep(2000);
		
		//Confirm
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes, Approve']"))).click();
		Thread.sleep(2000);
		
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[6]/button[1]"))).click();	
		Thread.sleep(2000);	
	}
}

//Select Payment Basis 
//Select Scheme
//Installment Frequency 
//Interest Type

//if Need to check all type then use this 

////@Test(priority = 3)
//public void Alldropdowns() throws InterruptedException
//{
//wait=new WebDriverWait(driver, Duration.ofSeconds(30));
////
//String selectPaymentBasis[] = {"Interest","EMI"};
//String selectSchemeOptions1[]= {"Gold Saving/Investment Scheme"};
//String selectSchemeOptions2[]= {"Diwali"};
//String installmentFrequency[]= {"Daily","Weekly","Monthly"};
//String interestType[]= {"Flat","Reducing"};
//
//// Loop through each combination using for loops
//for (int i = 0; i < selectPaymentBasis.length; i++) 
//{
//    new Select(driver.findElement(By.id("payment_basis"))).selectByVisibleText(selectPaymentBasis[i	]);
//    Thread.sleep(2000);
//
//    for (int j = 0; j < selectSchemeOptions1.length; j++) 
//    {
//    	if(i==0)
//    	{
//        new Select(driver.findElement(By.id("scheme"))).selectByVisibleText(selectSchemeOptions1[j]);
//        Thread.sleep(2000);
//    	}
//    	else
//    	{
//    		new Select(driver.findElement(By.id("scheme"))).selectByVisibleText(selectSchemeOptions2[j]);
//            Thread.sleep(2000);
//    	}
//    }
//    for (int k = 0; k < installmentFrequency.length; k++) 
//    {
//        new Select(driver.findElement(By.id("installment_frequency"))).selectByVisibleText(installmentFrequency[k]);
//        Thread.sleep(2000);
//
//        for (int l = 0; l < interestType.length; l++) 
//        {
//            new Select(driver.findElement(By.id("interest_type"))).selectByVisibleText(interestType[l]);
//            Thread.sleep(2000);
//            
//            //Click on Submit
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='calculate_emi_btn']"))).click();
//            Thread.sleep(3000);
//            //clickOnOK
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//            Thread.sleep(3000);
//        }
//        
//    }
//    
//}
//}


