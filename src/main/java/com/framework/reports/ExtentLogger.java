package com.framework.reports;

import com.aventstack.extentreports.Status;

public final class ExtentLogger {

    private ExtentLogger() {}

    public static void info(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.INFO, message);
        }
    }

    public static void pass(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().pass(message);
        }
    }

    public static void fail(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().fail(message);
        }
    }

    public static void skip(String message) {
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().skip(message);
        }
    }
}