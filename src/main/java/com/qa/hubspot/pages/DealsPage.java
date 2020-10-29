package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class DealsPage extends BasePage 
{
	By deals = By.id("deals");
	public DealsPage(WebDriver driver)
	{
		System.out.println("Deals Page");
		driver = this.driver;
	}
	
	public String getTitle()
	{
		return driver.getTitle();
				
	}
}
