package pageObjects;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject (WebDriver driver){
        this.driver = driver;
    }
    public void clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }
}
