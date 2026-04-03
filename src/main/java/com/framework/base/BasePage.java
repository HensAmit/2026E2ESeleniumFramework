package com.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.driver.DriverManager;

public class BasePage {

    protected WebDriver driver;
    protected Logger logger;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.logger = LogManager.getLogger(this.getClass());
    }

    protected void click(By locator) {
        logger.info("Clicking on element: {}", locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String value) {
        logger.info("Typing '{}' into element: {}", value, locator);
        driver.findElement(locator).sendKeys(value);
    }

    protected String getText(By locator) {
        String text = driver.findElement(locator).getText();
        logger.info("Getting text from element: {} → {}", locator, text);
        return text;
    }

    protected boolean isDisplayed(By locator) {
        boolean status = driver.findElement(locator).isDisplayed();
        logger.info("Checking visibility of element: {} → {}", locator, status);
        return status;
    }
}