package com.pages.test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.LoggedInPage;
import com.pages.LoginPage;
import com.userDetails.dao.UserDetailsDAO;

public class TestLoggedInPage {
	LoggedInPage lgedInpg;
	LoginPage lgPg;
	WebDriver driver;
	String userName="nayanaith@gmail.com";
	String password="elatasplit";
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("https://secure.splitwise.com/#/dashboard");
	}//end setup
	
	
	@Test
	public void testLogin() throws Exception{
		UserDetailsDAO.readData();
		lgedInpg = new LoggedInPage(driver);
		lgPg = new LoginPage(driver);	
		lgPg.login(userName,password);
		//Assert.assertEquals(, lgedInpg.getDashboardName());
		Assert.assertTrue(lgedInpg.getDashboardName().trim().contains("Nayanajith"));
	}//end testLogin
	
	
	@After
	public void closes(){
		driver.close();
	}//end closeAll
}//end TestLoggedInPage
