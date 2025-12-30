package com.AutomationCBS.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInLogic 
{
	private WebDriver driver;
    private WebDriverWait wait;
    
    public LogInLogic(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Initialize here after driver is assigned
    }
    
    public void getURL(String url) {
        driver.get(url);
    }
    
    public void username(String username) throws Exception {
        WebElement ID = driver.findElement(By.id("email"));
        ID.sendKeys(username);
    }
    
    public void password(String Pass) throws Exception {
        WebElement ID = driver.findElement(By.id("password2"));
        ID.sendKeys(Pass);
    }
    
    public void loginClick() {
        WebElement click = driver.findElement(By.xpath("//button[@type='submit']"));
        click.click();
    }
	
	
}
