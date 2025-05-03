package pageUIs.orangehrm.pim.employee;

public class PersonalDetailPUI {
    public static final String EMPLOYEE_IMAGE = "Css=div.orangehrm-edit-employee-image>img.employee-image";
    public static final String SAVE_BUTTON_AT_CHANGE_PROFILE_CONTAINER = "Xpath=//h6[text()='Change Profile Picture']/following-sibling::form//button[contains(string(),'Save')]";
    public static final String SUCCESS_MESSAGE = "Xpath=//div[contains(@class,'oxd-toast-content')]/p[text()='Successfully Updated']";
    public static final String FIRSTNAME_TEXTBOX = "name=firstName";
    public static final String LASTNAME_TEXTBOX = "name=lastName";
    public static final String EMPLOYEE_ID_TEXTBOX = "Xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_TEXTBOX = "Xpath=//label[text()='Driver's License Number']/parent::div/following-sibling::div//input";
    public static final String LICENSE_EXPIRY_DATE_TEXTBOX = "Xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "Xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD = "Xpath=//label[text)='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String NATIONALITY_DROPDOWN_ITEM_SELECTED = "Xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "Xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "Xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-option')]/span";
    public static final String DATE_OF_BIRTH_TEXTBOX = "Xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String MARITAL_STATUS_DROPDOWN_ITEM_SELECTED = "Xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text-input')]";
    public static final String GENDER_MALE_RADIO_BUTTON = "Xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[contains(string(),'%s')]/input";
    public static final String SAVE_BUTTON_AT_CHANGE_PERSONAL_DETAIL = "Xpath==//h6[text()=Personal Details']/following-sibling::form//button[contains(String(),Save]";
}
