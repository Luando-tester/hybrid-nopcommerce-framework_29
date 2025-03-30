package com.nopcommerce.uses;

import JiraConfig.JiraCreateIssue;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.admin.AdminDashBoardPO;
import pageObjects.nopcommerce.admin.AdminLoginPO;
import pageObjects.nopcommerce.users.*;


public class Level_17_JIRA extends BaseTest {

    private String adminUrl,userUrl;
    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName,String userUrl,String adminUrl) {
        this.userUrl = userUrl;
        this.adminUrl =  adminUrl;
        ChromeOptions chromeOptions =  new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:\\Users\\THANH.LUAN\\AppData\\Local\\Google\\Chrome\\User Data\\");
        chromeOptions.addArguments("--profile-directory=Profile 10");
        driver = new ChromeDriver(chromeOptions);
        driver = getBroswerDriver(browserName,userUrl);
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


    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_01_Register() {

        log.info("User_01_Register- Step 01 : Open Register");
        registerPage = homePage.clickRegisterLink();

        log.info("User_01_Register- Step 02 : Click To Male Radio");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register- Step 03 : Enter To Firstname Textbox" + firstname);
        registerPage.enterToFirstNameTextbox(firstname);
        log.info("User_01_Register- Step 04 : Enter To Lastname Textbox" + lastName);
        registerPage.enterLastNameTextbox(lastName);

//        log.info("User_01_Register- Step 05 : Select Day DropDown" + day);
//        registerPage.selectDayDropDown(day);
//        log.info("User_01_Register- Step 06 : Select Month DropDown" + month);
//        registerPage.selectMonthDropDown(month);
//
//        log.info("User_01_Register- Step 07 : Select Year DropDown" + year);
//        registerPage.selectYearDropDown(year);

        log.info("User_01_Register- Step 08 : Enter Email Textbox" + emailAddress);
        registerPage.enterEmailTextBox(emailAddress);

        log.info("User_01_Register- Step 09 : Enter Company Textbox" + companyName );
        registerPage.enterToCompanyTextBox(companyName);

        log.info("User_01_Register- Step 10 : Enter Password Textbox" +password);
        registerPage.enterToPasswordTextBox(password);

        log.info("User_01_Register- Step 11 : Enter Confirm Password Textbox" + password);
        registerPage.enterToConfirmPasswordTextBox(password);
        log.info("User_01_Register- Step 12 : Click To Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register- Step 12 : Get Register Success Message");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

//        verifyTrue(true);
        log.info("User_01_Register- Step 13 : Click to Logout Link");
        userRegisterPage.clickToLogoutLink();
    }

    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_02_Login(){
        log.info("User_02_Login- Step 01 : Click to Login Link");
        loginPage = registerPage.clickToLoginLink();

        log.info("User_02_Login- Step 02 : Login To Sytem" + emailAddress + password);
        homePage =  loginPage.loginToSystem(emailAddress,password);
        verifyTrue(homePage.isMyAccountLinkDisplayed());
    }


    @JiraCreateIssue(isCreateIssue = true)
    @Test
    public void TC_03_MyAccount(){
        log.info("User_03_MyAccount- Step 01 : Click to My Account Link");
        customerInfoPage = homePage.clickToMyAccountLink();

        log.info("User_03_MyAccount- Step 02 : Is Gender Male to Selected");
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());

        log.info("User_03_MyAccount- Step 02 : Get First Name Textbox Value" + firstname);
        Assert.assertEquals(customerInfoPage.getFirstNameTexboxValue(), firstname);
        log.info("User_03_MyAccount- Step 02 : Get Last Name Textbox Value" + lastName);
        Assert.assertEquals(customerInfoPage.getLastNameTexboxValue(),lastName);

        log.info("User_03_MyAccount- Step 02 :Get Day Dropdown Select Value" + day);
        Assert.assertEquals(customerInfoPage.selectDayDropdownSelectValue(),day);
        log.info("User_03_MyAccount- Step 02 :Get Month Dropdown Select Value" + month);
        Assert.assertEquals(customerInfoPage.selectMonthDropdownSelectValue(),month);
        log.info("User_03_MyAccount- Step 02 :Get Year Dropdown Select Value" + year);
        Assert.assertEquals(customerInfoPage.selectYearDropdownSelectValue(),year);
        log.info("User_03_MyAccount- Step 02 : Get EmailAddress Textbox Value" + emailAddress);
        Assert.assertEquals(customerInfoPage.getEmailTextboxValue(),emailAddress);

        log.info("User_03_MyAccount- Step 02 : Get CompanyName Textbox Value" + companyName);
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
