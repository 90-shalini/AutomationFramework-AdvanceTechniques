package com.tranings.advanceselenium.waytoautomation.pages;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class DatePicker {
	String yearValue = "2017";
	String dayValue = "11";
	By datePickerLink = By.linkText("Datepicker");
	By defaultFuncTab = By.id("example-1-tab-1");
	By animationTab = By.id("example-1-tab-2");
	By displayMonthYearTab = By.id("example-1-tab-3");
	By formatDateTab = By.id("example-1-tab-4");	
	By DemoFrame = By.className("demo-frame");
	
	By defaultFunctionalityLink= By.linkText("DEFAULT FUNCTIONALITY");
	By animationLink= By.linkText("ANIMATIONS");
	By displayMonthYearLink = By.linkText("DISPLAY MONTH & YEAR");
	By formatDateLink = By.linkText("FORMAT DATE");
	
	By dateInput = By.id("datepicker");
	By animationDropDown = By.id("anim");
	By calenderMonth= By.className("ui-datepicker-month");
	By calenderYear = By.className("ui-datepicker-year");
	By formatOptions= By.id("format");
	By Day = By.linkText(dayValue);
	Utils util = new Utils();



	public void pickDate(WebDriver driver,Logger logger){

		try{

			//clicking on DatePicker Widget
			util.minWaitForElementToBeVisible(driver, datePickerLink);
			driver.findElement(datePickerLink).click();

			//Default Functionality
			logger.info("pickDate->Default Functionality:");
			System.out.println("Today's Date Testing: "+new Date().toString());
			util.minWaitForElementToBeVisible(driver, defaultFunctionalityLink);
			driver.findElement(defaultFunctionalityLink).click();
			driver.switchTo().frame(driver.findElement(defaultFuncTab).findElement(DemoFrame));		
			util.minWaitForElementToBeVisible(driver, dateInput);
			driver.findElement(dateInput).sendKeys("05/03/2016");
			driver.findElement(dateInput).sendKeys("ENTER");
			//driver.findElement(dateInput).sendKeys("TAB");
			driver.switchTo().defaultContent();


			//Animation Tab
			logger.info("pickDate->Animation Functionality:");
			util.minWaitForElementToBeVisible(driver, animationLink);
			driver.findElement(animationLink).click();
			driver.switchTo().frame(driver.findElement(animationTab).findElement(DemoFrame));	
			util.minWaitForElementToBeVisible(driver, dateInput);	
			driver.findElement(dateInput).click();// .sendKeys("05/03/2016");
			//driver.findElement(dateInput).sendKeys("KEYS.ENTER");
			WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> days =dateWidget.findElements(By.tagName("td"));
			System.out.println(days.size());
			for(WebElement day:days){
				if(day.getText().equals("10")){
					System.out.println("got date");
					day.click();
				break;
				}
			}
			Select animations= new Select(driver.findElement(animationDropDown));
			animations.selectByValue("fadeIn");
			animations.selectByIndex(8);
			driver.switchTo().defaultContent();

			//Display Month and Year
			logger.info("pickDate->Display Month and Year Functionality:");
			util.minWaitForElementToBeVisible(driver, displayMonthYearLink);
			driver.findElement(displayMonthYearLink).click();
			driver.switchTo().frame(driver.findElement(displayMonthYearTab).findElement(DemoFrame));
			util.minWaitForElementToBeVisible(driver, dateInput);	
			driver.findElement(dateInput).click();
			Select month = new Select(driver.findElement(calenderMonth));
			month.selectByValue("10");
			Select year = new Select(driver.findElement(calenderYear));
			year.selectByValue(yearValue);
			driver.findElement(Day).click();
			System.out.println("Selected Date:" +driver.findElement(dateInput).getText());
			driver.switchTo().defaultContent();


			//format Date
			logger.info("pickDate->Format Date Functionality:");
			util.minWaitForElementToBeVisible(driver, formatDateLink);
			driver.findElement(formatDateLink).click();
			driver.switchTo().frame(driver.findElement(formatDateTab).findElement(DemoFrame));
			Select formatOptionsDropDown = new Select(driver.findElement(formatOptions));
			formatOptionsDropDown.selectByValue("d MM, y");
			util.minWaitForElementToBeVisible(driver, dateInput);			
			System.out.println("Date in special format: "+driver.findElement(dateInput).getText());
			driver.switchTo().defaultContent();
		}
		catch(Exception e){
			e.printStackTrace();
			String testName = this.getClass().getEnclosingMethod().getName();
			util.captureScreeshot(logger,driver,testName);

		}


	}
	
}
