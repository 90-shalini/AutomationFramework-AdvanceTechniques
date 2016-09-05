package com.tranings.advanceselenium.waytoautomation.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class Utils {
	/*---------------Wait for element to be visible function---------------*/
	public void minWaitForElement(WebDriver driver,By element)	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		//should return value or error
	}
	/*---------------Switch to frame---------------------------------------*/
	//Frame 
	public void switchToFrame(WebDriver driver,By FrameElement){
		minWaitForElement(driver, FrameElement);
		driver.switchTo().frame(driver.findElement(FrameElement));
		
	}
	/*---------------Wait for element to be visible function---------------*/
	public void minWaitForElementToBeVisible(WebDriver driver,By element)	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		//should return value or error

	}
	/*---------------capture screenshot function---------------*/
	public void captureScreeshot(Logger logger,WebDriver driver,String testName)
	{
		//if(result.getStatus()==ITestResult.FAILURE)
		//{
			//destination where screenshot is saved
		
			String screenshotDestination = Screenshot.takeSnapShot(driver, testName); 
			
			//logger.log(LogStatus.FAIL, "Way to Automation");// logger. .addScreenCapture(screenshotDestination));
		//}
	}

}
