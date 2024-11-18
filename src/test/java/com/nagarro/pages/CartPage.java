package com.nagarro.pages;

import org.openqa.selenium.WebDriver;

import com.nagarro.reporting.ExtentReportManager;
import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class CartPage {

	 private WebDriver driver;
	 private Web_Lib weblib ;
	 
	 public CartPage() {
			this.driver = DriverManager.getDriver();
			this.weblib = new Web_Lib();
			
		}
	
	 
	 //locators
	  private final String[]  checkout     = { "id", "login-checkout" };
	 
	  public  CheckoutPage checkout() {
		  weblib.click(checkout);
		  CheckoutPage checkPage = new CheckoutPage();
		  return checkPage;
		  
	    }
	  
	 
	
}
