package enterIntoSiteFunctionality;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	 public LoginPage(WebDriver driver) 
	 {
		 this.driver = driver;
	     PageFactory.initElements(driver, this);
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  }
	
	@FindBy(id = "email")
	public WebElement loginEmail;
	
	@FindBy(id = "password")
	public WebElement loginPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement btnLogin;
	
	public void login(String email, String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(loginEmail)).sendKeys(email);
	    wait.until(ExpectedConditions.visibilityOf(loginPassword)).sendKeys(pass);

	    WebElement loginButton = wait.until(
	            ExpectedConditions.elementToBeClickable(btnLogin)
	    );
	    loginButton.click();

	    // wait until dashboard loads
	    wait.until(ExpectedConditions.urlContains("/ecommerce"));
	}
}
