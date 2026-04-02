package com.framework.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.framework.constants.FrameworkConstants;

public final class ExtentReportManager {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private ExtentReportManager() {}

    public static void initReports() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
    }

    public static void createTest(String testName) {
        test.set(extent.createTest(testName));
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}