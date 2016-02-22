package com.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage implements PageConstants{
	WebDriver driver;
	
	@FindBy(xpath=titleXpath)
	WebElement swTitle;
	
	@FindBy(xpath=".//body/div[2]/div[2]/a[1]") 
	WebElement signupButton;
	
	@FindBy(xpath=".//body/div[1]/div/div[1]/a[@class='btn btn-mint']") 
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

