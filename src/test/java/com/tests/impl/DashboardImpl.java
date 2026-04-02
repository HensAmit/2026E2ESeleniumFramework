package com.tests.impl;

import com.tests.pages.DashboardPage;
import com.tests.pages.LoginPage;

public class DashboardImpl {

    private DashboardPage dashboardPage;

    public DashboardImpl() {
        this.dashboardPage = new DashboardPage();
    }

    public String fetchWelcomeMessage() {
        return dashboardPage.getWelcomeMessage();
    }

    public boolean isDashboardDisplayed() {
        return dashboardPage.isDashboardLoaded();
    }

    public LoginPage logoutFromApplication() {
        return dashboardPage.clickLogout();
    }
}