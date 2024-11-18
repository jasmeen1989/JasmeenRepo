package com.nagarro.pages;

import org.openqa.selenium.WebDriver;

import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class InvoicePag {
	
	private WebDriver driver;
	private Web_Lib weblib ;
	
	public InvoicePag() {
		this.driver = DriverManager.getDriver();
		this.weblib = new Web_Lib();
		
	}
	
	private final String [] finish = {"id","finish"};
	
	public CompletePage finish() {
		
		weblib.click(finish);
		CompletePage completePage = new CompletePage();
		return completePage;
	}

}
