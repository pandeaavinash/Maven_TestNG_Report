package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.confighandler.LoadProperties;
import com.facebook.locator.FindLocator;

public class FacebookLogin 
{
	private WebDriver driver = null;
	public FacebookLogin(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	/***
	 * Enter UserName or email ID
	 * @param userName userName as email ID
	 */
	public void enterUserName(String userName)
	{
		FindLocator fl = new FindLocator();
		By loginBy = fl.getLocator_Value(LoadProperties.LOGIN_USERNAMETXT);
		driver.findElement(loginBy).sendKeys(userName);
	}
	
	/***
	 * Enter User Password to login
	 * @param userPassword User Password
	 */
	public void enterPassword(String userPassword)
	{
		FindLocator fl = new FindLocator();
		By loginBy = fl.getLocator_Value(LoadProperties.LOGIN_PASSWORDTXT);
		driver.findElement(loginBy).sendKeys(userPassword);
	}
	
}
