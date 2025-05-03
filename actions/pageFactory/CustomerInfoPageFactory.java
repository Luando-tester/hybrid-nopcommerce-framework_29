package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage {
    private WebDriver driver;
    public CustomerInfoPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='gender-male']")
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstNameTexbox;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTexbox;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropDown;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthDropDown;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearDropDown;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement companyTextbox;

    public String getFirstNameTexboxValue() {
        waitForElementVisible(driver,firstNameTexbox);
        return getElementAttribute(firstNameTexbox,"value");
    }

    public String getLastNameTexboxValue() {
        waitForElementVisible(driver,lastNameTexbox);
        return getElementAttribute(lastNameTexbox,"value");
    }

    public boolean isGenderMaleSelected() {
        waitForElementSelect(genderMaleRadio);
        return isElementSelected(genderMaleRadio);
    }

    public String selectDayDropdownSelectValue() {
        waitForElementClickable(driver,dayDropDown);
        return getSelectItemInDropDown(dayDropDown);
    }

    public String selectMonthDropdownSelectValue() {
        waitForElementClickable(driver,monthDropDown);
        return getSelectItemInDropDown(monthDropDown);
    }

    public String selectYearDropdownSelectValue() {
        waitForElementClickable(driver,yearDropDown);
        return getSelectItemInDropDown(yearDropDown);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver,emailTextbox);
        return getElementAttribute(emailTextbox,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver,companyTextbox);
        return getElementAttribute(companyTextbox,"value");
    }
}
