package com.tests.tests;

import com.framework.config.ConfigManager;
import com.framework.utils.DataUtils;
import com.framework.utils.ScenarioData;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.BaseTest;
import com.tests.impl.LoginImpl;
import com.tests.impl.DashboardImpl;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyWelcomeMessage() {
        DataUtils.readTestDataFromExcelSheet("TC-2", "ScenarioTwo");
        System.out.println(ScenarioData.getData("TC_ID"));
        System.out.println(ScenarioData.getData("DataOne"));
        System.out.println(ScenarioData.getData("DataFour"));
        System.out.println(ScenarioData.getData("DataFive"));
        LoginImpl login = new LoginImpl();
        login.loginToApplication(ConfigManager.get("username"), ConfigManager.get("password"));
        DashboardImpl dashboard = new DashboardImpl();
        String message = dashboard.fetchWelcomeMessage();
        Assert.assertTrue(message.contains("Swag Labs"), "Invalid welcome message");
    }
}