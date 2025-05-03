package com.nopcommerce.uses;

import commons.BaseTest;
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

public class Level_09_Switch_Url extends BaseTest {

    private String adminUrl,userUrl;
    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String adminUrl , String userUrl) {
        this.userUrl = userUrl;
        this.adminUrl =  userUrl;

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

        userRegisterPage.clickToLogoutLink();
    }

    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        loginPage = homePage.openLoginPage();

        homePage =  loginPage.loginToSystem(emailAddress,password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        homePage.openPageUrl(driver,this.adminUrl);
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);
        adminLoginPage.enterToEmailTextbox(emailAddress);
        adminLoginPage.enterToPasswordTextbox(password);
        adminDashboardPage =  adminLoginPage.clickToLoginButton();


        adminDashboardPage = PageGenerator.getAdminDashBoardPage(driver);
    }
    @Test
    public void Role_02_Admin_Site_To_User_Site() {
        adminDashboardPage.openPageUrl(driver,this.userUrl);
        homePage = PageGenerator.getUserHomePage(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertEquals(customerInfoPage.getFirstNameTexboxValue(),firstname);
        Assert.assertEquals(customerInfoPage.getLastNameTexboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.selectDayDropdownSelectValue(),day);
        Assert.assertEquals(customerInfoPage.selectMonthDropdownSelectValue(),month);
        Assert.assertEquals(customerInfoPage.selectYearDropdownSelectValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(),companyName);

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
    private AdminLoginPO adminLoginPage;
    private AdminDashBoardPO adminDashboardPage;
    private UserRegisterPO userRegisterPage;
    private String firstname,lastName,password,day,month,year,emailAddress,companyName;

}
