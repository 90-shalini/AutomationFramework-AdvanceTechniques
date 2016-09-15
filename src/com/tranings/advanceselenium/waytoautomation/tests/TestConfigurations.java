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
		TestConfigurations.driver = init.initiate();	
		System.out.println(driver.getTitle());
		logger.info("Application is up and running");		
						
	}
//	@Factory (dataProvider="dataProviderMethod")
//	public SolicitudEmpleo(String campoDni, String firstName, String lastName){
//	    this.campoDni=campoDni;
//	    this.firstName = firstName;
//	    this.lastName = lastName;
//	}
//	@DataProvider(name="driverDetails")
//	public Object[][] GetWebDriverName(){
//		
//		return new Object[][] { {"1","FireFox"}, {"2", "Chrome"} };
//	
//		
//
//	}
	@AfterTest
	public void closeProject(){
		init.closeBrowser(driver,logger);
		logger.info("Application is closing the browsers");

	}
	@AfterSuite
	public void sendMail(){
		init.sendMail(logger); 


	}
}
