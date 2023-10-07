package com.crossjourney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.crossjourney.base.TestBase;
import org.testng.Assert;

public class LoginPage extends TestBase{

	public static final By USERNAME = By.xpath("//*[@id='email']");
	public static final By PASSWORD = By.xpath("//*[@id='password']");

	public static final By LOCkICON = By.xpath("//*[@data-testid='LockOutlinedIcon']");
	public static final By LOGIN_LABEL = By.xpath("(//*[contains(text(),'Login')])[1]");


	public LoginPage verifyLockIcon(){
		Assert.assertTrue(driver.findElement(LOCkICON).isDisplayed());
		return this;
	}

	public LoginPage verifyLoginLabel(String expectedLabel){
		String actualLabelText = driver.findElement(LOGIN_LABEL).getText();
		Assert.assertEquals(actualLabelText,expectedLabel);
		return this;
	}

	public LoginPage verifyPageTitle(String expectedPageTitle){
		String actualPageTitleText = driver.getTitle();
		Assert.assertEquals(actualPageTitleText, expectedPageTitle);
		return this;
	}


	public LoginPage clickLoginButton() {
		//PageFactory.initElements(driver, this);
		driver.findElement(USERNAME).sendKeys(prop.getProperty("username"));
		driver.findElement(PASSWORD).sendKeys(prop.getProperty("password"));
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		try {
			Thread. sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return this;
	}





}
