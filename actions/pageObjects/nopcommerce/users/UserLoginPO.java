package pageObjects.nopcommerce.users;

import commons.BasePage;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.users.UserHomePageUI;
import pageUIs.users.UserLoginPageUI;
import org.openqa.selenium.WebDriver;
import pageUIs.users.UserRegisterPageUI;
import pojo.UserInfo;

public class UserLoginPO extends BasePage {
    private WebDriver driver;
    public UserLoginPO(WebDriver driver){
        this.driver = driver;
    }
    public void clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
    }

    public UserHomePO loginToSystem(String emailAddress, String password){
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextBox(password);
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementClickable(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementClickable(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX,password);
    }
    public UserLoginPO clickToLoginLink(){
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }


    public UserHomePO enterToLoginForm(UserInfo userInfo) {
        enterToEmailTextBox(userInfo.getEmailAddress());
        enterToPasswordTextBox(userInfo.getPassword());
        clickToLoginButton();
        return PageGenerator.getUserHomePage(driver);
    }
}
