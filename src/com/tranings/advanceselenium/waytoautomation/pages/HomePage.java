package com.tranings.advanceselenium.waytoautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class HomePage {
	By DemoLink=By.linkText("Demo Site");
	public void directToDemoSite(WebDriver driver,Logger logger){
		try{
		driver.findElement(DemoLink).click();
		}
		catch(WebDriverException wde){
			logger.error(wde.getMessage());
		}
	}
	
}
