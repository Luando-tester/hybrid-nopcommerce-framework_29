package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver){
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String username) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver,LoginPUI.USERNAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPUI.PASSWORD_TEXTBOX,password);
    }

    public DashboardPO clickToLoginButton() {
        waitForElementClickable(driver,LoginPUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPUI.LOGIN_BUTTON);
        return  PageGenerator.getDashboardPage(driver);
    }
}
