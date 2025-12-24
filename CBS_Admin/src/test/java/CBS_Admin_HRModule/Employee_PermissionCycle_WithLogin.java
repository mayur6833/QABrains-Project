package CBS_Admin_HRModule;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PropertiesCodeForAdmin.AdminCode;
import io.github.bonigarcia.wdm.WebDriverManager;

//HR Module 
// 1. Manage Employee -> Create Employee 
// 2. Manage Employee -> User Master -> Set Password 
// 3. Permission Master -> Employee Rights -> Set Permissions
// 4. Login Branch -> Check permission

//Copy employee ID And Password for login 

public class Employee_PermissionCycle_WithLogin 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Taking from admin property code
		AdminCode login = new AdminCode(driver);
		login.LoginAdmin();
	}
	
	@Test(priority = 1)
	public void CreateEmployee() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Navigate to Create Employee
		driver.navigate().to("https://demo.techplex.in/settings/create_employee");
		Thread.sleep(2000);
		
		//Member ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("member_id"))).click();
		System.out.println("----------Add Member ID Manually----------");
		Thread.sleep(10000);
		
		//State 
		WebElement state = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[5]/input[1]"));
		state.click();
		Thread.sleep(2000);
		state.sendKeys("Maharashtra");
		Thread.sleep(2000);
		
		//Create Employee
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnsubmit"))).click();
		System.out.println("----------Copy Emp No----------");
		Thread.sleep(10000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		System.out.println("----------Check EMP INFO Manually----------");
		Thread.sleep(6000);
	}
	
	//Set Password
	@Test(priority = 2)
	public void UserMaster() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofNanos(30));
		
		//Navigate 
		driver.navigate().to("https://demo.techplex.in/settings/userMaster");
		Thread.sleep(2000);
		
		//EmployeeID
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emp_no"))).click();
		System.out.println("----------Add Employee ID Manually----------");
		Thread.sleep(10000);
		
		//Password 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Pass@123");
		Thread.sleep(2000);
		
		//Department
		WebElement department = driver.findElement(By.id("department"));
		Select selectDepartment = new Select(department);
		List<WebElement> dept = selectDepartment.getOptions();
		String dept1 = "IT DEPARTMENT";
		for (int i = 0; i < dept.size(); i++) 
		{
			if(dept.get(i).getText().equalsIgnoreCase(dept1))
			{
				dept.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Designation
		WebElement designation = driver.findElement(By.id("designation"));
		Select selectDesignation = new Select(designation);
		List<WebElement> desig = selectDesignation.getOptions();
		String role1 = "Manager";
		for (int i = 0; i < desig.size(); i++) 
		{
			if(desig.get(i).getText().equalsIgnoreCase(role1))
			{
				desig.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//LogIn Branch 
		WebElement LogInBranch = driver.findElement(By.id("branch_code"));
		Select selectLogInBranch = new Select(LogInBranch);
		List<WebElement> Branch = selectLogInBranch.getOptions();
		String LIB = "TECHPLEX";
		for (int i = 0; i < Branch.size(); i++) 
		{
			if(Branch.get(i).getText().equalsIgnoreCase(LIB))
			{
				Branch.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Save 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']"))).click();
		Thread.sleep(2000);
		
		//OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']"))).click();
		Thread.sleep(2000);
	}
	
	//Set Permission
	@Test(priority = 3)
	public void EmployeeRights() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//navigate 
		driver.navigate().to("https://demo.techplex.in/settings/branch_user_rights");
		Thread.sleep(2000);
		
		//Branch Name
		WebElement branchName = driver.findElement(By.id("branch"));
		Select selectBranch = new Select(branchName);
		List<WebElement> branch = selectBranch.getOptions();
		String SB ="TECHPLEX";
		for (int i = 0; i < branch.size(); i++) 
		{
			if(branch.get(i).getText().equalsIgnoreCase(SB))
			{
				branch.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select Designation
		WebElement designation = driver.findElement(By.id("designation"));
		Select selectDesignation = new Select(designation);
		List<WebElement> desig = selectDesignation.getOptions();
		String role1 = "Manager";
		for (int i = 0; i < desig.size(); i++) 
		{
			if(desig.get(i).getText().equalsIgnoreCase(role1))
			{
				desig.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Select User
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user"))).click();
		System.out.println("----------Select User Manually----------");
		Thread.sleep(10000);
		
		//Assign 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assignBtn"))).click();
		Thread.sleep(2000);
		
		//Clear All
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("clearAllBtn"))).click();
		Thread.sleep(2000);	
		
		//Access
		//Transactions
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='slider'])[1]"))).click();
		Thread.sleep(2000);
		
		//Transaction Reports
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='slider'])[26]"))).click();
		Thread.sleep(2000);
		
		//Save Permission 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save Permissions']"))).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4)
	public void branchLogIn() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//clear session cookies and local storage
		driver.manage().deleteAllCookies(); 
		((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
		((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
	    Thread.sleep(2000);
			    
		//Navigation
		Thread.sleep(2000);
		driver.navigate().to("http://www.demo.techplex.in");
		
		//login Code
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).click();
		System.out.println("----------Add Mail ID MAnually----------");
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).click();
		System.out.println("----------Add Password Manually----------");
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submitBtn']"))).click();
		Thread.sleep(5000);				
	}
	
	@AfterClass
	public void Exit() throws Exception
	{
		Thread.sleep(5000);
		if(driver != null)
		{
			driver.close();
		}
	}	
}





