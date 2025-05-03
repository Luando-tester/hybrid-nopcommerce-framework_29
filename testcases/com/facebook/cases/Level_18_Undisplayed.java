package com.facebook.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.LoginPO;
import pageObjects.facebook.PageGenerator;

public class Level_18_Undisplayed extends BaseTest {
    String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        loginPage =  PageGenerator.getLoginPage(driver);
        loginPage.clickToNewAccountButton();
    }
    @Test
    public void TC_01_Element_displayed(){
        loginPage.enterEmailAddressTextbox("dam@gmail.com");
        loginPage.sleepInSeconds(3);
        Assert.assertTrue(loginPage.isConfirmEmailTextboxDisplayed());

        loginPage.enterEmailAddressTextbox("");
        loginPage.sleepInSeconds(3);
        Assert.assertFalse(loginPage.isConfirmEmailTextboxUnDisplayed());

        loginPage.clickToCloseIcon();
        loginPage.sleepInSeconds(3);
        Assert.assertFalse(loginPage.isConfirmEmailTextboxUnDisplayed());

    }
    @Test
    public void TC_01_Element_Undisplayed(){
        loginPage.enterEmailAddressTextbox("dam@gmail.com");
        loginPage.sleepInSeconds(3);
        Assert.assertFalse(loginPage.isConfirmEmailTextboxUnDisplayed());

        loginPage.enterEmailAddressTextbox("");
        loginPage.sleepInSeconds(3);
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUnDisplayed());

        loginPage.clickToCloseIcon();
        loginPage.sleepInSeconds(3);
        Assert.assertTrue(loginPage.isConfirmEmailTextboxUnDisplayed());

    }





    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private WebDriver driver;
    private LoginPO loginPage;


}