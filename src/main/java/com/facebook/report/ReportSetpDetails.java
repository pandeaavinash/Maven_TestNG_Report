package com.facebook.report;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ReportSetpDetails 
{
	/**
	 * @return the listOfString
	 */
	public ArrayList<String> getListOfString() {
		return listOfString;
	}

	/**
	 * @param listOfString the listOfString to set
	 */
	public void setListOfString(ArrayList<String> listOfString) {
		this.listOfString = listOfString;
	}

	public static Hashtable<String, ReportSetpDetails> ht = null;
	ArrayList<String> listOfString = new ArrayList<>();
	
	public synchronized void addSteps(String testName, ReportSetpDetails obj)
	{
		
		ht.put(testName, obj);
	}
	
	public static void initialize()
	{
		ht = new Hashtable<>();
	}
}
