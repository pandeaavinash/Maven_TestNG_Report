package com.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.facebook.UserDefinedException.FacebookException;
import com.facebook.confighandler.LoadProperties;
import com.facebook.locator.FindLocator;

public class FacebookRegister 
{
	WebDriver driver = null;
	public FacebookRegister(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	/***
	 * Enter user Name
	 * @param driver Browser Instance
	 * @param value Enter data in userName text field.
	 * @throws FacebookException 
	 */
	public void enterFirstName(String value) throws FacebookException
	{
		try
		{

			FindLocator findloc = new FindLocator();
			By by = findloc.getLocator_Value(LoadProperties.REGISTER_FIRSTNAMETXT);
			driver.findElement(by).sendKeys(LoadProperties.REGISTER_FIRSTNAMETXTVALUE);
		}
		catch(Exception e)
		{
			throw new FacebookException(e.getMessage());
		}
	}
	
	/***
	 * Enter SurName 
	 * @param driver
	 * @param value Value of SurName field.
	 */
	public void enterSurName(String value)
	{
		FindLocator findloc = new FindLocator();
		By by = findloc.getLocator_Value(LoadProperties.REGISTER_SURNAMETXT);
		driver.findElement(by).sendKeys(value);
	}

	/***
	 * Enter the Mobile Number
	 * @param driver
	 * @param value MobileNumber value
	 */
	public void enterMobilNumber(String value)
	{
		FindLocator findloc = new FindLocator();
		By by = findloc.getLocator_Value(LoadProperties.REGISTER_MOBILENOTXT);
		driver.findElement(by).sendKeys(value);
	}
	
	/***
	 * Enter the New password
	 * @param driver
	 * @param value Password value
	 */
	public void enterNewPassword(String value)
	{
		FindLocator findloc = new FindLocator();
		By by = findloc.getLocator_Value(LoadProperties.REGISTER_NEWPASSWORDTXT);
		driver.findElement(by).sendKeys(value);
	}
}
