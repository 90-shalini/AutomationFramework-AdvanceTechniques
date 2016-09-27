package com.tranings.advanceselenium.waytoautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class ActionInteraction{
	Utils util = new Utils();
	By dragItem = By.id("draggable");
	By defaultFuncTab = By.id("example-1-tab-1");
	By draggableLink = By.linkText("Draggable");
	By defaultFunctionalityLink= By.linkText("DEFAULT FUNCTIONALITY");
	By DemoFrame = By.className("demo-frame");
		public void dragDrop(WebDriver driver, Logger logger){
			try{
				//clicking on Draggable Widget
				util.minWaitForElementToBeVisible(driver, draggableLink);
				driver.findElement(draggableLink).click();
				
				//Default Functionality
				logger.info("draggable->Default Functionality started:");
				util.minWaitForElementToBeVisible(driver, defaultFunctionalityLink);
				driver.findElement(defaultFunctionalityLink).click();
				driver.switchTo().frame(driver.findElement(defaultFuncTab).findElement(DemoFrame));		
				util.minWaitForElementToBeVisible(driver, dragItem);

			
			Actions action = new Actions(driver);
			Action dragDrop = action.clickAndHold(driver.findElement(dragItem)).moveByOffset(50, 50).build();
//					action.clickAndHold(FromElement) .moveToElement(ToElement).release().build();
			dragDrop.perform();
			}
			catch(NoSuchElementException|ElementNotVisibleException|TimeoutException|NullPointerException e){
				String testName = this.getClass().getName().substring(51);
				util.captureScreeshot(logger,driver,testName);
				logger.info(e.getCause());
			}
			
			
			
		}
}
