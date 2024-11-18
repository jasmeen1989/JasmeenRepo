package com.nagarro.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class practice1 {

	@Test(groups= "smoke")
	public void method1() {
		System.out.println("Method1- practice");
	}
	
	@Test(groups= "regression")
	public void method2() {
		System.out.println("Method2- practice");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeMethods() {
		System.out.println("Before Method");
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterMethods() {
		System.out.println("After Method");
	}
	
	@BeforeClass(alwaysRun = true)
	public void BeforeClasses() {
		System.out.println("Before CLass");
	}
	
	@AfterClass(alwaysRun = true)
	public void AfterCLasses() {
		System.out.println("After CLass");
	}
	
	@BeforeTest
	public void BeforeTests() {
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void AfterTests() {
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void onSuiteStart() {
	    System.out.println("Test started in the following groups: "); // why this is not executed

	}
	
}

