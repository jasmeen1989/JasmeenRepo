package com.nagarro.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nagarro.reporting.ExtentReportManager;
import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class ProductsPage {

    private final WebDriver          driver;
    private final Web_Lib            webLib;
 

    // locators
    private final String[] loc_SelectDropDown = { "xpath", "//select[@data-test='product-sort-container']" };
    // private final String[] loc_Password = { "id", "password" };
    private final String[] loc_ProductsPrice = { "xpath", "//div[@data-test='inventory-item-price']" };

    private final String[] loc_ProductsName = {"xpath","//div[@data-test='inventory-item-name']"};
    private final String[] loc_AddtoCart = { "id", "add-to-cart-sauce-labs-onesie" };

    private final String[] loc_CartLink = { "xpath", "//a[@data-test='shopping-cart-link']" };

    private final String[] loc_Login      = { "id", "login-button" };
    private final String[] loc_ThreeStrip = { "id", "react-burger-menu-btn" };
    private final String[] loc_Logout     = { "id", "logout_sidebar_link" };

    public ProductsPage() {
        this.driver = DriverManager.getDriver();
		this.webLib = new Web_Lib();

    }

    public boolean verifyUserOnProductsPage() {
    	ExtentReportManager.reportInfoMsg("Verifying text Products");
        return webLib.checkElementPresent("xpath", "//span[text()='Products']");
    }

    public void setLowToHighFilter() {
        webLib.selectItemDropDown(loc_SelectDropDown, "Price (low to high)");

    }

    public boolean verifyProductsAreSorted() {
        final List<WebElement> listPrice = webLib.getElements(loc_ProductsPrice);

        final List<Float> listArra = new ArrayList();
        for (int i = 0; i < listPrice.size(); i++) {
            String strPrice = listPrice.get(i).getText();
            final float floatPrice = Float.parseFloat(strPrice);
            listArra.add(floatPrice);
        }

        if (listArra.stream().sorted().toList().equals(listArra)) {
            //logger.logInfo("The Filter prices are sorted correctly");
            return true;
        } else {
            //logger.logWarning("The Filter prices are NOT sorted correctly");
            return false;
        }

    }
    
    public void sortedList() {
    	
    	List<WebElement> webelements= webLib.getElements(loc_ProductsName);
    	boolean isSorted = isSorted(webelements);
    	if(isSorted) {
    		System.out.println("sorted");
    	}
    	else {
    		System.out.println("not sorted");
    	}
		
    	
    	
    }
    
    
    
    public boolean isSorted(List<WebElement> elements) {
		
    	String previous = elements.get(0).getText();
    	for(int i=1;i<elements.size();i++) {
    		String current = elements.get(i).getText();
    		if(previous.compareTo(current)>0) {
    			return false;
    		}
    		previous = current;
    	}
    	
    return true;
    	
    	
    }

    public boolean verifyBrokenLinks() {
        final List<WebElement> listLinks = webLib.getElements("xpath", "//a");
        boolean brokenLink = false;
        final List<String> listArra = new ArrayList();
        for (int i = 0; i < listLinks.size(); i++) {
            final String strURL = listLinks.get(i).getText();
            if (strURL.isBlank() || strURL.isEmpty()) {
                listArra.add(strURL);
                brokenLink = true;
            }
        }
        if (brokenLink) {
            //logger.logWarning("Broken links are :" + listArra.size());
        }
        return brokenLink;

    }

    public void addRandomItemToCart() {
        webLib.click(loc_AddtoCart);
    }

    public void gotoCart() {
    	webLib.click(loc_CartLink);
    }
    
    public boolean logout() {
        //logger.logInfo("Logout check");
        webLib.click(loc_ThreeStrip);
        webLib.click(loc_Logout);
        if (webLib.checkElementPresent(loc_Login)) {
            return true;
        } else {
            return false;
        }

    }
    
    public ProductsPage clickLogin() {
        //logger.logInfo("Click Login button on Login page");
        webLib.click(loc_Login);
        webLib.waitForURLContains("inventory.html", 10);
        final ProductsPage proPage = new ProductsPage();
        return proPage;
    }
    
 public CartPage clickCart() {
	 ExtentReportManager.reportInfoMsg("Clicking on the cart link");
	 webLib.click(loc_CartLink);
	 CartPage objcartPage = new CartPage();
	 return objcartPage;
    	
    	
    }

}


