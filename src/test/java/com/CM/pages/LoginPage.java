package com.CM.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	public WebDriver driver;

	
	@FindBy(xpath = "//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid']") WebElement RegisteredEmail;
	@FindBy(xpath = "//button[@class='btn-login']") WebElement EmailNext;
	@FindBy(xpath = "//div[3]//input[1]") WebElement Password;
	@FindBy(xpath = "//button[contains(text(),'Next')]") WebElement PasswordNext;
	@FindBy(xpath = "//input[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-valid']") WebElement OneTimePassword;
	@FindBy(xpath = "//button[@id='login']") WebElement OTPLogin;
	@FindBy(id = "userName") WebElement Userinitial;
	@FindBy(id = "domainName2") WebElement Userdomain;
	public void Username(String Email) 
	{
		RegisteredEmail.sendKeys(Email);
		EmailNext.click();		 
	}

	public void UserPwd(String Pwd)
	{

		Password.sendKeys(Pwd);
		PasswordNext.click();
	}
	public void generateOTP(String Initial, String maildomain) throws InterruptedException
	{   
		try
		{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			
		}

		Userinitial.clear();
		Userdomain.clear();
		Userinitial.sendKeys(Initial);
		Userdomain.sendKeys(maildomain);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		String firstMail = links.get(6).getText();
		driver.findElement(By.linkText(firstMail)).click();	    
		String bodyText = driver.findElement(By.xpath("//*[@class='e7m mess_bodiyy']")).getText();
		String[] str1 = bodyText.split(" ");
		System.out.println("OTP string test = "+str1[12]);
		String substr = str1[12].substring(13, 19);
		System.out.println("substring = " + substr);
	}

	public void OTimePWD(String OTPWD)
	{

		OneTimePassword.sendKeys(OTPWD);
		OTPLogin.click();

	}



}
