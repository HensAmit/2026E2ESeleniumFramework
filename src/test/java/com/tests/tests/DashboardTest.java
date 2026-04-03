package com.tests.tests;

import com.framework.config.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.tests.impl.LoginImpl;
import com.tests.impl.DashboardImpl;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyWelcomeMessage() {
        LoginImpl login = new LoginImpl();
        login.loginToApplication(ConfigManager.get("username"), ConfigManager.get("password"));
        DashboardImpl dashboard = new DashboardImpl();
        String message = dashboard.fetchWelcomeMessage();
        Assert.assertTrue(message.contains("Swag Labs"), "Invalid welcome message");
    }
}