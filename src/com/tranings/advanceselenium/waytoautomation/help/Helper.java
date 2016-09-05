package com.tranings.advanceselenium.waytoautomation.help;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.tranings.advanceselenium.waytoautomation.pages.DemoSite;
import com.tranings.advanceselenium.waytoautomation.pages.HomePage;
import com.tranings.advanceselenium.waytoautomation.pages.LoginPage;

public class Helper {

	public void navigateToDemoSite(WebDriver driver,String name, String password){
		//direct to Demo Page
		HomePage home = new HomePage();
		home.directToDemoSite(driver);
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		//click on element to navigate to login page
		DemoSite demo = new DemoSite();
		demo.clickTestingElement(driver,demo.Selectable );
		windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windows.get(2));
		driver.manage().window().maximize();	
		//Perform login functionality
		LoginPage login = new LoginPage();
		login.SignUp(driver, name, password);
		

	}


}