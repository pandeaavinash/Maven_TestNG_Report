package com.facebook.report;

import java.util.ArrayList;
import java.util.List;



public class ReportingDetails 
{
	private String testCaseName = null;
	/**
	 * @return the testCaseName
	 */
	public String getTestCaseName() {
		return testCaseName;
	}
	/**
	 * @param testCaseName the testCaseName to set
	 */
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	/**
	 * @return the testResult
	 */
	public String getTestResult() {
		return testResult;
	}
	/**
	 * @param testResult the testResult to set
	 */
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	/**
	 * @return the testStartTime
	 */
	public Long getTestStartTime() {
		return testStartTime;
	}
	/**
	 * @param testStartTime the testStartTime to set
	 */
	public void setTestStartTime(Long testStartTime) {
		this.testStartTime = testStartTime;
	}
	/**
	 * @return the testError
	 */
	public String getTestError() {
		return testError;
	}
	/**
	 * @param testError the testError to set
	 */
	public void setTestError(String testError) {
		this.testError = testError;
	}
	/**
	 * @return the steps
	 */
	public List<String> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
	/**
	 * @return the testEndTime
	 */
	public String getTestEndTime() {
		return testEndTime;
	}
	/**
	 * @param testEndTime the testEndTime to set
	 */
	public void setTestEndTime(String testEndTime) {
		this.testEndTime = testEndTime;
	}
	private String testResult = null;
	private Long testStartTime;
	private String testError = null;
	List<String> steps = new ArrayList<>();
	private String testEndTime = null;

}
