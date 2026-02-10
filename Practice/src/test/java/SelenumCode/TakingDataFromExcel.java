package SelenumCode;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingDataFromExcel 
{
	WebDriver driver;
	WebDriverWait wait;
	String s1,s2,s3;
	
	@BeforeClass
	public void setup() throws Exception
	{
		File file = new File("C:\\Users\\Mahindarr\\Desktop\\Automation\\forAutomationUse.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Automation");
		
		
		s1 = sheet.getRow(3).getCell(5).getStringCellValue();
		//System.out.println(s1);
		s2 = sheet.getRow(6).getCell(2).getStringCellValue();
		s3 = sheet.getRow(9).getCell(9).getStringCellValue();
		
		wb.close();
		fis.close();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(s1);
	}
	
	@Test
	public void login() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email Address']"))).sendKeys(s2);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordField"))).sendKeys(s3);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn"))).click();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void ifTesFail(ITestResult result) throws Exception
	{
		File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File location = new File("C:\\Users\\Mahindarr\\git\\repository\\Practice\\ScreenShots\\"+result.getName()+".png");
		FileUtils.copyFile(takeSS, location);
	}
	
	@AfterClass
	public void exit()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}
