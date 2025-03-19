package pageObjects.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageUIs.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;
    public UserRegisterPO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Click to male radio button")
    public void clickToMaleRadio() {
        waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
    }

    @Step("Enter To FirstName Textbox : {0}")
    public void enterToFirstNameTextbox(String firstname) {
        waitForElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX,firstname);
    }

    @Step("Enter To LastName Textbox : {0}")
    public void enterLastNameTextbox(String lastname) {
        waitForElementClickable(driver, UserRegisterPageUI.LAST_NAME_STRiNG);
        sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_STRiNG,lastname);
    }

    @Step("Select Day Dropdown : {0}")
    public void selectDayDropDown(String day) {
        waitForElementClickable(driver, UserRegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.DAY_DROPDOWN,day);
    }

    @Step("Select Month Dropdown : {0}")
    public void selectMonthDropDown(String month) {
        waitForElementClickable(driver, UserRegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN,month);
    }

    @Step("Select Year Dropdown : {0}")
    public void selectYearDropDown(String year) {
        waitForElementClickable(driver, UserRegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN,year);
    }

    @Step("Enter To Company Textbox : {0}")
    public void enterToCompanyTextBox(String company) {
        waitForElementClickable(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX,company);
    }

    @Step("Enter To Password Textbox : {0}")
    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    @Step("Enter To  Confirm Password Textbox : {0}")
    public void enterToConfirmPasswordTextBox(String password) {
        waitForElementClickable(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    @Step("Click To Register Success Message")
    public void clickToRegisterSuccessMessage(){
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Get Register Success Message")
    public String getRegisterSuccessMessage(){
        waitForElementPresence(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Click To Login Link")
    public UserLoginPO clickToLoginLink(){
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    @Step("Click To Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Enter To  Email Password Textbox : {0}")
    public void enterEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    @Step("Open Login Page")
    public UserLoginPO openLoginPage(){
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }
    @Step("Click To Logout Link")
    public UserHomePO clickToLogoutLink(){
        waitForElementClickable(driver,UserRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver,UserRegisterPageUI.LOGOUT_LINK);
        return PageGenerator.getUserHomePage(driver);
    }
}
