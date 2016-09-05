package com.tranings.advanceselenium.waytoautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	By DemoLink=By.linkText("Demo Site");
	public void directToDemoSite(WebDriver driver){
		driver.findElement(DemoLink).click();
		
	}
	
}
