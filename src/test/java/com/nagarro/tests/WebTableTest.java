package com.nagarro.tests;

import org.testng.annotations.Test;

import com.nagarro.base.BaseClass;
import com.nagarro.pages.CountriesPage;
import com.nagarro.util.DriverManager;



public class WebTableTest extends BaseClass {


	
	@Test
	public void fetchValue() {
		 CountriesPage cpage = new CountriesPage();
		System.out.println(cpage.getData("Australia", "Currency"));
		cpage.getAllRows("Country");
		cpage.getAllColumns();
}
}
