package com.nagarro.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.nagarro.config.Configs;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.util.Date;

public class ExtentReportManager {

    private static final String REPORTS_DIR = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Reports" + File.separator;
    private static final String EXTENT_REPORTS_HTML_PATH = REPORTS_DIR + "Results.html";
    private static final String EXTENT_CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "ReportsConfig.xml";
    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
    private static ExtentReports extent;

    static {
        File reportDir = new File(REPORTS_DIR);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Backup the existing report if it exists
        File existingReport = new File(EXTENT_REPORTS_HTML_PATH);
        if (existingReport.exists()) {
            String backupReportPath = REPORTS_DIR + new Date().toString().replace(":", "_").replace(" ", "_") + ".html";
            existingReport.renameTo(new File(backupReportPath));
        }

        // Initialize ExtentReports and attach the reporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(EXTENT_REPORTS_HTML_PATH);
        if (new File(EXTENT_CONFIG_FILE_PATH).exists()) {
            htmlReporter.loadXMLConfig(new File(EXTENT_CONFIG_FILE_PATH));
        }
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void startTest(String testName) {
        testThreadLocal.set(extent.createTest(testName));
    }

    public static void reportPass(String message) {
        getTest().log(Status.PASS, message);
    }

    public static void reportFailure(String message) {
        getTest().log(Status.FAIL, message);
    }

    public static void reportWarning(String message) {
        getTest().log(Status.WARNING, message);
    }

    public static ExtentTest getTest() {
        return testThreadLocal.get();
    }

    public static void endTest() {
        if (extent != null) {
            extent.flush();
        }
    }
    
	
	public static void reportInfoMsg(String strMsg) {
		getTest().log(Status.INFO, strMsg);
	}
	

    public static ExtentReports getExtentInstance() {
        return extent;
    }
}

