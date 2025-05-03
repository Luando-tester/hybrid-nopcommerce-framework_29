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

import java.util.Set;

public class Level_19_Pattern_Object extends BaseTest {


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

        registerPage.clickToRadioByID(driver,"gender-male");

        registerPage.enterToTextboxByID(driver,"FirstName",firstname);
        registerPage.enterToTextboxByID(driver,"LastName",lastName);
        registerPage.enterToTextboxByID(driver,"Email",emailAddress);
        registerPage.enterToTextboxByID(driver,"Company",companyName);
        registerPage.clickToCheckboxByID(driver,"Newsletter");
        registerPage.enterToTextboxByID(driver,"Password",password);
        registerPage.enterToTextboxByID(driver,"ConfirmPassword",password);
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
    public void TC_03_MyAccount(){
        customerInfoPage = homePage.openCustomerInfoPage(driver);
        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver,"gender-male"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"FirstName"), firstname);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"LastName"), lastName);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Email"), emailAddress);
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Company"), companyName);

        Assert.assertTrue(customerInfoPage.isCheckboxByIDSelected(driver,"Newsletter"));

        nopcommerceCookies = homePage.getAllCookies(driver);
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
    private String firstname,lastName,password,day,month,year,emailAddress,companyName;
    public Set<Cookie> nopcommerceCookies;
}
