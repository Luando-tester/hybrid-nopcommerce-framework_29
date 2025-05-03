package com.nopcommerce.uses;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.*;

public class Level_07_Switch_Page_Object extends BaseTest {


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

    }

    @Test
    public void TC_02_Login(){
        loginPage = registerPage.clickToLoginLink();

        homePage =  loginPage.loginToSystem(emailAddress,password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

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
    @Test
    public void TC_04_Switch_Page(){
        addressPage = customerInfoPage.openAddressPage(driver);
        rewardPointPage = addressPage.openRewardPointPage(driver);
        orderPage = rewardPointPage.openOrderPage(driver);
        addressPage = orderPage.openAddressPage(driver);
        customerInfoPage = addressPage.openCustomerInfoPage(driver);

    }



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
    private String firstname,lastName,password,day,month,year,emailAddress,companyName;

}
