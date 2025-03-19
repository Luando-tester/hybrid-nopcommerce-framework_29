package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {
    private WebDriver driver;
    public RegisterPageFactory(WebDriver driver){
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

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    private WebElement confirmpasswordTextbox;

    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logOut;

    @FindBy(xpath = "//li[text()='1']")
    @CacheLookup
    private WebElement oneNumberText;

    public void clickToOneNumberText(){
        waitForElementClickable(driver,oneNumberText);
        clickToElement(oneNumberText);
    }

    public boolean isOneNumberTextSelected(){
        waitForElementSelect(oneNumberText);
        return isElementSelected(oneNumberText);
    }

    @FindBy(css="button.fhs-btn-login")
    private WebElement loginButton;

    public boolean isLoginButtonDisabled(){
        waitForElementVisible(driver,loginButton);
        return  isElementDisplayed(loginButton);
    }

    public void clickToMaleRadio() {
        waitForElementClickable(driver, genderMaleRadio);
        checkToCheckboxRadio(genderMaleRadio);
    }

    public void enterToFirstNameTextbox(String firstname) {
        waitForElementClickable(driver,firstNameTexbox);
        sendKeyToElement(firstNameTexbox,firstname);
    }

    public void enterLastNameTextbox(String lastname) {
        waitForElementClickable(driver, lastNameTexbox);
        sendKeyToElement(lastNameTexbox,lastname);
    }

    public void selectDayDropDown(String day) {
        waitForElementClickable(driver,dayDropDown);
        selectItemInDropdown(dayDropDown,day);
    }

    public void selectMonthDropDown(String month) {
        waitForElementClickable(driver,monthDropDown);
        selectItemInDropdown(monthDropDown,month);
    }

    public void selectYearDropDown(String year) {
        waitForElementClickable(driver,yearDropDown);
        selectItemInDropdown(yearDropDown,year);;
    }

    public void enterToCompanyTextBox(String company) {
        waitForElementClickable(driver, companyTextbox);
        sendKeyToElement(companyTextbox,company);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox,password);
    }

    public void enterToConfirmPasswordTextBox(String password) {
        waitForElementClickable(driver, confirmpasswordTextbox);
        sendKeyToElement(confirmpasswordTextbox,password);
    }

    public void clickToRegisterSuccessMessage(){
        waitForElementClickable(driver, registerButton);
        clickToRegisterButton();
    }
    public String getRegisterSuccessMessage(){
        waitForElementVisible(driver,registerSuccessMessage);
        return getElementText(registerSuccessMessage);
    }

    public void clickToLoginButton(){
        waitForElementClickable(driver, loginLink);
        clickToElement(loginLink);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,registerButton);
        clickToElement(registerButton);
    }

    public void enterEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, emailTextbox);
        sendKeyToElement(emailTextbox,emailAddress);
    }

    public void clickToLogoutPage() {
        waitForElementClickable(driver,logOut);
        clickToElement(logOut);
    }
}
