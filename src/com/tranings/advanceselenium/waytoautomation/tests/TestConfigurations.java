package com.tranings.advanceselenium.waytoautomation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.tranings.advanceselenium.waytoautomation.system.Init;

public class TestConfigurations {
	static WebDriver driver;
	public final static Logger logger = Logger.getLogger(TestScriptSimpleElements.class);
	Init init = new Init();

	@BeforeTest
	public void initialize() throws Exception { 
		try{
			TestConfigurations.driver = init.initiate(logger);	
			System.out.println(driver.getTitle());
			logger.info("Application is up and running");	
		}catch(Exception e)
		{
			logger.error(e.getMessage());
		}
	}

	@AfterTest
	public void closeProject(){
		try{
			init.closeBrowser(driver,logger);
			logger.info("Application is closing the browsers");
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

	@AfterSuite
	public void sendMail(){
		try{
			init.sendMail(logger); 
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
}
