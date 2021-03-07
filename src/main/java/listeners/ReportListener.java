package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.LogStatus;

import email.Mailer;
import report.ExtentReport;

public class ReportListener implements ITestListener,ISuiteListener
{

	@Override
	public void onStart(ISuite suite) 
	{
		ExtentReport.createReport();
		
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		ExtentReport.endReport();
		Mailer.send("your gmail Id","yourgmail password","aavinashpande@gmail.com","hello javatpoint","How r u?");
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		ExtentReport.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//7620-313490
		printTestResult(result);		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		printTestResult(result);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		printTestResult(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}
	
	public void printTestResult(ITestResult result)
	{
		String testStatus = "";
		switch(result.getStatus())
		{
		case 1:
		{
			testStatus = "PASS";
			ExtentReport.test.log(LogStatus.PASS, "Test Passed");
			break;
		}
		case 2:
		{
			testStatus = "FAILURE";
			ExtentReport.test.log(LogStatus.FAIL, "Test Failed");
			break;
		}
		case 3:
		{
			testStatus = "SKIP";
			ExtentReport.test.log(LogStatus.PASS, "Test Passed");
			break;
		}
			
		}
		
		if(ExtentReport.test != null)
		{
			ExtentReport.endTest();
			ExtentReport.test = null;
		}
		
	}
	
}
