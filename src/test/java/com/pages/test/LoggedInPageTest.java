package com.pages.test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.splitwise.pages.LoggedInPage;
import com.splitwise.pages.LoginPage;
import com.splitwise.testdata.dao.UserDetailsDAO;
import com.splitwise.testdata.dto.UserDetailsDTO;

public class LoggedInPageTest {
	LoggedInPage lgedInpg;
	LoginPage lgPg;
	WebDriver driver;
	private static List<UserDetailsDTO> userDetailsList;
	
	@Before
	public void setup() throws Exception{
		driver = new FirefoxDriver();
		driver.get("https://secure.splitwise.com/#/dashboard");
		userDetailsList=UserDetailsDAO.readData();
	}//end setup
	
	
	@Test
	public void testLogin() throws Exception{
		lgedInpg = new LoggedInPage(driver);
		lgPg = new LoginPage(driver);	
		System.out.printf("came"+userDetailsList.get(0).getUserName()+userDetailsList.get(0).getPassword());
		lgPg.login(userDetailsList.get(0).getUserName(),userDetailsList.get(0).getPassword());
		assertTrue(lgedInpg.getDashboardName().trim().contains("Nayanajith"));
	}//end testLogin
	
	
	@After
	public void closes(){
		driver.close();
	}//end closeAll
}//end TestLoggedInPage
