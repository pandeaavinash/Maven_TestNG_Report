package com.facebook.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.facebook.UserDefinedException.FacebookException;
import com.facebook.report.ReportSetpDetails;
import com.facebook.webdriver.BrowserFactory;

public class FacebookRegister 
{
	@Test(enabled=true,description="Avinash Facebook Register Test",groups= {"regression"})
	public void FacebookRegisterTest1() 
	{
		try
		{
			System.out.println("hey");
			System.out.println("Avinash made the changes in FacebookRegister.java file");
			System.out.println("Diptee Made the changes");
			System.out.println("Suraj Made the changes");
			System.out.println("Mayank Made the changes");
			System.out.println("NIshigandha Made the changes");
			System.out.println("Manisha made changes");
			System.out.println("Aniket Made changes only in Local Repository"); 
			BrowserFactory browser = new BrowserFactory();
			browser.setDriver("chrome");
			ReportSetpDetails obj = new ReportSetpDetails();
			
			ArrayList<String> list = new ArrayList<>();list.add("browser Open");
			
			
			WebDriver driver = browser.getDriver();
			driver.get("https://www.facebook.com/register");
			list.add("Navigate to URL Facebook.com");
			com.facebook.pages.FacebookRegister objReg = new com.facebook.pages.FacebookRegister(driver);
			objReg.enterFirstName("Avinash");
			list.add("Enter user name as Avinas");
			objReg.enterSurName("Pande");
			list.add("Enter password as Avinash");
			objReg.enterMobilNumber("9970121680");
			list.add("Enter mobile NO as 9970121680");
			objReg.enterNewPassword("1232323sdsad");
			list.add("Enter new password as 1232323sdsad");
			System.out.println("FacebookRegisterTest1: "+Thread.currentThread().getId());
			obj.setListOfString(list);
			obj.addSteps("FacebookRegisterTest1", obj);
			browser.removeDriver();
		}
		catch(FacebookException fb)
		{
			System.out.println(fb.getMessage());
		}
	}
	
	@Test(enabled=true,description="Suraj Facebook Register Test",groups= {"sanity"})
	public void FacebookRegisterTest2() throws Exception 
	{
		BrowserFactory browser = new BrowserFactory();
		ReportSetpDetails obj = new ReportSetpDetails();
		
		ArrayList<String> list = new ArrayList<>();
		
		try
		{
			
			browser.setDriver("chrome");
			WebDriver driver = browser.getDriver();
			list.add("browser Open");
			driver.get("https://www.facebook.com/register");
			list.add("Navigate to https://www.facebook.com/register");
			com.facebook.pages.FacebookRegister objReg = new com.facebook.pages.FacebookRegister(driver);
			objReg.enterFirstName("Suraj");
			list.add("Enter user Name as Suraj");
			objReg.enterSurName("Shelke");
			list.add("Enter sur Name as Shelke");
			objReg.enterMobilNumber("9970564830");
			list.add("Enter mobile as 9970564830");
			objReg.enterNewPassword("5743895645");
			list.add("Enter new password as 5743895645");
			System.out.println("FacebookRegisterTest2: "+Thread.currentThread().getId());
			obj.setListOfString(list);
			obj.addSteps("FacebookRegisterTest2", obj);
		}
		catch(FacebookException fb)
		{
			System.out.println(fb.getMessage());	
			throw new Exception();
		}
		finally {
			browser.removeDriver();
		}
	}
	
	@Test(enabled=true,description="Aniket Facebook Register Test",groups= {"sanity"})
	public void FacebookRegisterTest3() 
	{
		ReportSetpDetails obj = new ReportSetpDetails();
		
		ArrayList<String> list = new ArrayList<>();
		try
		{
			BrowserFactory browser = new BrowserFactory();
			browser.setDriver("chrome");
			list.add("open chrome browser");
			WebDriver driver = browser.getDriver();
			driver.get("https://www.facebook.com/register");
			list.add("Navigate to https://www.facebook.com/register");
			com.facebook.pages.FacebookRegister objReg = new com.facebook.pages.FacebookRegister(driver);
			objReg.enterFirstName("Aniket");
			list.add("Enter user name as Aniket");
			objReg.enterSurName("More");
			list.add("Enter sur name as more");
			objReg.enterMobilNumber("9960121680");
			list.add("Enter mobile Number: 996121680");
			objReg.enterNewPassword("vgfd45354");
			list.add("Enter new password as vgfd45354");
			System.out.println("FacebookRegisterTest3: "+Thread.currentThread().getId());
			obj.setListOfString(list);
			obj.addSteps("FacebookRegisterTest3", obj);
			browser.removeDriver();
		}
		catch(FacebookException fb)
		{
			System.out.println(fb.getMessage());
		}
	}
	
	
}
