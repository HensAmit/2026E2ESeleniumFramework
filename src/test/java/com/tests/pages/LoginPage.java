package com.tests.pages;

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
        WaitUtils.waitForElementVisible(usernameField);
        type(usernameField, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WaitUtils.waitForElementVisible(passwordField);
        type(passwordField, password);
        return this;
    }

    public DashboardPage clickLogin() {
        WaitUtils.waitForElementClickable(loginBtn);
        click(loginBtn);
        return new DashboardPage();
    }

    // Combined action (optional but useful)
    public DashboardPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}