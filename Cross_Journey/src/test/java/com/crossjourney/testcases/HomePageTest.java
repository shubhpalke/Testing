package com.crossjourney.testcases;

import org.testng.annotations.*;
import com.crossjourney.base.TestBase;
import com.crossjourney.pages.HomePage;
import com.crossjourney.pages.LoginPage;

public class HomePageTest extends TestBase{
	private String pageLabel = "CrossJourney";
	private String adminLabel = "Admin";
	private String changePasswordLabel = "Change password";
	private String logoutLabel = "Logout";
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.clickLoginButton();
	}

	@Test(priority=1)
	public void verifyHomePageLabel() {

		homePage.verifyHomePageLabel(pageLabel);
	}

	@Test(priority=2)
	public void verifySettingIconOnHomePage() {
		homePage.verifySettingsIconPresent();
	}

	@Test(priority=3)
	public void VerifyOptionPresentUnderUserIcon() {
		homePage.clickOnUserIcon()
				.optionPresentUnderUserIcon(adminLabel,changePasswordLabel,logoutLabel);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}