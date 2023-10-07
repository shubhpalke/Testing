package com.crossjourney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.crossjourney.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends TestBase{
	public static final By HOME_PAGE_LABEL = By.xpath("//*[@href='/admin']");
	public static final By SETTINGS_ICON = By.xpath("//*[@data-testid='SettingsIcon']");
	public static final By USER_ICON = By.xpath("//*[@data-testid='PersonIcon']");
	public static final By ADMIN = By.xpath("(//*[@role='menuitem'])[1]");
	public static final By CHANGE_PASSWORD = By.xpath("(//*[@role='menuitem'])[2]");
	public static final By LOGOUT = By.xpath("(//*[@role='menuitem'])[3]");

public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

	public HomePage verifyHomePageLabel(String expectedLabel){
		String actualLabelText = driver.findElement(HOME_PAGE_LABEL).getText();
		Assert.assertEquals(actualLabelText,expectedLabel);
		return this;
	}

	public HomePage verifySettingsIconPresent(){
		Assert.assertTrue(driver.findElement(SETTINGS_ICON).isDisplayed());
		return this;
	}

	public HomePage clickOnUserIcon(){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(USER_ICON));
		driver.findElement(USER_ICON).click();
		return this;
	}

	public HomePage optionPresentUnderUserIcon(String adminText, String changePasswordText, String logout){
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN));
		Assert.assertEquals(driver.findElement(ADMIN).getText(),adminText);
		Assert.assertEquals(driver.findElement(CHANGE_PASSWORD).getText(),changePasswordText);
		Assert.assertEquals(driver.findElement(LOGOUT).getText(),logout);
		return this;
	}
}
