package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.pim.employee.EmployeeTabsUI;
import pageUIs.orangehrm.pim.employee.PersonalDetailPUI;

public class PersonalDetailPO extends BasePage {
    private WebDriver driver;

    public PersonalDetailPO(WebDriver driver){
        this.driver =  driver;
    }

    public Dimension getAvatarSize() {
        return getElementSize(driver, PersonalDetailPUI.EMPLOYEE_IMAGE);
    }

    public void clickToEmployeeAvatarImage() {
        waitForElementClickable(driver,PersonalDetailPUI.EMPLOYEE_IMAGE);
        clickToElement(driver,PersonalDetailPUI.EMPLOYEE_IMAGE);
    }

    public void loadAvatarImage() {
        waitForElementClickable(driver,PersonalDetailPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver,PersonalDetailPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }

    public void clickToSaveButtonAtChangeProfilePictureContainer() {
        waitForElementClickable(driver,PersonalDetailPUI.SUCCESS_MESSAGE);
        clickToElement(driver,PersonalDetailPUI.SUCCESS_MESSAGE);
    }

    public boolean isSuccessMessageIsDisplayed() {
        waitForElementVisible(driver,PersonalDetailPUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver,PersonalDetailPUI.SUCCESS_MESSAGE);
    }

    public boolean isProfileAvatarUpdateSuccess(Dimension beforeUpload) {
        sleepInSeconds(3);
        Dimension afterUpload = getAvatarSize();
        return !(beforeUpload.equals(afterUpload));
    }
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver,PersonalDetailPUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailPUI.LASTNAME_TEXTBOX,lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver,PersonalDetailPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementText(driver,PersonalDetailPUI.EMPLOYEE_ID_TEXTBOX);
    }

    public void enterToDriverLicenseTextbox(String driverLicenseNumber) {
        waitForElementVisible(driver,PersonalDetailPUI.DRIVER_LICENSE_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailPUI.DRIVER_LICENSE_TEXTBOX,driverLicenseNumber);
    }

    public void enterToLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitForElementVisible(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX,licenseExpiryDate);
    }

    public void selectNationlityDropdown(String nationality) {
        waitForElementClickable(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_PARENT);
        checkToCheckboxRadio(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_PARENT,PersonalDetailPUI.NATIONALITY_DROPDOWN_CHILD,nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitForElementClickable(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInDropdown(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_PARENT,PersonalDetailPUI.NATIONALITY_DROPDOWN_CHILD,maritalStatus);
    }

    public void enterToDateOfBirthTextbo(String dateOfBirth) {
        waitForElementVisible(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX,dateOfBirth);
    }


    public void clickSaveButtonAtPersonalDetalContainer() {
        waitForElementClickable(driver,PersonalDetailPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
        clickToElement(driver,PersonalDetailPUI.SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER);
    }

    public void selectGenDerMaleRadioButton(String gender) {
        waitForElementClickable(driver,PersonalDetailPUI.GENDER_MALE_RADIO_BUTTON,gender);
        checkToCheckboxRadio(driver,PersonalDetailPUI.GENDER_MALE_RADIO_BUTTON,gender);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver,PersonalDetailPUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver,PersonalDetailPUI.LASTNAME_TEXTBOX,"value");
    }

    public String getDriverLicenseTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.DRIVER_LICENSE_TEXTBOX);
        return getElementAttribute(driver,PersonalDetailPUI.DRIVER_LICENSE_TEXTBOX,"value");
    }
    public String getLicenseExpiryDateTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getElementAttribute(driver,PersonalDetailPUI.LICENSE_EXPIRY_DATE_TEXTBOX,"value");
    }
    
    public String getNationalityDropdownValue() {
        waitForElementVisible(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver,PersonalDetailPUI.NATIONALITY_DROPDOWN_ITEM_SELECTED);
    }

    public String getMaritalStatusDropdownValue() {
        waitForElementVisible(driver,PersonalDetailPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
        return getElementText(driver,PersonalDetailPUI.MARITAL_STATUS_DROPDOWN_ITEM_SELECTED);
    }

    public boolean isGenderMaleRadioSelect(String gender) {
        waitForElementSelect(driver,PersonalDetailPUI.GENDER_MALE_RADIO_BUTTON,gender);
        return isElementSelected(driver,PersonalDetailPUI.GENDER_MALE_RADIO_BUTTON,gender);
    }

    public String getDateOfBirthTextboxValue() {
        waitForElementVisible(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementAttribute(driver,PersonalDetailPUI.DATE_OF_BIRTH_TEXTBOX,"value");
    }


    public void openPersonalDetailPage() {
        waitForElementClickable(driver, EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver,EmployeeTabsUI.PERSONAL_DETAIL_LINK);
    }
}
