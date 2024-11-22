package com.nagarro.reporting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import com.nagarro.util.DriverManager;

public class ScreenshotManager {

    // Directory to store screenshots
    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + File.separator + "target" + File.separator + "Screenshots" + File.separator;

    static {
        File dir = new File(SCREENSHOT_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // Capture screenshot method
    public static String captureScreenshot(String testName) throws IOException {
        WebDriver driver = DriverManager.getDriver();

        // Take screenshot and store it in a temporary file
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create the destination file path
        String screenshotPath = SCREENSHOT_DIR + testName + "_" + System.currentTimeMillis() + ".png";
        Path destinationPath = Path.of(screenshotPath);

        // Copy the screenshot to the destination folder
        Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

        return screenshotPath;
    }
}

