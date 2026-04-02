package com.tests.impl;

import com.tests.pages.LoginPage;
import com.tests.pages.DashboardPage;

public class LoginImpl {

    private LoginPage loginPage;

    public LoginImpl() {
        this.loginPage = new LoginPage();
    }

    public DashboardPage loginToApplication(String username, String password) {
        return loginPage.login(username, password);
    }
}