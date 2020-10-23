package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

import com.qa.hubspot.util.Constants;

public class HomePage extends BasePage
{
	WebDriver driver;
	ElementUtil elemetUtil;
	
	//1. By locators
	private By header = By.cssSelector("h1.private-header__heading");
	private By accountName = By.className("account-name ");
	private By settingsIcon = By.id("navSetting");
	private By parentContactsMenu = By.id("nav-primary-contacts-branch");
	private By subContactsMenu = By.id("nav-secondary-contacts");
	
	//2. Create constructor
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		elemetUtil = new ElementUtil(driver);
	}
	
	//3. Page Actions
	public String getHomePageTitle() 
	{
		return elemetUtil.waitForPageTitlePresent(Constants.HOME_PAGE_TITLE, 10);
	}
	
	public String getHomePageHeaderValue() 
	{
		if(elemetUtil.doIsDisplayed(header)) 
		{
			return elemetUtil.doGetText(header);
		}
		return null;
	}
	
	public String getUserAccountName() 
	{
		if(elemetUtil.doIsDisplayed(accountName)) 
		{
			return elemetUtil.doGetText(accountName);
		}
		return null;
	}
	
	public boolean isExistSettingsIcon() 
	{
		return elemetUtil.doIsDisplayed(settingsIcon);
	}
	
	public ContactsPage gotoContactsPage() 
	{
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() 
	{
		elemetUtil.waitForElementToBeLocated(parentContactsMenu, 10);
		elemetUtil.doClick(parentContactsMenu);
		elemetUtil.clickWhenReady(subContactsMenu, 10);
	}
}
