package com.nopcommerce.uses;

import commons.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.admin.AdminDashBoardPO;
import pageObjects.nopcommerce.admin.AdminLoginPO;
import pageObjects.nopcommerce.users.*;

public class Level_15_ExtentReport2 extends BaseTest {


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGenerator.getUserHomePage(driver);
        firstname="John";
        lastName="Philip";
        day="29";
        month="March";
        year="1996";
        emailAddress="John"+ generateRandomNumber() +"@gmail.de";
        companyName="Continental";
        password="12345678";
    }


    @Description("Register to application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Register() {


        registerPage = homePage.clickRegisterLink();


        registerPage.clickToMaleRadio();


        registerPage.enterToFirstNameTextbox(firstname);

        registerPage.enterLastNameTextbox(lastName);

        registerPage.selectDayDropDown(day);

        registerPage.selectMonthDropDown(month);

        registerPage.selectYearDropDown(year);

        registerPage.enterEmailTextBox(emailAddress);

        registerPage.enterToCompanyTextBox(companyName);

        registerPage.enterToPasswordTextBox(password);

        registerPage.enterToConfirmPasswordTextBox(password);

        registerPage.clickToRegisterButton();


        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

//        verifyTrue(true);

        userRegisterPage.clickToLogoutLink();
    }

    @Description("Login to application")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC_02_Login(){
        loginPage = registerPage.clickToLoginLink();

        homePage =  loginPage.loginToSystem(emailAddress,password);
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }


    @Description("Verify My Account infor")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_03_MyAccount(){

        customerInfoPage = homePage.clickToMyAccountLink();

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTexboxValue(), firstname);
        Assert.assertEquals(customerInfoPage.getLastNameTexboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.selectDayDropdownSelectValue(),day);
        Assert.assertEquals(customerInfoPage.selectMonthDropdownSelectValue(),month);
        Assert.assertEquals(customerInfoPage.selectYearDropdownSelectValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(),companyName);

    }
//    @Test
//    public void TC_04_Switch_Page(){
//        addressPage = customerInfoPage.openAddressPage(driver);
//        rewardPointPage = addressPage.openRewardPointPage(driver);
//        orderPage = rewardPointPage.openOrderPage(driver);
//        addressPage = orderPage.openAddressPage(driver);
//        customerInfoPage = addressPage.openCustomerInfoPage(driver);
//        rewardPointPage = customerInfoPage.openRewardPointPage(driver);
//        addressPage =  rewardPointPage.openAddressPage(driver);
//
//    }



    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private WebDriver driver;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashBoardPO adminDashboardPage;
    private UserRegisterPO userRegisterPage;
    private String firstname,lastName,password,day,month,year,emailAddress,companyName;

}
