package com.CM.utility;

import java.io.File;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
	public static WebDriver Startapp(WebDriver driver, String Browsername, String URL) 
	{
		if(Browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
			driver = new ChromeDriver();
			


		}
		else if (Browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Drivers/geckodriver");
			driver = new FirefoxDriver();
			

		}
		else if(Browsername.equals("InternerExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "/Drivers/IEDriverServer");
			driver = new InternetExplorerDriver();
			
		}
		else 
		{
			System.out.println("we do not support defined browser");
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	public static void CaptureScreenshot(WebDriver driver, String screenshotname)
	{
		try {
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source,new File("./CaptureScreen/"+screenshotname+".png"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
