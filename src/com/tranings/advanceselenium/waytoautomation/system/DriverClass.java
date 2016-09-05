package com.tranings.advanceselenium.waytoautomation.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {


	public WebDriver getBrowser(String browserType){

		if(browserType.equalsIgnoreCase("FIREFOX"))
			return new FirefoxDriver();
		else if(browserType.equalsIgnoreCase("CHROME")){
			return new ChromeDriver();
		}else
			return null;
	}
	//	private static WebDriver driver = null;
	//		private Driver(){			
	//		}
	//	
	//		public static WebDriver getInstance(){
	//			String browser;
	//			Properties properties = new Properties();
	//			try {
	//				InputStream inputProperties= new FileInputStream(".\\config\\config.properties");
	//				properties.load(inputProperties);
	//				browser = properties.getProperty("BROWSER");
	//				if((driver == null) && (browser.equalsIgnoreCase("FIREFOX")))
	//					 driver = new FirefoxDriver();
	//				else if((driver == null) && (browser.equalsIgnoreCase("CHROME"))){
	//					// handling chrome
	//				}
	//				
	//			} catch (FileNotFoundException e) {
	//				e.printStackTrace();
	//			}catch (IOException e) {
	//				e.printStackTrace();
	//			}
	//			
	//			return driver;
	//		}


}
