package com.nagarro.base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nagarro.config.Configs;
import com.nagarro.config.Constants;
import com.nagarro.pages.LoginPage;
import com.nagarro.reporting.ExtentReportManager;
import com.nagarro.reporting.ScreenshotManager;
import com.nagarro.util.DriverManager;

public class BaseClass {
	
	public LoginPage loginPage;
	public ExtentReports extent = ExtentReportManager.getExtentInstance();
	public ExtentTest test;
	
	@BeforeSuite
	public void onSuiteStart() {
	    System.out.println("Test started in the following groups: "); // why this is not executed

	}
	
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void beforeEveryMethod(Method method, String strBrowser) {
        ExtentReportManager.startTest("Initiating test for : " + method.getName());
        System.out.println("Before method from base class");        
        launchBrowser(strBrowser);
        DriverManager.getDriver().get(Configs.getPropertyConfig(Constants.URL.getValue().toString()));
       loginPage = new LoginPage();
    }
	
    @AfterMethod(alwaysRun = true)
    public void afterEveryMethod(ITestResult result) {
        System.out.println("After method from base class");
        
        // Capture if test fails due to an assertion error or other reasons
        if(result.getStatus() == ITestResult.FAILURE) {
            // Log failure message in ExtentReports
            Throwable throwable = result.getThrowable();
            if (throwable instanceof AssertionError) {
                ExtentReportManager.reportFailure(result.getName() + " Test Failed due to AssertionError: " + throwable.getMessage());
            } else {
                ExtentReportManager.reportFailure(result.getName() + " Test Failed: " + throwable.getMessage());
            }

            // Capture screenshot on failure
            try {
                String screenshotPath = ScreenshotManager.captureScreenshot(result.getName());
                // Attach the screenshot to the Extent report
                ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                // Log if screenshot capture fails
                ExtentReportManager.reportFailure("Failed to capture screenshot: " + e.getMessage());
            }
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportManager.reportPass(result.getName() + " Test Success");
        }

        // End the test in ExtentReport
        ExtentReportManager.endTest();
        DriverManager.getDriver().quit();
    }

	
	
	public WebDriver launchBrowser(String strBrowser) {		
		DriverManager.initDriver(strBrowser);
		DriverManager.getDriver().manage().window().maximize();
		return DriverManager.getDriver();
	}
	
	
	@AfterSuite
	public void onFinish(ITestContext context) {
	    System.out.println("Finished executing tests.");
	    System.out.println("Passed tests: " + context.getPassedTests().size());
	    System.out.println("Failed tests: " + context.getFailedTests().size());
	    System.out.println("Skipped tests: " + context.getSkippedTests().size());
	}

	

}
