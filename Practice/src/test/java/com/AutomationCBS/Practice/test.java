package com.AutomationCBS.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test 
{
	@Test
	public void testing()
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\eclipse-workspace\\Practice\\Driver\\chromedriver.exe");

        Scanner scanner = new Scanner(System.in);
        List<String> urlList = new ArrayList<>();
        System.out.println("Enter URLs (type 'done' to finish):");
        // Accept user input
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            if (!input.trim().isEmpty()) {
                urlList.add(input.trim());
            }
        }
        scanner.close(); // Always close scanner
        if (urlList.isEmpty()) {
            System.out.println("No URLs entered. Exiting.");
            return;
        }
        // Pick a random URL from the list
        Random random = new Random();
        String selectedUrl = urlList.get(random.nextInt(urlList.size()));
        System.out.println("Opening URL: " + selectedUrl);
        // Open browser
        try {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(selectedUrl); // Open selected URL
            Thread.sleep(5000); // Wait for 5 seconds
            driver.quit(); // Close browser
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
	}	
}
