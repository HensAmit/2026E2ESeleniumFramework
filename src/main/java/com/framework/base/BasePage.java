package com.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.driver.DriverManager;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}