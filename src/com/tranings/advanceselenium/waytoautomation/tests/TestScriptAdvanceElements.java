package com.tranings.advanceselenium.waytoautomation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tranings.advanceselenium.waytoautomation.pages.Alerts;
import com.tranings.advanceselenium.waytoautomation.system.Init;

public class TestScriptAdvanceElements {
	WebDriver driver = null;
	public final static Logger logger = Logger.getLogger(TestScriptSimpleElements.class);
	Init init = new Init();
//	@BeforeClass
//	public void initialize() throws Exception { 
//		this.driver = init.initiate();
//		logger.info("Application is up and running");
//
//	}

	@Test
	public void testAlert(){
		Alerts al = new Alerts();
		al.alertFunction(driver,logger);
	}
//
//	@AfterClass
//	public void closeProject(){
//		new Init().closeBrowser(driver,logger);
//		
//	}
}
