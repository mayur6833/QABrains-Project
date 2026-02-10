package SelenumCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice 
{
	WebDriver driver;
	public void handleDropdown()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement selectDD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
		List<WebElement> DD = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("")));
		String s1 = "India";
		for (int i = 0; i < DD.size(); i++) 
		{
			if(DD.get(i).getText().equalsIgnoreCase(s1))
			{
				DD.get(i).click();
				break;
			}
		}
		
	}
}