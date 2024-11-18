package com.nagarro.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	private static WebDriver driver;
	
	private static final ThreadLocal<WebDriver> tl_driver = new ThreadLocal<WebDriver>();
	
	private DriverManager() {
		//singleton design pattern
	}
	
	
	public static void initDriver(String strBrowser) {
		
		switch(strBrowser.toLowerCase()) {
		
		case "chrome":
			ChromeOptions cm = new ChromeOptions();
			cm.addArguments("--disable-extensions");
			cm.addArguments("--incognito");
			tl_driver.set(new ChromeDriver(cm));
			break;
			
		case "edge":
			tl_driver.set(new EdgeDriver());
			
		case "firefox":
			tl_driver.set(new FirefoxDriver());
			
		
		
		}
		driver = getDriver();
		
	}
	
	public static WebDriver getDriver() {
		return tl_driver.get();
	}

}
