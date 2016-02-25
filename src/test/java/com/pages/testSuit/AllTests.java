package com.pages.testSuit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pages.test.HomePageTest;
import com.pages.test.LoggedInPageTest;
import com.pages.test.LoginPageTest;

@RunWith(Suite.class)
@SuiteClasses(
		{HomePageTest.class,
			LoggedInPageTest.class,
			LoginPageTest.class})
public class AllTests {

}//end AllTests
