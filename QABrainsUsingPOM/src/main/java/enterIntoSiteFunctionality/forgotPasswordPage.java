package enterIntoSiteFunctionality;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClassForLogin.BaseTest;

public class forgotPasswordPage extends BaseTest
{
	private WebDriver driver;
	private WebDriverWait wait;
	
	public forgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindAll({
		@FindBy(xpath = "//span[text()='Forgot Password']"),
		@FindBy(id = "forgot-password"),
	})
	public WebElement navToForgotPass;
	
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindAll({
		@FindBy(xpath = "//button[@type='submit']"),
		@FindBy(xpath = "//button[text()='Reset Password']")
	})
	public WebElement resetPass;
	
	
	public void forgotpasswords(String emailID) throws Exception
	{
		//navigate to forgot password
		
		WebElement navigation = wait.until(ExpectedConditions.elementToBeClickable(navToForgotPass));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", navigation);
		navigation.click();
		Thread.sleep(2000);
		
		//Email
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailID);
		
		//reset Password
		WebElement resetPassword = wait.until(ExpectedConditions.visibilityOf(resetPass));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", resetPassword);
		resetPassword.click();
		Thread.sleep(5000);
	}
}
