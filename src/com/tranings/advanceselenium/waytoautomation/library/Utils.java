package com.tranings.advanceselenium.waytoautomation.library;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

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
	/*---------------check any element is NULL-----------------*/
	public Boolean isNull(WebElement element)
	{
		if(element==null)
			return true;
		else return false;
	}
	/*---------------capture screenshot function---------------*/
	public void captureScreeshot(Logger logger,WebDriver driver,String testName)
	{
		//if(result.getStatus()==ITestResult.FAILURE)
		//{
			//destination where screenshot is saved
			String screenshotDestination = Screenshot.takeSnapShot(driver,testName,logger); 
		
			System.out.println("screenshot destination:"+screenshotDestination);
			Reporter.setEscapeHtml(false);
		//	Reporter.log("<img src=\"file:///" + screenshotDestination+ "\" alt=\"testPic\" " + "height=\"200\" width=\"200\"" + " />");
			Reporter.log("<a href=" + screenshotDestination	+ ">Detailed Error Screen</a><p>error screenshot</p>");
//			logger.info("PNG browser snapshot file name: \"{}\"", screenshotDestination.toURI().toString());
			// logger. .addScreenCapture(screenshotDestination));
		//}
			
	}

}
