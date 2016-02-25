package com.pages.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//import com.pages.HomePage;



import com.splitwise.pages.LoginPage;
import com.splitwise.testdata.dao.UserDetailsDAO;
import com.splitwise.testdata.dto.UserDetailsDTO;

public class LoginPageTest {
	
	WebDriver driver;
	LoginPage lgPg;
	private static List<UserDetailsDTO> userDetailsList;
	
	@Before
	public void setup() throws Exception{
		driver = new FirefoxDriver();
		driver.get("https://secure.splitwise.com/#/dashboard");
		userDetailsList=UserDetailsDAO.readData();
	}//end setup
	
	@Test
	public void testLoginFeatureWithValidcredentials(){
		lgPg = new LoginPage(driver);		
		lgPg.login(userDetailsList.get(0).getUserName(),userDetailsList.get(0).getPassword());
		assertEquals("Welcome to Splitwise!",lgPg.getWelcomeText());
	}//end testLogin
	
	@Test(expected=NoSuchElementException.class)
	public void testLoginFeatureWithInvalidcredentials(){
		lgPg = new LoginPage(driver);		
		lgPg.login(userDetailsList.get(1).getUserName(),userDetailsList.get(1).getPassword());
		assertNotEquals("Welcome to Splitwise!",lgPg.getWelcomeText());
	}//end testLogin
	
	@After
	public void closes(){
		driver.close();
	}//end closeAll
}//end LoginTest
