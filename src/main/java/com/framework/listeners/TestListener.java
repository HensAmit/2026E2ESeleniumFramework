package com.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.reports.ExtentReportManager;
import com.framework.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.initReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());

        ExtentReportManager.getTest()
                .fail(result.getThrowable())
                .addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReports();
    }
}