package com.splitwise.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.splitwise.pageconstants.HomePageConstants;

public class HomePage implements HomePageConstants{
	WebDriver driver;
	
	@FindBy(xpath=titleXpath)
	WebElement swTitle;
	
	@FindBy(xpath=signUpBtnXpath) 
	WebElement signupButton;
	
	@FindBy(xpath=loginBtnXpath) 
	WebElement loginButton;
	

	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}//end HomePage
	
	public String getTitleText(){
		return swTitle.getText();
	}//end getTitle
	
	public String getSignupButtonText(){
		return signupButton.getText();
	}//end getSignupButton
	
	public void goToLoginPage(){
		loginButton.click();
	}//end goToLoginPage
}//end Scenarios

