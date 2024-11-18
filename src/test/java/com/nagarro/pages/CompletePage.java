package com.nagarro.pages;

import org.openqa.selenium.WebDriver;

import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class CompletePage {

	
	private WebDriver driver;
	private Web_Lib weblib;
	
	public CompletePage() {
		this.driver = DriverManager.getDriver();
		this.weblib = new Web_Lib();
		
	}
	
	
	private final String [] lochome = {"id","back-to-products"};
	
	
		
	
	public ProductsPage clickHome() {
		ProductsPage objLogin = new ProductsPage();
		weblib.click(lochome);
		return objLogin;
		
	}
}
