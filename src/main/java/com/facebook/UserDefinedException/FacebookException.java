package com.facebook.UserDefinedException;

public class FacebookException extends Exception 
{
	private String message = null;
	public FacebookException() {
		// TODO Auto-generated constructor stub
	}
	
	public FacebookException(String message)
	{
		this.message = message;
	}
	
	public String getMessage() 
	{
		return message;
	}

}
