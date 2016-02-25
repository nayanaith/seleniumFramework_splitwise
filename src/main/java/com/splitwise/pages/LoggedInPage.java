package com.splitwise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.splitwise.pageconstants.LoggedInPageConstants;

public class LoggedInPage implements LoggedInPageConstants{
	WebDriver driver;
	
	@FindBy(xpath=dashboardNameXpath)
	WebElement dashboardName;
	
	public LoggedInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}//end LoggedInPage
	
	public String getDashboardName(){
		return dashboardName.getText();
	}//end getDashboardName
	
}//end LoggedInPage
