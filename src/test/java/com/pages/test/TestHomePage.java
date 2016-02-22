package com.pages.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.HomePage;
import com.userDetails.dao.UserDetailsDAO;

import junit.framework.Assert;


/**
 * Unit test for simple App.
 */
public class TestHomePage 
{
	WebDriver driver;
	HomePage hmpage;
	//UserDetailsDAO userDetails;
	
	@Before
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://secure.splitwise.com/#/dashboard");
		//userDetails = new UserDetailsDAO();
	}//end setup
	
	@Test
	public void testHomePage() throws Exception{
		try{
		hmpage = new HomePage(driver);		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals("Split expenses with friends.", hmpage.getTitleText());
		Assert.assertEquals("Get started now(it's free!)", hmpage.getSignupButtonText().replaceAll("\n",""));

		}
		
		catch(Exception e){ 
			Assert.fail(); //To fail test in case of any element identification failure		
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
		} 	
		
		
	}//end testHomePage
	
	@After
	public void closes(){
		driver.close();
	}//end closeAll
	
//	public void takeScreenShotOnFailure(TestWatcher  testWatcher ) throws IOException {
//		if (testWatcher. == ITestResult.FAILURE)
//		{ System.out.println(testResult.getStatus()); 
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
//		} 
//
//	}
}//end TestHomePage
