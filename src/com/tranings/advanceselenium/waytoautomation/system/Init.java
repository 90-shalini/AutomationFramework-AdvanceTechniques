package com.tranings.advanceselenium.waytoautomation.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.tranings.advanceselenium.waytoautomation.help.Helper;
import com.tranings.advanceselenium.waytoautomation.library.Mailer;
import com.tranings.advanceselenium.waytoautomation.library.Utils;;


public class Init {
	static WebDriver driver = null;
	Utils util = new Utils();
	DriverClass d = new DriverClass();

	public WebDriver initiate(){	
		String browser,username=null,password=null;
		Properties properties = new Properties();
		try {
			InputStream inputProperties= new FileInputStream(".\\config\\config.properties");
			properties.load(inputProperties);
			browser = properties.getProperty("BROWSER");
			username= properties.getProperty("USERNAME");
			password=properties.getProperty("PASSWORD");
			driver = d.getBrowser(browser);
			driver.manage().window().maximize();
			driver.get("http://www.way2automation.com/");	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}				
		
		Helper hlp = new Helper();
		hlp.navigateToDemoSite(driver,username,password);
		return driver;

	}
	
	public void sendMail(Logger logger){
		//close all reports		
		//send mail
		logger.info("Inside Init sendMail function");
		Mailer.sendReportByGMail();

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
