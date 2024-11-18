package com.nagarro.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class AlertPage {

	
	private WebDriver driver;
	private Web_Lib weblib ;
	 
	 public AlertPage() {
			this.driver = DriverManager.getDriver();
			this.weblib = new Web_Lib();
			
		}
	//locators
	 private String[] loc_alert1 = {"xpath","//a[@onclick=\"alert('cheese');\"]"};
	 private String[] loc_alert2 = {"xpath","//a[@onclick=\"alert('');\"]"};
	 private String[] loc_alert3 = {"xpath","//a[@onclick=\"displayPrompt();\"]"};
	 private String[] loc_alert4 = {"xpath","//a[@onclick=\"displayPromptWithDefault();\"]"};
	 private String[] loc_alert5 = {"xpath","//a{@onclick=displayTwoPrompts();}"};
	 private String[] loc_list = {"id", "select"};
	 
	 public void alert1() {
		 
		 weblib.click(loc_alert1);
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
	 }
	 
	 public void alert2() {
		 weblib.click(loc_alert2);
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		 
	 }
	 
	 public void alert3() throws InterruptedException {
		 weblib.click(loc_alert3);
		 
		 Alert alert = driver.switchTo().alert();
		 alert.sendKeys("alert checking");
		 alert.accept();
		 
	 }
	 
	 public void alert4() {
		 
		 weblib.click(loc_alert4);
		 Alert alert = driver.switchTo().alert();
		 //alert.accept();
		 System.out.println(alert.getText());
		 alert.sendKeys("alert checking");
		 //alert.accept();
	 }
	 
	 public void selectfromList() {
		 
		 Select select = new Select(driver.findElement(By.id("select")));
		 //select.selectByValue("2");
		 System.out.println(select.getOptions());
		 
	 }
}
