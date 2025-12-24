package CheckAllLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import LoginBranch.BaseLoginForAllBranchModules;

public class Links extends BaseLoginForAllBranchModules
{
	WebDriverWait wait;
	
	@Test
	public void checkLink() throws Exception
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement allLinks : links) 
		{
			String url = allLinks.getAttribute("href");
			
			if(url!=null && !url.isEmpty())
			{
				URL newUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) newUrl.openConnection();
				connection.setRequestMethod("HEAD");
				connection.setConnectTimeout(2000);
				//connection.setReadTimeout(10000);
				connection.connect();
				
				int httpResponseCode = connection.getResponseCode();
				
				if(httpResponseCode >= 400)
				{
					System.out.println(url + " ---> Broken Link (" + httpResponseCode + ")");
				}
				else
				{
					System.out.println(url + " ---> Valid Link (" + httpResponseCode + ")");
				}
			}
		}
	}
	
}
