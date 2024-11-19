package com.nagarro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nagarro.util.DriverManager;
import com.nagarro.util.Web_Lib;

public class CountriesPage {

	private WebDriver driver;
	private Web_Lib weblib ;
	 
	 public CountriesPage() {
			this.driver = DriverManager.getDriver();
			this.weblib = new Web_Lib();
			
		}
		 
	//locators
	  private final String[]  loc_table     = { "xpath", "//table[@id='countries']" };
	
	  public int numofRows() {
		  
		  WebElement table = weblib.getElement(loc_table);
		  
		  List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		  int numberofrows = rows.size();
		  return numberofrows;
		  
	  }
//getting the number of columns of a webtable
	 
	  public int numofColumns() {
			
		  WebElement table = weblib.getElement(loc_table);		  
		  List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		  List<WebElement> columns = rows.get(0).findElements(By.xpath("./td"));
		  
		  return columns.size();
		  
	  }
	  
	  public void getAllRows(String columnName) {
		  WebElement table = weblib.getElement(loc_table);
		  int columnIndex = getColumnsIndex(columnName);
		   
		  List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		  for (int i=0; i< rows.size();i++) {
			  
			  String column = rows.get(i).findElement(By.xpath("./td["+columnIndex+"]")).getText();
			  System.out.println(column);
			  
		  }

	  }
	  
	  public int getColumnsIndex(String columnName) {
		  
		  WebElement table = weblib.getElement(loc_table);		  
		  List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		  List<WebElement> columns = rows.get(0).findElements(By.xpath("./td"));
		  
		  for(int i=0;i<columns.size();i++) {
			  
			  if (columns.get(i).getText().equals(columnName)) {
				  return i+1;
			  }
		  }
		  return -1;
		  
	  }
	  
	  public String getData(String strCountry, String strField) {
		  
		  int countryIndex= getColumnsIndex("Country");
		  System.out.println(countryIndex);
		  int capitalIndex= getColumnsIndex(strField);
		  System.out.println(capitalIndex);
		  WebElement table = weblib.getElement(loc_table);		  
		  List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		  for(int i =0;i<rows.size();i++) {
			  
			  String strCOutryName = rows.get(i).findElement(By.xpath("./td["+countryIndex+"]")).getText();
			  if(strCOutryName.equals(strCountry)) {
				  return rows.get(i).findElement(By.xpath("./td["+capitalIndex+"]")).getText();
			  }
		  }
          return null;
	  }
	  
	  public void getAllColumns() {
		  
		  WebElement table = weblib.getElement(loc_table);		  
		  List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"));
		  List<WebElement> columns = rows.get(0).findElements(By.xpath("./td"));
		  
		  for(int i=0;i<columns.size();i++) {
			  System.out.println(columns.get(i).getText());
		  }
	  }
	  
	 
	  
}
