package com.tranings.advanceselenium.waytoautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionInteraction{
	By From = By.linkText("Submit Button Clicked");
	By To = By.id("example-1-tab-1");	
	
		public void dragAndDrop(WebDriver driver, Logger logger){
			WebElement FromElement = driver.findElement(From);
			WebElement ToElement = driver.findElement(To);
			Actions action = new Actions(driver);
			Action dragDrop = action.clickAndHold(FromElement).moveToElement(ToElement).release().build();
			dragDrop.perform();
			
			
			
		}
}
