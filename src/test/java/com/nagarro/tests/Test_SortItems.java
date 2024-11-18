package com.nagarro.tests;

import com.nagarro.base.BaseClass;
import com.nagarro.config.Configs;
import com.nagarro.pages.ProductsPage;

public class Test_SortItems extends BaseClass{

	public ProductsPage proPage;
	
	public void testSortItems() {
		
		proPage = loginPage.login(Configs.getPropertyInputData("username"),Configs.getPropertyInputData("password"));
		proPage.sortedList();
		
	}
	
	
	
	
}
