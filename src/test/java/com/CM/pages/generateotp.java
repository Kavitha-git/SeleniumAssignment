package com.CM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class generateotp 
{
	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://generator.email/");
		driver.manage().window().maximize();
	}
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("domainName2")).clear();
		driver.findElement(By.id("userName")).sendKeys("piyush.r");
		driver.findElement(By.id("domainName2")).sendKeys("test130.com");

		Thread.sleep(7000);
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
}