package com.crossjourney.testcases;

import org.apache.log4j.Priority;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crossjourney.base.TestBase;
import com.crossjourney.pages.HomePage;
import com.crossjourney.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	private String labelText = "Login";
	private String pageTitle = "crossjourney";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}

	@Test(priority=1)
	public void testIcon(){
		loginPage.verifyLockIcon();
	}

	@Test(priority=2)
	public void verifyLoginLabel(){
		loginPage.verifyLoginLabel(labelText);
	}

	@Test(priority=3)
	public void verifyPageTitle(){
		loginPage.verifyPageTitle(pageTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
