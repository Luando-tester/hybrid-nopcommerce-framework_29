package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;
    public CustomerInfoPageObject (WebDriver driver){
        this.driver = driver;
    }

    public String getFirstNameTexboxValue() {
        waitForElementPresence(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver,CustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTexboxValue() {
        waitForElementPresence(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver,CustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public boolean isGenderMaleSelected() {
        waitForElementSelect(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver,CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String selectDayDropdownSelectValue() {
        waitForElementClickable(driver,CustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectItemInDropDown(driver,CustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String selectMonthDropdownSelectValue() {
        waitForElementClickable(driver,CustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectItemInDropDown(driver,CustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String selectYearDropdownSelectValue() {
        waitForElementClickable(driver,CustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectItemInDropDown(driver,CustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementPresence(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver,CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementPresence(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver,CustomerInfoPageUI.COMPANY_TEXTBOX,"value");
    }
}
