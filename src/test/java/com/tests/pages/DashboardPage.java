package com.tests.pages;

import org.openqa.selenium.By;

import com.framework.base.BasePage;
import com.framework.utils.WaitUtils;

public class DashboardPage extends BasePage {

    // Locators
    private final By welcomeText = By.xpath("//div[text()='Swag Labs']");
    private final By logoutBtn = By.id("logout");

    // Actions
    public String getWelcomeMessage() {
        logger.info("------Starting getWelcomeMessage()------");
        WaitUtils.waitForElementVisible(welcomeText);
        return getText(welcomeText);
    }

    public LoginPage clickLogout() {
        logger.info("------Starting clickLogout()------");
        WaitUtils.waitForElementClickable(logoutBtn);
        click(logoutBtn);
        return new LoginPage();
    }

    public boolean isDashboardLoaded() {
        logger.info("------Starting isDashboardLoaded()------");
        return isDisplayed(welcomeText);
    }
}