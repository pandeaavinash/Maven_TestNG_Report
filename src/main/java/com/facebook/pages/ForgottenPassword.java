package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.confighandler.LoadProperties;
import com.facebook.locator.FindLocator;

public class ForgottenPassword 
{
	private WebDriver driver = null;
	
	public ForgottenPassword(WebDriver driver)
	{
		this.driver = driver;
	}

	/***
	 * Enter Email Address or Mobile Number to search the account
	 * @param data Either email or mobile Number
	 */
	public void enterEmailOrMobileNo(String data)
	{
		FindLocator fl = new FindLocator();
		By loginBy = fl.getLocator_Value(LoadProperties.FORGOTTEN_MOBILENOTXT);
		driver.findElement(loginBy).sendKeys(data);
	}
}
