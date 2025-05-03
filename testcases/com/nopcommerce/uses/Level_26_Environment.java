package com.nopcommerce.uses;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.*;
import utilities.ExcelConfig;
import utilities.FakeConfig;
import utilities.PropertiesConfig;

public class Level_26_Environment extends BaseTest {


    @Parameters({"browser","environment"})
    @BeforeClass
    public void beforeClass(String browserName,String environment) {
        propertiesConfig = PropertiesConfig.getProperties(environment);
        driver = getBroswerDriver(browserName,propertiesConfig.getApplicationUrl());

        System.out.println(propertiesConfig.getApplicationUrl());
        System.out.println(propertiesConfig.getApplicationUserName());
        System.out.println(propertiesConfig.getApplicationPassword());
        ConfigFactory.getProperty("App.url");
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



}
