package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    private WebDriver driver;

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;


    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement accountLink;
    public void clickToLoginButton() {
        waitForElementClickable(driver,loginButton);
        clickToElement(loginButton);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementClickable(driver,emailTextbox);
        sendKeyToElement(emailTextbox,emailAddress);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, accountLink);
        return isElementDisplayed(accountLink);
    }

    public void loginToSystem(String emailAddress, String password){
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, passwordTextbox);
        sendKeyToElement(passwordTextbox,password);
    }
}
