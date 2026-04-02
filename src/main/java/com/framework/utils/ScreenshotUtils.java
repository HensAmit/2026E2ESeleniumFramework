package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.driver.DriverManager;

public final class ScreenshotUtils {

    private ScreenshotUtils() {}

    public static String captureScreenshot(String testName) {

        File src = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String path = "test-output/screenshots/" + testName + ".png";

        try {
            Files.createDirectories(new File("test-output/screenshots").toPath());
            Files.copy(src.toPath(), new File(path).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Screenshot capture failed", e);
        }

        return path;
    }
}