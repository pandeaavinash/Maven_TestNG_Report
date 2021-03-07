package com.facebook.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
	//private static BrowserFactory instance= null;
	
	ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
	
	/*private BrowserFactory()
	{
		
	}*/
	
	/*public static BrowserFactory getInstance()
	{
		if(instance == null)
			instance = new BrowserFactory();
		return instance;
	}*/
	
	public final void setDriver(String browser)
	{
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().browserVersion("88.0.4324.104 ").setup();
			System.out.println("Browser is chrome");
			threadLocal.set(new ChromeDriver());
		}
	}
	
	public final WebDriver getDriver()
	{
		return threadLocal.get();
	}
	
	public final void removeDriver()
	{
		threadLocal.remove();
	}
	
}
