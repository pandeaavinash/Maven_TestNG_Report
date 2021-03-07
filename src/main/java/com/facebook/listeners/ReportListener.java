package com.facebook.listeners;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.facebook.confighandler.LoadProperties;
import com.facebook.emailutility.EmailSend;
import com.facebook.report.ReportSetpDetails;
import com.relevantcodes.extentreports.LogStatus;

import report.ExtentReport;

public class ReportListener implements IReporter 
{

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) 
	{
		
		Hashtable<String, ReportSetpDetails> ht = ReportSetpDetails.ht;
		System.out.println("Ht:"+ht.size());

		//Initialize the report file
		ExtentReport.createReport();
		
		for (ISuite iSuite : suites) 
		{
			System.out.println("Suite Name: "+iSuite.getName());
			Map<String, ISuiteResult> resultsMap = iSuite.getResults();
			Set<Entry<String, ISuiteResult>> resultSets = resultsMap.entrySet();
			for (Entry<String, ISuiteResult> resultSet : resultSets) 
			{
				ISuiteResult resultValue = resultSet.getValue();
				ITestContext testContext = resultValue.getTestContext();
			
				IResultMap allPassedTestMethods = testContext.getPassedTests();
				Set<ITestResult> allResults = allPassedTestMethods.getAllResults();
				for (ITestResult iTestResult : allResults) {
					System.out.println("Passed Tests:  "+iTestResult.getName());
					
					
					ExtentReport.createTest(iTestResult.getName());
					
					ReportSetpDetails reportSetpDetails = ht.get(iTestResult.getName());
					ArrayList<String> listOfString = reportSetpDetails.getListOfString();
					for (String steps : listOfString) {
						ExtentReport.test.log(LogStatus.PASS,steps);
					}
					
					
					ExtentReport.test.log(LogStatus.PASS,iTestResult.getAttribute("description")==null?"":iTestResult.getAttribute("description").toString());
					
					ExtentReport.endTest();
				}
				
				//Failed Test Methods
				IResultMap allFailedTestMethods = testContext.getFailedTests();
				Set<ITestResult> allFailedResults = allFailedTestMethods.getAllResults();
				for (ITestResult iTestResult : allFailedResults) {
					System.out.println("Failed Tests:  "+iTestResult.getName());
					
					ExtentReport.createTest(iTestResult.getName());
					
					ReportSetpDetails reportSetpDetails = ht.get(iTestResult.getName());
					ArrayList<String> listOfString = reportSetpDetails.getListOfString();
					for (String steps : listOfString) {
						ExtentReport.test.log(LogStatus.FAIL,steps);
					}
					ExtentReport.test.log(LogStatus.FAIL, iTestResult.getAttribute("description")==null?"":iTestResult.getAttribute("description").toString());
					
					ExtentReport.endTest();
				}
				
				//Skipped Test Method
				IResultMap allSkippedTestMethods = testContext.getFailedTests();
				Set<ITestResult> allSkippedResults = allSkippedTestMethods.getAllResults();
				for (ITestResult iTestResult : allSkippedResults) 
				{
					System.out.println("Skipped Tests:  "+iTestResult.getName());
					
					ExtentReport.createTest(iTestResult.getName());
					
					ExtentReport.test.log(LogStatus.SKIP, iTestResult.getAttribute("description")==null?"":iTestResult.getAttribute("description").toString());
					
					ExtentReport.endTest();
				}
			}//Suite
			
		}
			
		
		//Close the report File
		ExtentReport.endReport();
		
		//Wait for 5-seconds to create & save the report file.
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check file exists to attached to email & sent it.
		File file = new File(ExtentReport.reportFullPath);
		if(file.exists()) 
		{
			System.out.println("File exists to attached to Report & Send it !!");
			//EmailSend.sendEmail(LoadProperties.EMAIL_EMAILFROM, LoadProperties.EMAIL_EMAILTOSEND, ExtentReport.reportFullPath);
			EmailSend.sendEmail(LoadProperties.EMAIL_EMAILFROM, LoadProperties.EMAIL_EMAILTOSEND, file);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Delete the file once you attached to the mail !!
			//file.delete();
		}
		else
		{
			System.out.println("No file to attached email so email not sent !!!");
		}		
		
		
	}

}
