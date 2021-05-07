package com.CM.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Extentreport extends Base_Class 
{
	
	@Test
	public void logextent()
	{
		logger = reports.createTest("login to CM");
		
		
		
		
		
		logger.info("Starting the app");
		
		logger.pass("Login done successfully ");

	
	
	
	}

}
