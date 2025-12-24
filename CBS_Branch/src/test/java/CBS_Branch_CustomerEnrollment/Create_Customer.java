package CBS_Branch_CustomerEnrollment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

//Change Identity details for Every run

public class Create_Customer extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	String mailID;
	
	@Test(priority = 1)
	public void Create_Customer_Navigation() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Direct Navigate
		driver.navigate().to("https://demo.techplex.in/customer-enrollment/create-customr");
		Thread.sleep(2000);	
		
//		//Aadhar Verification
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aadhaar_verification"))).sendKeys("987007890876");
//		Thread.sleep(2000);
//		
//		//ClickOnSendOTP
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sendOtpBtn"))).click();
//		Thread.sleep(2000);
//		
//		//EnterOTP
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aadhaar_otp"))).sendKeys("668767");
//		Thread.sleep(2000);	
//		
//		//Verify OTP
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verifyOtpBtn"))).click();
//		Thread.sleep(2000);
		
		//Title
		WebElement title = driver.findElement(By.xpath("//select[@name='title']"));
		Select titles = new Select(title);
		List<WebElement> titleOptions = titles.getOptions();
		String TT ="Mr.";
		for (int i = 0; i < titleOptions.size(); i++) 
		{
			if(titleOptions.get(i).getText().equalsIgnoreCase(TT))
			{
				titleOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//FirstName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter First Name']"))).sendKeys("Leo");
		Thread.sleep(2000);	
		
		//LastName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Last Name']"))).sendKeys("Shinde");
		Thread.sleep(2000);
		
		//memberType
		WebElement memberType = driver.findElement(By.xpath("//select[@name='member_type']"));
		Select members = new Select(memberType);
		List<WebElement> memberOptions = members.getOptions();
		String MT ="Share Holder";
		for (int i = 0; i < memberOptions.size(); i++) 
		{
			if(memberOptions.get(i).getText().equalsIgnoreCase(MT))
			{
				memberOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Father/HusbandName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Full Name']"))).sendKeys("John");
		Thread.sleep(2000);

		//DOB
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dob']"))).click();
		Thread.sleep(1000);
		WebElement selectMonthAndYear = driver.findElement(By.xpath("//div[@data-action='prev']//*[name()='svg']"));
		//2000=300
//		int clickcount = 200;  //for below 18
		int clickcount = 300;  //for Above 18
		for (int i = 0; i < clickcount; i++) 
		{
			selectMonthAndYear.click();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[4]"))).click();
		Thread.sleep(3000);
	
		
		//Age
		WebElement Age = driver.findElement(By.id("age"));
		String AgeText = Age.getAttribute("value").replaceAll("[^\\d.]", "").trim();
		int systemAgeText = Integer.parseInt(AgeText);
		System.out.println("System Generated Age = "+systemAgeText);
		      
	    if(systemAgeText <= 17)
		{		
		  	//Guardian Member ID 
		  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("guardianmemid"))).sendKeys("003001100001");
		  	Thread.sleep(2000);
		  		
		    //Age
		  	//fetch throght DOB
		}	    
	    
		//Gender
		WebElement Gender = driver.findElement(By.xpath("//select[@name='gender']"));
		Select genders = new Select(Gender);
		List<WebElement> genderOptions = genders.getOptions();
		String GS ="Male";
		for (int i = 0; i < genderOptions.size(); i++) 
		{
			if(genderOptions.get(i).getText().equalsIgnoreCase(GS))
			{
				genderOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Religion
		WebElement religion = driver.findElement(By.xpath("//select[@name='religion']"));
		Select religions = new Select(religion);
		List<WebElement> religionOptions = religions.getOptions();
		String SR ="HINDU";
		for (int i = 0; i < religionOptions.size(); i++) 
		{
			if(religionOptions.get(i).getText().equalsIgnoreCase(SR))
			{
				religionOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 2)
	public void ContactDetails() throws Exception
	{		
		//MobileNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile"))).click();
		System.out.println("----------Add Mobile No Manually----------");
		Thread.sleep(10000);
		
		//Email
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		email.click();
		System.out.println("----------Enter Mail ID manually---------");
		Thread.sleep(10000);
		mailID = email.getAttribute("value");
		System.out.println(mailID);
		
		//Occupation
		WebElement Occupation = driver.findElement(By.xpath("//select[@name='occupation']"));
		Select Occupations = new Select(Occupation);
		List<WebElement> OccupationOptions = Occupations.getOptions();
		String OS ="BUSINESS";
		for (int i = 0; i < OccupationOptions.size(); i++) 
		{
			if(OccupationOptions.get(i).getText().equalsIgnoreCase(OS))
			{
				OccupationOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//AnnualIncome
		WebElement AnnualIncome = driver.findElement(By.xpath("//select[@name='annual_income']"));
		Select selectAnnualIncome = new Select(AnnualIncome);
		List<WebElement> incomeOptions = selectAnnualIncome.getOptions();
		String AI ="400000 - 500000";
		for (int i = 0; i < incomeOptions.size(); i++) 
		{
			if(incomeOptions.get(i).getText().equalsIgnoreCase(AI))
			{
				incomeOptions.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//OccupationalAddress
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Work Address']"))).sendKeys("Near Ring Road , Hinjewadi-286521");
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 3)
	public void PermenetAddressDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//PinCode
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pinInput']"))).sendKeys("411043");
		Thread.sleep(2000);
		
		//PermanantStreetAddress
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='permanent_address1']"))).sendKeys("House No 13 , near ring road");
		Thread.sleep(2000);
		
		//PermanantLandmark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='permanent_address2']"))).sendKeys("Hinjewadi");
		Thread.sleep(2000);	
	
		//Same as Permanent Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='copy_address']"))).click();
		Thread.sleep(4000);
	}
	
	@Test(priority = 4)
	public void nomineeDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Same as Current Address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='copy_permanent_to_nominee']"))).click();
		Thread.sleep(4000);
		
		//Title
		WebElement title1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='nominee_title']")));
		Select titles1 = new Select(title1);
		List<WebElement> titleOptions1 = titles1.getOptions();
		String TT1 ="Mr.";
		for (int i = 0; i < titleOptions1.size(); i++) 
		{
			if(titleOptions1.get(i).getText().equalsIgnoreCase(TT1))
			{
				titleOptions1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//NomineeName
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Enter Nominee's Full Name\"]"))).sendKeys("John Singh");
		Thread.sleep(2000);
		
		//DOB
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nominee_dob"))).click();
		Thread.sleep(1000);
		WebElement selectMonthAndYear = driver.findElement(By.xpath("//div[@data-action='prev']//*[name()='svg']"));
		//2000=300
		int clickcount = 350;
		for (int i = 0; i < clickcount; i++) {
			selectMonthAndYear.click();
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[18]"))).click();
		Thread.sleep(2000);
		
		//Age
		//Auto fetch
		
		//Relationship
		WebElement relationship = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='nominee_relationship']")));
		Select selectRelationship = new Select(relationship);
		List<WebElement> relation = selectRelationship.getOptions();
		String REL = "FATHER";
		for (int i = 0; i < relation.size(); i++) 
		{
			if(relation.get(i).getText().equalsIgnoreCase(REL))
			{
				relation.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void identityDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//AadharNumber
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aadhar_id"))).sendKeys("123450090076");
		Thread.sleep(1000);
//		//SelectVerifyButton
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Verify'][contains(text(),'✔️')])[1]"))).click();
//		Thread.sleep(1000);
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
		
		//VoterID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voter_id"))).sendKeys("AOO1209092");
		Thread.sleep(2000);
//		//SelectVerifyButton
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Verify'][contains(text(),'✔️')])[2]"))).click();
//		Thread.sleep(1000);
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
		
		//PANNO
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pan_no"))).sendKeys("APOPO9036T");
		Thread.sleep(2000);
//		//SelectVerifyButton
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Verify'][contains(text(),'✔️')])[3]"))).click();
//		Thread.sleep(1000);
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);
		
		//PassportNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Passport Number eg. A2349823']"))).sendKeys("A1201507");
		Thread.sleep(2000);
//		//SelectVerifyButton
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Verify'][contains(text(),'✔️')])[4]"))).click();
//		Thread.sleep(1000);
//		//OK
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
//		Thread.sleep(2000);	
	}
	
	@Test(priority = 7)
	public void uploadDocumnet() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//upload passport photo
        WebElement UpdatePassportPhoto = driver.findElement(By.id("passport_photo_file"));
        String filePath1 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
        UpdatePassportPhoto.sendKeys(filePath1);
        Thread.sleep(2000);
        
        //Upload Signature
        WebElement UpdateSignature = driver.findElement(By.id("signature_file"));
        String filePath2 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\2.PNG";
        UpdateSignature.sendKeys(filePath2);
        Thread.sleep(2000);
        
        //Upload Aadhar Card
        WebElement UpdateAadharCard = driver.findElement(By.id("customer_aadhar"));
        String filePath4 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\3.PNG";
        UpdateAadharCard.sendKeys(filePath4);
        Thread.sleep(2000);
        
        //Upload Voter ID
        WebElement UpdateVoterID = driver.findElement(By.id("customer_voterid"));
        String filePath5 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
        UpdateVoterID.sendKeys(filePath5);
        Thread.sleep(2000);
        
        //Upload Pan Card
        WebElement UpdatePanCard = driver.findElement(By.id("customer_pancard"));
        String filePath6 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\2.PNG";
        UpdatePanCard.sendKeys(filePath6);
        Thread.sleep(2000);
        
        //Upload Passport
        WebElement UploadPassport = driver.findElement(By.id("customer_passport"));
        String filePath7 = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\3.PNG";
        UploadPassport.sendKeys(filePath7);
        Thread.sleep(2000);
	}
	
	@Test(priority = 8)
	public void introducerDetails() throws Exception
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//IntroducerAgentNo
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='introducer_agent_no']"))).sendKeys("SWMT-A0026");
		Thread.sleep(2000);
		
		//Save Customer Details 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Customer Details']"))).click();
		System.out.println("-----------------Copy Member ID---------------");
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
}
