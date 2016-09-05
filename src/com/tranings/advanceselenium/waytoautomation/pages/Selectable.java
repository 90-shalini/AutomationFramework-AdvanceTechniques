package com.tranings.advanceselenium.waytoautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.log4j.Logger;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class Selectable {
	//By heading = By.xpath("//h1[contains(text(),'Selectable')]");
	By DemoFrame = By.className("demo-frame");
	By defaultFunctionality = By.linkText("Default functionality");
	By bottomDiv = By.className("container margin-top-20");
	By selectableLink = By.linkText("Selectable");
	By displayAsGridLinkTab= By.linkText("DISPLAY AS GRID");
	By seralizeTab= By.linkText("SERIALIZE");
	By getItemNumber = By.id("select-result");
	By defaultFuncTab = By.id("example-1-tab-1");
	By displayGridTab = By.id("example-1-tab-2");
	By serializeExampleTab = By.id("example-1-tab-3");

	
	Utils util = new Utils();
	
	public void Select(WebDriver driver,Logger logger){

		try{
			//clicking on Selectable element
			util.minWaitForElementToBeVisible(driver, selectableLink);
			driver.findElement(selectableLink).click();
			
			//perform select on Default Functionality
			logger.info("Select->Default Functionality:");
			util.minWaitForElementToBeVisible(driver, DemoFrame);
			driver.switchTo().frame(driver.findElement(defaultFuncTab).findElement(DemoFrame));
			clickItem("Item 4", driver);
			driver.switchTo().defaultContent();
			
			//perform select on display as grid	
			logger.info("Select->Display as grid:");
			util.minWaitForElementToBeVisible(driver,displayAsGridLinkTab);
			driver.findElement(displayAsGridLinkTab).click();
			driver.switchTo().frame(driver.findElement(displayGridTab).findElement(DemoFrame));
			clickItem("6", driver);
			driver.switchTo().defaultContent();
			
			//perform select on serialize
			logger.info("Select->Serialize:");
			util.minWaitForElementToBeVisible(driver,seralizeTab);
			driver.findElement(seralizeTab).click();
			driver.switchTo().frame(driver.findElement(serializeExampleTab).findElement(DemoFrame));
			clickItem("Item 2", driver);
			System.out.println(driver.findElement(getItemNumber).getText());
			driver.switchTo().defaultContent();
			//Assert.assertEquals("Selectable", driver.findElement(heading).getText());
			
			
			

		}catch(Exception e){
			e.printStackTrace();
			logger.error("Exception in Selectable:", e);
			String testName = this.getClass().getEnclosingMethod().getName();
			util.captureScreeshot(logger,driver,testName);			
			}


	}

	public void clickItem(String itemName,WebDriver driver){
		By item = By.xpath("//li[contains(text(),'"+itemName+"')]");
		try {
			util.minWaitForElementToBeVisible(driver,item);
			WebElement itemToClick = driver.findElement(item);				
			itemToClick.click();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
