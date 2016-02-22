package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedInPage {
	WebDriver driver;
	
	@FindBy(xpath=".//body/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[@class='dropdown-toggle']")
	WebElement dashboardName;
	
	public LoggedInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}//end LoggedInPage
	
	public String getDashboardName(){
		return dashboardName.getText();
	}//end getDashboardName
	
}//end LoggedInPage
