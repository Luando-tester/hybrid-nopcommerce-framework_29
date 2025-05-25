package com.nopcommerce.uses;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.UserLoginPO;
import utilities.EnvironmentConfig;
import utilities.PropertiesConfig;

public class Level_29_Environment_Factory extends BaseTest {
    EnvironmentConfig ServerConfig;

    @Parameters({"server","platformName","browserName","browserVersion"})
    @BeforeClass
    public void beforeClass(String serverName, @Optional("LOCAL") String environmentName ,@Optional("Window") String osName,@Optional("10") String osVersion,@Optional("chrome") String browserName, String platformName, String browserVer,@Optional("localhost") String ipAddress,@Optional("4444") String portNumber) {
        ConfigFactory.setProperty("environment",serverName);
        ServerConfig = ConfigFactory.create(EnvironmentConfig.class);
        driver = getBrowserDriver(environmentName,ServerConfig.getAppUrl(),osName,osVersion,browserName,browserVer,ipAddress,portNumber);
        loginPage = PageGenerator.getUserLoginPage(driver);
    }


    @Test
    public void TC_01_Register() {

    }

    @Test
    public void TC_02_Login(){

    }

    @Test
    public void User_01_My_Account(){


    }
    @Test
    public void Sort_03_Date(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    private PropertiesConfig propertiesConfig;
    private UserLoginPO loginPage;


}
