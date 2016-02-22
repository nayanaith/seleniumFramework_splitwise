package com.pages.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.HomePage;
import com.pages.LoginPage;

public class TestLoginPage {
	
	WebDriver driver;
	LoginPage lgPg;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("https://secure.splitwise.com/#/dashboard");
	}//end setup
	
	@Test
	public void testLoginFeature(){
		lgPg = new LoginPage(driver);		
		lgPg.login();
		Assert.assertEquals("Welcome to Splitwise!",lgPg.getWelcomeText());
	}//end testLogin
	
	@After
	public void closes(){
		driver.close();
	}//end closeAll
}//end LoginTest
