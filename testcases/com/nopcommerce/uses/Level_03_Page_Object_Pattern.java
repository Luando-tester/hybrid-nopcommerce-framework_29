package com.nopcommerce.uses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.users.UserCustomerInfoPO;
import pageObjects.nopcommerce.users.UserHomePO;
import pageObjects.nopcommerce.users.UserLoginPO;
import pageObjects.nopcommerce.users.UserRegisterPO;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object_Pattern{
    private WebDriver driver;

    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPO loginPage;
    private UserCustomerInfoPO customerInfoPage;

    private String firstname,lastName,day,month,year,emailAddress,companyName,password;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        homePage = new UserHomePO(driver);
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
        homePage.clickRegisterLink();
        registerPage =  new UserRegisterPO(driver);

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
        registerPage.clickToLoginLink();
        loginPage = new UserLoginPO(driver);

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
    }

    @Test
    public void TC_03_MyAccount(){
        homePage.clickToMyAccountLink();

        customerInfoPage = new UserCustomerInfoPO(driver);

        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTexboxValue(), firstname);
        Assert.assertEquals(customerInfoPage.getLastNameTexboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.selectDayDropdownSelectValue(),day);
        Assert.assertEquals(customerInfoPage.selectMonthDropdownSelectValue(),month);
        Assert.assertEquals(customerInfoPage.selectYearDropdownSelectValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(),companyName);

    }


    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
    private int generateRandomNumber(){
        return new Random().nextInt(99999);
    }
}
