package com.tranings.advanceselenium.waytoautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class Alerts {
	By alertLink = By.linkText("Alert");
	By simpleAlertTab= By.linkText("SIMPLE ALERT");
	By inputAlertTab= By.linkText("INPUT ALERT");
	By Tab1 = By.id("example-1-tab-1");	
	By Tab2 = By.id("example-1-tab-2");	
	By DemoFrame = By.className("demo-frame");
	Utils util = new Utils();

	public void alertFunction(WebDriver driver,Logger logger){
		logger.info("Alert functionality started:");		
		util.minWaitForElementToBeVisible(driver, alertLink);
		driver.findElement(alertLink).click();

		logger.info("alertFunction->simple Alert Functionality:");		
		util.minWaitForElementToBeVisible(driver,simpleAlertTab);
		driver.findElement(simpleAlertTab).click();
		util.minWaitForElementToBeVisible(driver,Tab1);
		driver.switchTo().frame(driver.findElement(Tab1).findElement(DemoFrame));

		WebElement alertButton = driver.findElement(By.tagName("button"));
		//JavaScript Executor for button click functionality
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("myFunction();");
		driver.switchTo().alert().accept();
		//Other ways with javascript Executor
		//js.executeScript("arguments[0].click();", alertButton);
		//js.executeScript("document.getElementsByTagName('button').click();");
		//driver.findElement(By.tagName("button")).click();
		System.out.println("clicked");
		driver.switchTo().defaultContent();
		
		
		logger.info("alertFunction->simple Alert Functionality:");	
		util.minWaitForElementToBeVisible(driver,inputAlertTab);
		driver.findElement(inputAlertTab).click();
		util.minWaitForElementToBeVisible(driver,Tab2);
		driver.switchTo().frame(driver.findElement(Tab2).findElement(DemoFrame));
		js.executeScript("myFunction();");
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Shalini");
		alert.accept();
		System.out.println("inputted value and clicked");
		driver.switchTo().defaultContent();

		
		
	}
}
