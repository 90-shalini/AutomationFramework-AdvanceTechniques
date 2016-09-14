package com.tranings.advanceselenium.waytoautomation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.tranings.advanceselenium.waytoautomation.system.Init;

public class TestConfigurations {
	static WebDriver driver = null;
	public final static Logger logger = Logger.getLogger(TestScriptSimpleElements.class);
	Init init = new Init();
	
	 public TestConfigurations() {
		System.out.println("In Configuration class");
		}
	@BeforeTest
	public void initialize() throws Exception { 
		
		this.driver = init.initiate();
		logger.info("Application is up and running");

	}
	@AfterTest
	public void closeProject(){
		new Init().closeBrowser(driver,logger);

	}
	@AfterSuite
	public void sendMail(){
		//init.sendMail(logger); 


	}
}
