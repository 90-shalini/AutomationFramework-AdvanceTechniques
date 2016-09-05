package com.tranings.advanceselenium.waytoautomation.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tranings.advanceselenium.waytoautomation.pages.DatePicker;
import com.tranings.advanceselenium.waytoautomation.pages.DynamicElements;
import com.tranings.advanceselenium.waytoautomation.pages.Selectable;
import com.tranings.advanceselenium.waytoautomation.pages.ToolTip;
import com.tranings.advanceselenium.waytoautomation.system.Init;

public class TestScriptSimpleElements {
	WebDriver driver = null;
	public final static Logger logger = Logger.getLogger(TestScriptSimpleElements.class);
	Init init = new Init();
	@BeforeClass
	public void initialize() throws Exception { 
		this.driver = init.initiate();
		logger.info("Application is up and running");

	}

	/**DatePicker Test case to handle calendar**/
	@Test
	public void testDatePicker(){
		DatePicker dp = new DatePicker();
		dp.pickDate(driver,logger);
	}


	@Test
	public void testSelectables(){
		Selectable selectItem = new Selectable();
		selectItem.Select(driver,logger);	
	}


	@Test
	public void testDynamicElements(){
		DynamicElements de = new DynamicElements();
		de.clickDynamicButton(driver,logger);
	}

	@Test
	public void testToolTip(){
		ToolTip tt = new ToolTip();
		tt.tooltipFunctionality(driver,logger);
	}

	@AfterClass
	public void closeProject(){
		new Init().closeBrowser(driver,logger);

	}
	@AfterSuite
	public void sendMail(){
		init.sendMail(logger); 


	}









}
