package com.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.tests.impl.LoginImpl;
import com.tests.impl.DashboardImpl;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyWelcomeMessage() {
        LoginImpl login = new LoginImpl();
        login.loginToApplication("qa_user", "qa_pass");
        DashboardImpl dashboard = new DashboardImpl();
        String message = dashboard.fetchWelcomeMessage();
        Assert.assertTrue(message.contains("Welcome"), "Invalid welcome message");
    }
}