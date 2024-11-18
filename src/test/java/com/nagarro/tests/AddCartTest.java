package com.nagarro.tests;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.nagarro.base.BaseClass;
import com.nagarro.config.Configs;
import com.nagarro.pages.CartPage;
import com.nagarro.pages.CheckoutPage;
import com.nagarro.pages.CompletePage;
import com.nagarro.pages.InvoicePag;
import com.nagarro.pages.ProductsPage;


   
public class AddCartTest extends BaseClass {
	public ProductsPage proPage;
	public CartPage objcartPage;
	public CheckoutPage checkPage;
	public InvoicePag invoicePage;
	public CompletePage completePage;

	@Test
	 public void test01AddToCart(ITestContext context) {

	            

	     //login
		proPage = loginPage.login(Configs.getPropertyInputData("username"),Configs.getPropertyInputData("password"));
	        
	        proPage.addRandomItemToCart();
	        objcartPage = proPage.clickCart();	        
	        checkPage= objcartPage.checkout();
	        checkPage.setFirstName(Configs.getPropertyInputData("firstname"));
	        checkPage.setLastName(Configs.getPropertyInputData("lastname"));
	        checkPage.setPostalCode(Configs.getPropertyInputData("postalcode"));     
	        
	        invoicePage = checkPage.checkout();
	        completePage = invoicePage.finish();
	        
	       completePage.clickHome();
	        

	       
}
}

