package com.framework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.framework.config.ConfigManager;
import com.framework.driver.DriverManager;

public class BaseTest {

    @Parameters("env")
    @BeforeMethod
    public void setUp(String env) {

        if (env == null) {
            env = "qa"; // default
        }

        ConfigManager.init(env);
        DriverManager.initDriver();

        DriverManager.getDriver().get(ConfigManager.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        ConfigManager.unload();
    }
}