package com.tranings.advanceselenium.waytoautomation.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.tranings.advanceselenium.waytoautomation.pages.DatePicker;
import com.tranings.advanceselenium.waytoautomation.pages.DynamicElements;
import com.tranings.advanceselenium.waytoautomation.pages.Selectable;
import com.tranings.advanceselenium.waytoautomation.pages.ToolTip;

public class TestScriptSimpleElements extends TestConfigurations {
	public final static Logger logger = Logger.getLogger(TestScriptSimpleElements.class);


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











}
