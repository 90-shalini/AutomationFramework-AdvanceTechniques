package com.tranings.advanceselenium.waytoautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class DemoSite {
	Utils util = new Utils();
	//Interaction Elements
	public By Selectable = By.xpath("//h2[contains(text(),'Selectable')]");
	public By Draggable = By.xpath("//h2[contains(text(),'Draggable')]");
	public By Droppable = By.xpath("//h2[contains(text(),'Droppable')]");
	public By Resizable = By.xpath("//h2[contains(text(),'Resizable')]");
	public By Sortable = By.xpath("//h2[contains(text(),'Sortable')]");
	//Widget
	public By Accordion = By.xpath("//h2[contains(text(),'Accordion')]");
	public By Autocomplete = By.xpath("//h2[contains(text(),'Autocomplete')]");
	public By Datepicker = By.xpath("//h2[text()[contains(.,'Datepicker')]]");
			//By.xpath("//h2[contains(text(),'Datepicker')]");
	public By Menu = By.xpath("//h2[contains(text(),'Menu')]");
	public By Slider = By.xpath("//h2[contains(text(),'Slider')]");
	public By Tabs = By.xpath("//h2[contains(text(),'Tabs')]");
	public By Tooltip = By.xpath("//h2[contains(text(),'Tooltip')]");
	//Frame and windows
	public By FramesAndWindows = By.xpath("//h2[contains(text(),'Frames and Windows')]");
	//Dynamic Elements
	public By SubmitButtonClicked = By.xpath("//h2[contains(text(),'Submit Button Clicked')]");
	public By Dropdown = By.xpath("//h2[contains(text(),'Dropdown')]");
	//Registration
	public By Registration = By.xpath("//h2[contains(text(),'Registration')]");
	//Alert
	public By Alert = By.xpath("//h2[contains(text(),'Alert')]");
	
	public void clickTestingElement(WebDriver driver,By element){
		util.minWaitForElement(driver, element);
		driver.findElement(element).click();
	}
	
	
}
