package com.nopcommerce.uses;

import commons.BaseTest;
import data.UserLevelData;
import employee.Employee;
import employee.EmployeeList;
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

public class Level_25_Manage_Data extends BaseTest {


    @Parameters({"browser","userUrl","firstName","lastName","email","company","password"})
    @BeforeClass
    public void beforeClass(String browserName,String url,String firstname,String lastName,String companyName,String password) {
        driver = getBroswerDriver(browserName,url);
        homePage = PageGenerator.getUserHomePage(driver);
//        faker = FakeConfig.getFaker();
//        this.firstname = Users.RegisterLogin.FIRST_NAME;
//        this.lastName = Users.RegisterLogin.LAST_NAME;
//        this.emailAddress = Users.RegisterLogin.PREFIX_EMAIL_ADDRESS + generateRandomNumber() + Users.RegisterLogin.POSTFIX_EMAIL_ADDRESS;
//        this.companyName =  Users.RegisterLogin.COMPANY;
//        this.password = Users.RegisterLogin.PASSWORD;
//        userData = UserLevelData.getUserLevelData();
//        employeeData = Employee.getEmployee();
//        employeeList = EmployeeList.getEmployeeList();
//        for (EmployeeList.Employee employee :employeeList.getEmployee()){
//            System.out.println(employee.getName());
//            System.out.println(employee.getEmailAddress());
//            System.out.println(employee.getAgeNumber());
//        }

        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("Employee");
        emailAddress = excelConfig.getCellData("EmailAddress",1) + generateRandomNumber() + "@gmail.net";
//        System.out.println("Name = " + employeeData.getName());
//        System.out.println("Position = " + employeeData.getPosition());
//        System.out.println("Skill tree =" + employeeData.getSkilltree().get(0));
//        for(int i = 0;i< employeeData.getSkilltree().size();i++){
//            System.out.println("Skill Tree =" + employeeData.getSkilltree().get(i));
//        }
//        System.out.println("Address Street =" + employeeData.getAddress().getStreetName());
//        System.out.println("Address No =" + employeeData.getAddress().getStreetNumber());
//        userData.setFirstName("John");
//        userData.setLastName("Kennedy");
//        userData.setCompanyName("John Limited");
//        userData.setEmailAddress("john.kenn" + generateRandomNumber() + "@gmail.net");
//        userData.setPassword("123456789");
//        userData.getFirstname();
//        userData.getLastname();
//        userData.getFullName();
//        userData.getPassword();
    }

    @Test
    public void TC_01_Register() {
         registerPage = homePage.clickRegisterLink();

        registerPage.clickToRadioByID(driver,"gender-male");
//        registerPage.isLanguageDisplayed(employeeData.getSkilltree());
        registerPage.enterToTextboxByID(driver,"FirstName", excelConfig.getCellData("FirstName",1));
        registerPage.enterToTextboxByID(driver,"LastName", excelConfig.getCellData("LastName",1));
        registerPage.enterToTextboxByID(driver,"Email", emailAddress);
        registerPage.enterToTextboxByID(driver,"Company", excelConfig.getCellData("Company",1));
        registerPage.clickToCheckboxByID(driver,"Newsletter");
        registerPage.enterToTextboxByID(driver,"Password", excelConfig.getCellData("Password",1));
        registerPage.enterToTextboxByID(driver,"ConfirmPassword", excelConfig.getCellData("Password",1));

//        registerPage.enterToFirstNameTextbox(userInfo.getFirstName());
//        registerPage.enterLastNameTextbox(userInfo.getLastName());
//        registerPage.enterToCompanyTextBox(userInfo.getCompanyName());
//        registerPage.enterToPasswordTextBox(userInfo.getPassword());
//        registerPage.enterEmailTextBox(userInfo.getEmailAddress());
//        registerPage.enterToConfirmPasswordTextBox(userInfo.getPassword());

//        registerPage.enterRegisterForm(userInfo);
//        registerPage.enterToRegister("","","","","");
        registerPage.clickToButtonBy(driver,"Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");

    }

    @Test
    public void TC_02_Login(){
        homePage = registerPage.clickToLogoutLink();
        loginPage = homePage.openLoginPage();

        loginPage.enterToTextboxByID(driver,"Email",emailAddress);
        loginPage.enterToTextboxByID(driver,"Password", excelConfig.getCellData("Password",1));
//        homePage =  loginPage.enterToLoginForm(userInfo);
        loginPage.clickToButtonByText(driver,"Log in");
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_01_My_Account(){
        customerInfoPage = homePage.openCustomerInfoPage(driver);
        Assert.assertTrue(customerInfoPage.isRadioByIDSelected(driver,"gender-male"));

        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"FirstName"), excelConfig.getCellData("FirstName",1));
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"LastName"), excelConfig.getCellData("LastName",1));
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Email"), excelConfig.getCellData("Email",1));
        Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver,"Company"), excelConfig.getCellData("Password",1));

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
//    private UserInfo userInfo;
//    private UserData userData;
//    private UserLevelData userData;
//    private Employee employeeData;
//    private EmployeeList employeeList;
    private ExcelConfig excelConfig;


}
