package BaseClassForLogin;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
    protected WebDriver driver;

    @BeforeClass
    public void launchBrowser() 
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.qabrains.com/");
    }
    
    @AfterMethod
    public void ifTestFailed(ITestResult result) throws Exception
    {
//    	if(ITestResult.FAILURE == result.getStatus() && driver != null)
//    	{
//    		File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//    		String SSDir = System.getProperty("user.dir") + "/FailedScreenShots/";
//            File directory = new File(SSDir);
//            if (!directory.exists()) 
//            {
//                directory.mkdirs();
//            
//            File destination = new File(
//                    SSDir + result.getName() + "_"  + ".png"
//            );
//
//            FileUtils.copyFile(takeSS, destination);
//            } else 
//            {
//            	System.out.println("The " + result.getName() + " is not Failed !!");
//            }
//         }
    	if(ITestResult.FAILURE == result.getStatus() && driver != null)
    	{
    		File takeSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    		File location = new File("C:\\Users\\Mahindarr\\eclipse-workspace\\CBS\\QABrainsUsingPOM\\FailedScreenShots\\"+result.getName()+".png");
    		FileUtils.copyFile(takeSS, location);
    
    	}
    }

    @AfterClass
    public void tearDown() {
       if(driver != null)
       {
    	   driver.quit();
       }
    }
}
