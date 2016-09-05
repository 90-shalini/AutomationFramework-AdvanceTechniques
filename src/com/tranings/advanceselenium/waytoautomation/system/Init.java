package com.tranings.advanceselenium.waytoautomation.system;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tranings.advanceselenium.waytoautomation.help.Helper;
import com.tranings.advanceselenium.waytoautomation.library.Mailer;
import com.tranings.advanceselenium.waytoautomation.library.Utils;


public class Init {
	public static WebDriver driver; 
	Utils util = new Utils();
	
	public static WebDriver initiate(){				
		String name= "vibhor", password="password123";			
		driver =startBrowser();
		Helper hlp = new Helper();
		hlp.navigateToDemoSite(driver,name,password);
		return driver;
		
	}
	public static WebDriver startBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");		
		return driver;
	}
	public static void sendMail(Logger logger){
	//close all reports		
	//send mail
	
	//Mailer.sendReportByGMail();

	//report.endTest(logger);
	//report.flush();
}
	public void closeBrowser(WebDriver driver,Logger logger){	
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		try{
			if(windows != null){
				for(int i=0; i<windows.size();i++){
					driver.switchTo().window(windows.get(i));
					driver.close();
				}
				windows = null;
			}
			System.out.println("closed all browsers....");
		}
		catch(Exception e){
			String testName = Class.class.getEnclosingMethod().getName();
			System.out.println("TestName: " +testName);
			util.captureScreeshot(logger,driver,testName);
			
		}
		finally{
			if(windows != null){
				for(int i=0; i<windows.size();i++){
					driver.switchTo().window(windows.get(i));
					driver.close();
				}
			}
		}

	}


}	
