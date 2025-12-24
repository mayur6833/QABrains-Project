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

public class ViewGoldLoanApplication extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void viewGoldLoanApplication() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//direct Navigation
		driver.navigate().to("https://demo.techplex.in/branch-loan/branchshowpending");
		Thread.sleep(2000);
		
		//ClickOnSearch
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(2000);
		
		
		//Need to Change Search 
//		//Loan Status
//		WebElement LoanStatus = driver.findElement(By.id(""));
//		Select selectStatus = new Select(LoanStatus);
//		List<WebElement> status = selectStatus.getOptions();
//		String LS = "Pending";
//		for (int i = 0; i < status.size(); i++) 
//		{
//			if(status.get(i).getText().equalsIgnoreCase(LS))
//			{
//				status.get(i).click();
//				break;
//			}
//		}
//		Thread.sleep(2000);
		
//Need to add search Code 
		//Manage
		//8
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody tr:nth-child(8) td:nth-child(9) a:nth-child(1)"))).click();
		Thread.sleep(10000);
		
	}
	//Form 1
	@Test(priority = 2)
	public void ApplicationInfo() throws Exception
	{
		//next
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn-submit']"))).click();
		Thread.sleep(2000);
		
	}
	
	//Form 2
	@Test(priority = 3)
	public void AddItemsInfo() throws Exception
	{	
		//Item Group
		WebElement itemGroup = driver.findElement(By.xpath("//select[@name='item_group']"));
		Select selectItemGroup = new Select(itemGroup);
		List<WebElement> groups = selectItemGroup.getOptions();
		String IG = "Gold";
		for (int i = 0; i < groups.size(); i++) 
		{
			if(groups.get(i).getText().equalsIgnoreCase(IG))
			{
				groups.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Item Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='item_details']"))).sendKeys("Gold Chain");
		Thread.sleep(2000);
		
		//NoOfItem
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='no_of_items']"))).sendKeys("2");
		Thread.sleep(2000);
		
		//Select Type
		WebElement selectType = driver.findElement(By.xpath("//select[@name='select_type']"));
		Select selectTypes= new Select(selectType);
		List<WebElement> types = selectTypes.getOptions();
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='purity_karat']"))).sendKeys("24.00");
		Thread.sleep(2000);
		
		//Gross Weight(gms)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gross_weight"))).sendKeys("50.00");
		Thread.sleep(2000);
		
		//Stone Weight
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stone_weight"))).sendKeys("12.40");
		Thread.sleep(2000);
		
		//Net Weight
		//Auto Fetch
		
		//Current Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current_rate"))).sendKeys("9500.00");
		Thread.sleep(2000);
		
		//leading Rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lending_rate']"))).sendKeys("11000.00");
		Thread.sleep(2000);
		
		//Remark
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='remarks']"))).sendKeys("DONE");
		Thread.sleep(2000);
		
		//upload Image
		WebElement uploadImage = driver.findElement(By.id("imageUpload"));
		String imagePath = "C:\\Users\\Shree\\Desktop\\photos use in auotmation\\1.PNG";
		uploadImage.sendKeys(imagePath);
		
		//Save Details 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Details']"))).click();
		Thread.sleep(2000);
		
		//ok
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void SendForApproval() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//navigate to next form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='step-3']//a[1]"))).click();
		Thread.sleep(2000);
		
		//Appraiser's Name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[11]/input[1]"))).sendKeys("John Cena");
		Thread.sleep(2000);
		
		//Appraiser's Code
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='text'])[12]"))).sendKeys("LOAN-12");
		Thread.sleep(2000);
		
		//approve
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Approve'])[1]"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void checkApproval() throws Exception
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//navigate to disbursement of Approve Loan
		driver.navigate().to("https://demo.techplex.in/branch-loan/viewgoldloandisburse");
		Thread.sleep(2000);

//Need to add search Code 		
		
		//Search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']"))).click();
		Thread.sleep(7000);
	}
}