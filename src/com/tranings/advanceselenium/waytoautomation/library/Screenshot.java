package com.tranings.advanceselenium.waytoautomation.library;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class Screenshot{

	public static String takeSnapShot(WebDriver driver,String screenshotName,Logger logger){
		try{
			//Convert web driver object to TakeScreenshot
			TakesScreenshot screenShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			//	Date today = new Date();
			File SrcFile=screenShot.getScreenshotAs(OutputType.FILE);
			//screenshotName = screenshotName;
			//making fileName at destination
			String destination="D:\\Trainings\\advanceSelenium\\AutomationFrameworkAdvancedTechniques\\Screenshot\\"+screenshotName+ ".png";
			//Copy file at destination
			FileUtils.copyFile(SrcFile, new File(destination));
			Reporter.setEscapeHtml(false);
			Reporter.log("<a href=" + destination	+ ">Detailed Error Screen</a><p>error screenshot</p>");			
			//logger.info("PNG browser snapshot file name: \"{}\"", SrcFile.toURI().t);
//			Reporter.log("<a href="+"file://&quot;"+"target="+"_blank>" + destination + "</a>");

			return destination;

	}    

		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while taking screenshot");
			return e.getMessage();
		}
	}

	
}
