package com.AutomationCBS.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginLogicTest 
{
    private WebDriver driver;
    private LogInLogic logInLogic;
	
	 @BeforeClass
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\CBS_Branch\\Driver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        // Implicit wait - ok but explicit waits preferred in main class
	        driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
	        
	        logInLogic = new LogInLogic(driver);
	    }
	    
	    @Test(priority = 1)
	    public void test1() throws Exception {
	        logInLogic.getURL("https://demo.techplex.in/login");
	        
	        logInLogic.username("demoadmin@gmail.com");
	        logInLogic.password("Pawan@123");
	        logInLogic.loginClick();
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        if(driver != null) {
	            driver.quit();
	        }
	}
}
