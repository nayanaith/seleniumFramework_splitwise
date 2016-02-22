package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(xpath=".//input[@id='user_session_email']")
	WebElement loginUserName;
	
	@FindBy(id="user_session_password")
	WebElement loginPwd;
	
	@FindBy(xpath=".//*[@class='btn btn-mint']")
	WebElement loginWindowGetButton;

	@FindBy(xpath=".//input[@value='Log in to Splitwise']")
	WebElement loginBtn;
	
	@FindBy(xpath=".//body/div[3]/div[1]/div[3]/div[2]/div[1]/div/div/h3")
	WebElement welcomMessage;
	
//	String userName="nayanaith@gmail.com";
//	String password="elatasplit";
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}//end LoginPage
	
	
	public void setLoignUserName(String unme){
		loginUserName.sendKeys(unme);
	}//end setLoignUserName
	
	
	public void setLoignLoginPwd(String pwd){
		loginPwd.sendKeys(pwd);
	}//end setLoignUserName
	
		
	public void clickLoginButton(){
		loginBtn.click();
	}//end login
	
	public void getLoginWindow(){
		loginWindowGetButton.click();
	}//end getLoginWindow
	
	
	public void login(String uname,String pwd){
		this.getLoginWindow();
		this.setLoignUserName(uname);
		this.setLoignLoginPwd(pwd);
		this.clickLoginButton();
	}//end login
	
	public String getWelcomeText(){
		return welcomMessage.getText();
	}//end getWelcomText


}// end LoginPage
