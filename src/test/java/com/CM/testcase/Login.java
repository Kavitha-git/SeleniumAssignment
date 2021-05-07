package com.CM.testcase;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//import java.util.ArrayList;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.CM.pages.LoginPage;
import com.CM.utility.BrowserFactory;
//import com.CM.pages.OTPpage;

public class Login extends Base_Class
{
	@Test
	public void Loginfxn() throws InterruptedException
	{
		//Adding extent reports
		logger = reports.createTest("Login to Category Manager");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		login.Username("piyush.r@test130.com");		
		BrowserFactory.CaptureScreenshot(driver, "Login");
		login.UserPwd("Attack@1990");
	
		//Get the current window handle
		String Parent = driver.getWindowHandle();
		System.out.println("Parent window handled");

		String url="https://generator.email/piyush.r@test130.com";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open(arguments[0])", url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Set<String> winHandles = driver.getWindowHandles();
		for(String handle: winHandles)
		 {
			if(!handle.equals(Parent))
			 {
			 driver.switchTo().window(handle);
	         
	        login.generateOTP("piyush.r","test130.com");
	         // OTPpage otp= PageFactory.initElements(driver, OTPpage.class);
	        // otp.generateOTP("piyush.r", "test130.com");
	        
	         driver.close();
	         
		 }
		 }
		
		 driver.switchTo().window(Parent); 
		  
		String title = driver.getTitle();
		System.out.println("Page title is :" +title);
		
		
		driver.findElement(By.id("login")).click();
		logger.pass("Login successful");



	}

}
