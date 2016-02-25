package com.pages.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.splitwise.pages.HomePage;




/**
 * Unit test for simple App.
 */
public class HomePageTest 
{
	WebDriver driver;
	HomePage hmpage;
	//UserDetailsDAO userDetails;
	
	@Rule public TestName name = new TestName();
	
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
		assertEquals("Split expenses with friends.", hmpage.getTitleText());
		assertEquals("Get started now(it's free!)", hmpage.getSignupButtonText().replaceAll("\n",""));

		}
		
		catch(Exception e){ 
			//fail(); //To fail test in case of any element identification failure		
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
		} 	
		
		
	}//end testHomePage
	
	@After
	public void closes() throws Exception{		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\screenShots\\"+name.getMethodName()+".jpg"));
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
