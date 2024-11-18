package com.nagarro.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectorHub {
	
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
	
		//Web_Lib weblib = new Web_Lib();
		//List<WebElement> buttons = weblib.getElements("tagname", "button");
		List<WebElement> buttons = 	driver.findElements(By.tagName("button"));
		System.out.println(buttons.size());
		for(WebElement button: buttons) {
			System.out.println(button.getAttribute("value"));
		
	}
		
		

	}

}
