package com.tests.tests;

import com.framework.config.ConfigManager;
import com.framework.utils.DataUtils;
import com.framework.utils.ScenarioData;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.tests.impl.LoginImpl;
import com.tests.pages.DashboardPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {
        DataUtils.readTestDataFromExcelSheet("TC-1", "ScenarioOne");
        System.out.println(ScenarioData.getData("TC_ID"));
        System.out.println(ScenarioData.getData("DataOne"));
        System.out.println(ScenarioData.getData("DataTwo"));
        System.out.println(ScenarioData.getData("DataThree"));
        LoginImpl login = new LoginImpl();
        DashboardPage dashboard = login.loginToApplication(ConfigManager.get("username"), ConfigManager.get("password"));
        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded");
    }
}