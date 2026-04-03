package com.tests.tests;

import com.framework.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.tests.impl.LoginImpl;
import com.tests.pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        LoginImpl login = new LoginImpl();
        DashboardPage dashboard = login.loginToApplication(ConfigManager.get("username"), ConfigManager.get("password"));
        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded");
    }
}