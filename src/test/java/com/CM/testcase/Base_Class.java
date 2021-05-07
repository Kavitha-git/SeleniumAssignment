package com.CM.testcase;

import java.io.File;
import java.util.concurrent.TimeUnit;

//import java.util.ArrayList;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.safari.SafariDriver.WindowType;
//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

//import com.CM.pages.LoginPage;
import com.CM.utility.BrowserFactory;
//import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base_Class 

{
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest logger;
	
	@BeforeSuite
	public void Suitesetup()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/CM.htkl"));
		reports = new ExtentReports();
		reports.attachReporter(extent);
	}
	@BeforeClass
	public void setup() throws InterruptedException
	{
		driver = BrowserFactory.Startapp(driver, "Chrome" , "http://3.7.82.1:4200/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Title on page is : " +driver.getTitle());
				
	}
	
	@AfterClass
	public void Teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	
}
