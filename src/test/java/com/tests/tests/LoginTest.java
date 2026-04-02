package com.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.tests.impl.LoginImpl;
import com.tests.pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        LoginImpl login = new LoginImpl();
        DashboardPage dashboard = login.loginToApplication("qa_user", "qa_pass");
        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded");
    }
}