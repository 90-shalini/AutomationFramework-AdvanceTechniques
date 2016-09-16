package com.tranings.advanceselenium.waytoautomation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class LoginPage {	
	By loginDiv = By.id("login");
	By userName=By.name("username");// By.cssSelector(".fancybox-wrap.fancybox-desktop.fancybox-type-inline.fancybox-opened input[name='username']");
	By passWord =By.name("password");
	By loginButton =By.className("button");//By.cssSelector(".fancybox-wrap.fancybox-desktop.fancybox-type-inline.fancybox-opened input[value='Submit']");
	By signInButton =By.linkText("Signin");//By.cssSelector("a[href='#login']");

	public void SignUp(WebDriver driver,String name,String password,Logger logger){
		try{
		Utils util = new Utils();
		util.minWaitForElementToBeVisible(driver, signInButton);
		driver.findElement(signInButton).click();
		util.minWaitForElementToBeVisible(driver, loginDiv);
		driver.findElement(loginDiv).findElement(userName).sendKeys(name);
		driver.findElement(loginDiv).findElement(passWord).sendKeys(password);
		driver.findElement(loginDiv).findElement(loginButton).click();
		}catch(WebDriverException wde){
			logger.error(wde.getMessage());
		}
		
	}





}
