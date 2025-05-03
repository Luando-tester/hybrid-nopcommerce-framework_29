package com.orangehrm;

import commons.BaseTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.PageGenerator;
import pageObjects.orangehrm.pim.employee.AddNewEmployeePO;
import pageObjects.orangehrm.pim.employee.EmployeeListPO;
import pageObjects.orangehrm.pim.employee.PersonalDetailPO;


public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailsPage;
    private String employeeID,firstName,lastName,editFirstName,editLastName;
    private AddNewEmployeePO addNewEmployeePage;
    private String avtarImagename = "HoChiMinh.jpg";
    private String driverLicenseNumber,driveLicenseExpiryDate,nationality,maritalStatus,dateOfBirth,gender;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBroswerDriver(browserName,url);
        loginPage = PageGenerator.getLoginPage(driver);

        firstName = "John";
        lastName = "Wick";
        editFirstName = "Donald";
        editLastName = "Trump";
        driverLicenseNumber = "012345678";
        driveLicenseExpiryDate = "2030-10-10";
        nationality = "American";
        maritalStatus = "Married";
        dateOfBirth = "1995-03-05";
        gender = "Male";
        loginPage.enterToUserNameTextbox("automationfc");
        loginPage.enterToPasswordTextbox("pgbFY&n3rsSr$0Bmvk&P");
        dashboardPage = loginPage.clickToLoginButton();
    }

    @Test
    public void TC_01_Add_new() {
        employeeListPage = dashboardPage.clickToPIMPage();
        addNewEmployeePage =  employeeListPage.clickToAddEmployeeButton();
        addNewEmployeePage.enterToFirstNameTextbox("");
        addNewEmployeePage.enterToLastNameTextbox("");
        employeeID = addNewEmployeePage.getEmployeeID();

        personalDetailsPage = addNewEmployeePage.clickToSaveButtonAtEmployeeContainer();

    }

    @Test
    public void TC_02_Upload_Avatar() {
        personalDetailsPage.clickToEmployeeAvatarImage();

        Dimension beforeUpload = personalDetailsPage.getAvatarSize();

        personalDetailsPage.uploadMultipleFiles(driver,avtarImagename);

        personalDetailsPage.loadAvatarImage();

        personalDetailsPage.clickToSaveButtonAtChangeProfilePictureContainer();

        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed());

        personalDetailsPage.waitAllLoadIconInvisible(driver);

        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccess(beforeUpload));
    }

    @Test
    public void TC_03_Personal_Detail() {
        personalDetailsPage.openPersonalDetailPage();
        personalDetailsPage.enterToFirstNameTextbox(editFirstName);
        personalDetailsPage.enterToLastNameTextbox(editLastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(),employeeID);
        personalDetailsPage.enterToDriverLicenseTextbox(driverLicenseNumber);
        personalDetailsPage.enterToLicenseExpiryDateTextbox(driveLicenseExpiryDate);

        personalDetailsPage.selectNationlityDropdown(nationality);
        personalDetailsPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.enterToDateOfBirthTextbo(dateOfBirth);
        personalDetailsPage.selectGenDerMaleRadioButton("");
        personalDetailsPage.clickSaveButtonAtPersonalDetalContainer();
        Assert.assertTrue(personalDetailsPage.isSuccessMessageIsDisplayed());
        personalDetailsPage.waitAllLoadIconInvisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(),editFirstName);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(),editLastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(),employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextboxValue(),driverLicenseNumber);
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownValue(),driveLicenseExpiryDate);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownValue(),nationality);
        Assert.assertEquals(personalDetailsPage.getLicenseExpiryDateTextboxValue(),maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextboxValue(),dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderMaleRadioSelect(gender));

    }

    @Test
    public void TC_04_Contact_Detail() {

    }

    @Test
    public void TC_05_Emergency_Detail() {

    }

    @Test
    public void TC_06_Assigned_Dependents() {

    }

    @Test
    public void TC_07_Edit_View_Job() {

    }

    @Test
    public void TC_08_Edit_View_Salary() {

    }

    @Test
    public void TC_09_Edit_View_Tax() {

    }

    @Test
    public void TC_10_Qualification() {

    }

    @Test
    public void TC_11_Search_Employee() {

    }




    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}