package com.tranings.advanceselenium.waytoautomation.library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static String takeSnapShot(WebDriver driver,String screenshotName){
		try{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot screenShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
		//	Date today = new Date();
			File SrcFile=screenShot.getScreenshotAs(OutputType.FILE);
			//screenshotName = screenshotName;
			//making fileName at destination
			String destination="D:\\Trainings\\advanceSelenium\\WayToAutomation\\Screenshot\\"+screenshotName+ ".png";
			
			//Copy file at destination
			FileUtils.copyFile(SrcFile, new File(destination));
			System.out.println("Screenshot Captured");
			return destination;

	}    

		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while taking screenshot");
			return e.getMessage();
		}
	}
}
