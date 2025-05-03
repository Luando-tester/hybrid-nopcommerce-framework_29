package com.nopcommerce.uses;

import commons.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.*;
import pageObjects.saucelabs.InventoryPageObject;
import pageObjects.saucelabs.LoginPageObject;
import utilities.FakeConfig;

import java.util.Set;

public class Level_24_Data_Faker extends BaseTest {


    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBroswerDriver(browserName,url);
        loginPage = PageGenerator.getUserLoginPage(driver);
        faker = FakeConfig.getFaker();

        firstname = "John";
        lastName = "Philip";
        emailAddress = "John" + generateRandomNumber() + "@gmail.de";
        companyName = "Continental";
        password = "12345678";
    }

    @Test
    public void TC_01_Register() {
         registerPage = homePage.clickRegisterLink();

        registerPage.clickToRadioByID(driver,"gender-male");

        registerPage.enterToTextboxByID(driver,"FirstName", faker.getFirstName());
        registerPage.enterToTextboxByID(driver,"LastName",faker.gẹtLastName());
        registerPage.enterToTextboxByID(driver,"Email",faker.getEmailAddress());
        registerPage.enterToTextboxByID(driver,"Company",faker.getCompanyName());
        registerPage.clickToCheckboxByID(driver,"Newsletter");
        registerPage.enterToTextboxByID(driver,"Password",faker.getPassword());
        registerPage.enterToTextboxByID(driver,"ConfirmPassword",faker.getPassword());
        registerPage.clickToButtonBy(driver,"Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

    }

    @Test
    public void TC_02_Login(){
        loginPage = registerPage.clickToLoginLink();

        loginPage.enterToTextboxByID(driver,"Email",emailAddress);
        loginPage.enterToTextboxByID(driver,"Password",password);
        loginPage.clickToButtonBy(driver,"Log in");
        homePage = PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_01_My_Account(){
        customerInfoPage = homePage.openCustomerInfoPage(driver);
        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver,"gender-male"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"FirstName"), firstname);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"LastName"), lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Email"), emailAddress);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Company"), companyName);

        Assert.assertTrue(customerInfoPage.isCheckboxByIDSelected(driver,"Newsletter"));

    }
    @Test
    public void Sort_03_Date(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

    private WebDriver driver;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private String firstname,lastName,password,day,month,year,emailAddress,companyName;
    private FakeConfig faker;


}
