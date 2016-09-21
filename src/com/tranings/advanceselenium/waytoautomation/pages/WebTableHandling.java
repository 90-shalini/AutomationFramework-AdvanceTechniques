package com.tranings.advanceselenium.waytoautomation.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableHandling {
	//Class to handle functionality of web tables
	public void webTableHandle(WebDriver driver, Logger logger){
		WebElement mytable = driver.findElement(By.xpath(".//*[@id='post-body-8228718889842861683']/div[1]/table/tbody"));
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row=0; row<rows_count; row++){
			   //To locate columns(cells) of that specific row.
			   List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			   //To calculate no of columns(cells) In that specific row.
			   int columns_count = Columns_row.size();
			   System.out.println("Number of cells In Row "+row+" are "+columns_count);
			   
			   //Loop will execute till the last cell of that specific row.
			   for (int column=0; column<columns_count; column++){
			    //To retrieve text from that specific cell.
			    String celtext = Columns_row.get(column).getText();
			    System.out.println("Cell Value Of row number "+row+" and column number "+column+" Is "+celtext);
			   }
	}
}
}
