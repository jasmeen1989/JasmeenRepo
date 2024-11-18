package com.nagarro.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.nagarro.base.BaseClass;
import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class SelectorHub extends BaseClass {
	
	private WebDriver driver;
	private Web_Lib weblib ;
	
	 
	 public SelectorHub() {
			this.driver = DriverManager.getDriver();
			this.weblib = new Web_Lib();
			
		}

	 @Test
	public void getButtons() {
		
		List<WebElement> buttons = weblib.getElements("tagname", "button");
		for(WebElement button: buttons) {
			System.out.println(button);
		}
		
		
	}
	
}
