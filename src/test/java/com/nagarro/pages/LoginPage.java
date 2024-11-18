package com.nagarro.pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.nagarro.reporting.ExtentReportManager;
import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class LoginPage  {
	
	private WebDriver driver;
	private Web_Lib webLib;
	
    private final String[] loc_UserName   = { "id", "user-name" };
    private final String[] loc_Password   = { "id", "password" };
    private final String[] loc_Login      = { "id", "login-button" };
    private final String[] loc_ThreeStrip = { "id", "react-burger-menu-btn" };
    private final String[] loc_Logout     = { "id", "logout_sidebar_link" };
    
	public LoginPage() {
		this.driver = DriverManager.getDriver();
		this.webLib = new Web_Lib();
		
	}
	
	
	public void setUserName(final String strUserName) {
		ExtentReportManager.reportInfoMsg("Setting user Name");
        webLib.setText(loc_UserName, strUserName);
    }

    public void setPassword(final String strPassword) {
        //logger.logInfo("Entering password :" + strPassword);
        webLib.setText(loc_Password, strPassword);
    }

    public ProductsPage clickLogin() {
        //logger.logInfo("Click Login button on Login page");
        webLib.click(loc_Login);
        webLib.waitForURLContains("inventory.html", 10);
        final ProductsPage proPage = new ProductsPage();
        return proPage;
    }
    
    public ProductsPage login(String strUserName, String strPassword) {
    	setUserName(strUserName);
    	setPassword(strPassword);
    	return clickLogin();
    	
    	
    }
   

}
