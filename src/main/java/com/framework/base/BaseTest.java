package com.framework.base;

import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framework.config.ConfigManager;
import com.framework.driver.DriverManager;

import java.lang.reflect.Method;

public class BaseTest {

    @Parameters("env")
    @BeforeMethod
    public void setUp(@Optional("qa") String env, Method method) {
        ThreadContext.put("testName", method.getName());

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