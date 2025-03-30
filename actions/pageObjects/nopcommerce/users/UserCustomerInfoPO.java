package pageObjects.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;
    public UserCustomerInfoPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTexboxValue() {
        waitForElementPresence(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTexboxValue() {
        waitForElementPresence(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public boolean isGenderMaleSelected() {
        waitForElementSelect(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String selectDayDropdownSelectValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return getSelectItemInDropDown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String selectMonthDropdownSelectValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectItemInDropDown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String selectYearDropdownSelectValue() {
        waitForElementClickable(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectItemInDropDown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextboxValue() {
        waitForElementPresence(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementPresence(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX,"value");
    }
    public UserAddressPO openAddressPage(){
        waitForElementClickable(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
        clickToElement(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
}
