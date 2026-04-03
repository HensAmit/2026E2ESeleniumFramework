package com.tests.pages;

import com.framework.reports.ExtentLogger;
import org.openqa.selenium.By;

import com.framework.base.BasePage;
import com.framework.utils.WaitUtils;

public class LoginPage extends BasePage {

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.id("login-button");

    // Actions
    public LoginPage enterUsername(String username) {
        logger.info("------Starting enterUsername()------");
        ExtentLogger.info("------Starting enterUsername()------");
        WaitUtils.waitForElementVisible(usernameField);
        type(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        logger.info("------Starting enterPassword()------");
        ExtentLogger.info("------Starting enterPassword()------");
        WaitUtils.waitForElementVisible(passwordField);
        type(passwordField, password);
        return this;
    }

    public DashboardPage clickLogin() {
        logger.info("------Starting clickLogin()------");
        ExtentLogger.info("------Starting clickLogin()------");
        WaitUtils.waitForElementClickable(loginBtn);
        click(loginBtn);
        return new DashboardPage();
    }

    // Combined action (optional but useful)
    public DashboardPage login(String username, String password) {
        logger.info("------Starting login()------");
        ExtentLogger.info("------Starting login()------");
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}