package com.tranings.advanceselenium.waytoautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class ToolTip {
	Utils util = new Utils();
	By toolTipWidget = By.linkText("Tooltip");
	By defaultFuncTab = By.id("example-1-tab-1");
	By customAnimationDemoLink= By.linkText("CUSTOM ANIMATION DEMO");
	By customAnimationDemoTab = By.id("example-1-tab-2");
	By DemoFrame = By.className("demo-frame");
	By inputHover = By.id("age");
	By toolTipElement = By.xpath("//div[starts-with(@id,'ui-id-')]");
	By showLink = By.id("show-option");
	By hideLink = By.id("hide-option");
	By openEvent = By.id("open-event");
	
	public void tooltipFunctionality(WebDriver driver,Logger logger){
		try{
			Actions action = new Actions(driver);
		util.minWaitForElementToBeVisible(driver, toolTipWidget);
		driver.findElement(toolTipWidget).click();	
		util.minWaitForElementToBeVisible(driver, defaultFuncTab);
		driver.switchTo().frame(driver.findElement(defaultFuncTab).findElement(DemoFrame));
		util.minWaitForElementToBeVisible(driver, inputHover);		
		action.moveToElement(driver.findElement(inputHover)).build().perform();
		String toolTipText = driver.findElement(toolTipElement).getText();
		Assert.assertEquals("We ask for your age only for statistical purposes.", toolTipText);
		driver.switchTo().defaultContent();
		
		util.minWaitForElementToBeVisible(driver, customAnimationDemoLink);
		driver.findElement(customAnimationDemoLink).click();	
		util.minWaitForElementToBeVisible(driver, customAnimationDemoTab);
		driver.switchTo().frame(driver.findElement(customAnimationDemoTab).findElement(DemoFrame));
		util.minWaitForElementToBeVisible(driver, showLink);
		String toolTipTextShowLink = driver.findElement(showLink).getAttribute("title");
		System.out.println(toolTipTextShowLink);
		Assert.assertEquals("slide down on show", toolTipTextShowLink);
		
		util.minWaitForElementToBeVisible(driver, hideLink);
		String toolTipTextHideLink = driver.findElement(hideLink).getAttribute("title");
		System.out.println(toolTipTextHideLink);
		Assert.assertEquals("explode on hide", toolTipTextHideLink);
		
		util.minWaitForElementToBeVisible(driver, openEvent);
		String toolTipTextOpenEvent = driver.findElement(openEvent).getAttribute("title");
		System.out.println(toolTipTextOpenEvent);
		Assert.assertEquals("move down on show", toolTipTextOpenEvent);
		
		driver.switchTo().defaultContent();
		
		

	}catch(Exception e){
		e.printStackTrace();
		String testName = this.getClass().getEnclosingMethod().getName();
		logger.error("Exception in "+testName+" :", e);		
		util.captureScreeshot(logger,driver,testName);			
		}
	}
}
