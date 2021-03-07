package com.facebook.listeners;

import java.io.File;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.facebook.confighandler.LoadProperties;
import com.facebook.report.ReportSetpDetails;


public class SuiteListener implements ISuiteListener 
{
	Long suiteStartTime,suiteEndTime;
	
	@Override
	public void onStart(ISuite suite) 
	{
		suiteStartTime = System.currentTimeMillis();
		System.out.println("Suite Startted at: "+suiteStartTime);
		File file = new File(suite.getOutputDirectory());
		
		LoadProperties.OUTPUTFOLDER = file.getParent();
		
		ReportSetpDetails.initialize();
	}

	@Override
	public void onFinish(ISuite suite) 
	{		
		suiteEndTime = System.currentTimeMillis();
		System.out.println("Suite End at: "+suiteEndTime);
	}

}
