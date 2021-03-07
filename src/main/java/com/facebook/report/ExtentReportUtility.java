package com.facebook.report;

import static org.testng.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.facebook.confighandler.LoadProperties;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import report.ExtentReport;

public class ExtentReportUtility 
{
	public static ExtentReports report = null;
	public static ExtentTest test = null;	
	public static String reportPath = null;
	public static String reportFullPath = null;
	
	public static String reportName = null;
	
	
	/***
	 * Will create a extent Report
	 * @return Physical Report object
	 */
	public ExtentReports startReport() 
	{
		if(report == null)
		{
			reportPath = ".\\test-output\\";
			reportFullPath = reportPath+reportName+".html";
			
			report = new ExtentReports(reportFullPath, false, DisplayOrder.OLDEST_FIRST);
			report.config().reportHeadline(LoadProperties.REPORTHEADLINE);
			report.config().reportName(LoadProperties.REPORTFILENAME);
			report.config().documentTitle(LoadProperties.REPORTDOCUMENTITLE);
		}
		return report;
	}
	

	/***
	 * Create/Add a test in report file.
	 * @param testName TestCase Name
	 * @return Return TestCase Object
	 */
	public static ExtentTest startTest(String testName)
	{
		if(test == null)
		{
			test= report.startTest(testName);
		}
		return test;
	}
	

	/***
	 * End the test and add it in Report file
	 */
	public void endTest()
	{
		if(test != null)
		{
			report.endTest(test);
			if(test != null)
				test=null;
		}
	}
	
	
	/***
	 * Close the report 
	 */
	public static void endReport()
	{
		if(report != null)
		{
			report.flush();
			report.close();
			if(report != null)
				report=null;
		}
	}
	
	/***
	 * Convert the current Date time in to specific format for reporting purpose
	 * @return
	 */
	public String getDateTimeForReport()
	{
		SimpleDateFormat dt = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dtm = dt.format(new Date());
		dtm = dtm.replace('-', '_');
		dtm = dtm.replace(':', '_');
		dtm = dtm.replace(' ', '_');
		reportName = LoadProperties.REPORTFILENAME+"_"+dtm;
		return reportName ;
	
	}

}
