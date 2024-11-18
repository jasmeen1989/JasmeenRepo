package com.nagarro.tests;

import org.testng.annotations.Test;

import com.nagarro.base.BaseClass;
import com.nagarro.pages.AlertPage;

public class Test_Alerts extends BaseClass {
	
	@Test
	public void checkAlerts() throws InterruptedException {
		
		AlertPage ap = new AlertPage();
		//ap.alert1();
		//ap.alert2();
		//ap.alert3();- check with gurki
		//ap.alert4();
		ap.selectfromList();
	}

}
