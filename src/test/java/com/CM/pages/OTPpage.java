package com.CM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class OTPpage {
	WebDriver driver;

	public OTPpage(WebDriver driver)
	{
		this.driver = driver;
	}

	@FindBy(id = "userName") WebElement Userinitial;
	@FindBy(id = "domainName2") WebElement Userdomain;

	public void generateOTP(String Initial, String maildomain) throws InterruptedException 
	{   
		
		  Userinitial.clear();
		  Userdomain.clear();
		  Userinitial.sendKeys(Initial);
		  Userdomain.sendKeys(maildomain);
		
		Thread.sleep(7000);
		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(7000);

		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());
		String firstMail = links.get(6).getText();
		driver.findElement(By.linkText(firstMail)).click();	
		
		String bodyText = driver.findElement(By.xpath("//*[@class='e7m mess_bodiyy']")).getText();
		String[] str1 = bodyText.split(" ");
		//System.out.println("OTP string test = "+str1[12]);
		String substr = str1[12].substring(13, 19);
		System.out.println("substring = " + substr);



	}


}
