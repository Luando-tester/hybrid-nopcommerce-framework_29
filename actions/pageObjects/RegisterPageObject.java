package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;
    public RegisterPageObject (WebDriver driver){
        this.driver = driver;
    }
    public void clickToMaleRadio() {
        waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void enterToFirstNameTextbox(String firstname) {
        waitForElementClickable(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstname);
    }

    public void enterLastNameTextbox(String lastname) {
        waitForElementClickable(driver, RegisterPageUI.LAST_NAME_STRiNG);
        sendKeyToElement(driver,RegisterPageUI.LAST_NAME_STRiNG,lastname);
    }

    public void selectDayDropDown(String day) {
        waitForElementClickable(driver,RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.DAY_DROPDOWN,day);
    }

    public void selectMonthDropDown(String month) {
        waitForElementClickable(driver,RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.MONTH_DROPDOWN,month);
    }

    public void selectYearDropDown(String year) {
        waitForElementClickable(driver,RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.YEAR_DROPDOWN,year);
    }

    public void enterToCompanyTextBox(String company) {
        waitForElementClickable(driver,RegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.COMPANY_TEXTBOX,company);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextBox(String password) {
        waitForElementClickable(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickToRegisterSuccessMessage(){
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }
    public String getRegisterSuccessMessage(){
        waitForElementPresence(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickToLoginButton(){
        waitForElementClickable(driver,RegisterPageUI.LOGIN_LINK);
        clickToElement(driver,RegisterPageUI.LOGIN_LINK);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public void enterEmailTextBox(String emailAddress) {
        waitForElementClickable(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }
}
