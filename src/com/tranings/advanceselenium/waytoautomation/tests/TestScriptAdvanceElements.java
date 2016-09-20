package com.tranings.advanceselenium.waytoautomation.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.tranings.advanceselenium.waytoautomation.pages.Alerts;

public class TestScriptAdvanceElements extends TestConfigurations {
	public final static Logger logger = Logger.getLogger(TestScriptAdvanceElements.class);

	@Test
	public void testAlert(){
		Alerts al = new Alerts();
		al.alertFunction(driver,logger);
	}
}
