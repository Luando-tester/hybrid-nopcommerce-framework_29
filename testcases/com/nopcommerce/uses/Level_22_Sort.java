package com.nopcommerce.uses;

import com.nopcommerce.com.Login;
import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.users.*;
import pageObjects.saucelabs.InventoryPageObject;
import pageObjects.saucelabs.LoginPageObject;
import pageObjects.saucelabs.PageGenerator;

import java.util.Set;

public class Level_22_Sort extends BaseTest {


    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBroswerDriver(browserName,url);
        loginPage = PageGenerator.getLoginPage(driver);
        inventoryPage =  loginPage.loginToApplication("standard_user","secret_sauce");
    }

  @Test
   public void Sort_01_Name() {
        inventoryPage.selectSortDropdown("Name (A to Z)");
        verifyTrue(inventoryPage.isNameSortAscending());
        inventoryPage.selectSortDropdown("Name (Z to A)");
    }

   @Test
    public void Sort_02_Price(){
        inventoryPage.selectSortDropdown("Price (low to high)");
        verifyTrue(inventoryPage.isPriceSortAscending());
        inventoryPage.selectSortDropdown("Name (high to low)");
    }

    @Test
    public void Sort_03_Date(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private InventoryPageObject inventoryPage;
}
