package com.nagarro.pages;

import org.openqa.selenium.WebDriver;

import com.nagarro.reporting.ExtentReportManager;
import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class CheckoutPage {

	private WebDriver driver;
	private Web_Lib weblib ;
	
	public CheckoutPage() {
		this.driver = DriverManager.getDriver();
		this.weblib = new Web_Lib();
		
	}
	
	//locators
	private final String[] locfirstName = {"id","first-name"};
	private final String[] loclastName = {"id","last-name"};
	private final String[] locpostalCode = {"id","postal-code"};
	private final String[] loccontinueButton = {"id","postal-code"};
	
	public  InvoicePag checkout() {
		  weblib.click(loccontinueButton);
		  InvoicePag objInvoicePag = new InvoicePag();
		  return objInvoicePag;
		  
		 	    }
	
		
	public void setFirstName(final String strFirstName) {
		ExtentReportManager.reportInfoMsg("Setting first Name");
        weblib.setText(locfirstName, strFirstName);
    }
	
	public void setLastName(final String strLastName) {
		ExtentReportManager.reportInfoMsg("Setting last Name");
        weblib.setText(loclastName, strLastName);
    }
	
	public void setPostalCode(final String strPostalCode) {
		ExtentReportManager.reportInfoMsg("Setting postal code");
        weblib.setText(locpostalCode, strPostalCode);
    }
	
	
}
