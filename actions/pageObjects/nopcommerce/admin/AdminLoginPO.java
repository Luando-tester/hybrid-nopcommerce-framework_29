package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver){
        this.driver = driver;
    }
    public AdminDashBoardPO clickToLoginButton(){
        waitForElementClickable(driver,AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashBoardPage(driver);
    }

    public void enterToEmailTextbox(String emailAddress){
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
        clickToElement(driver,AdminLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,AdminLoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password){
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        clickToElement(driver,AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,AdminLoginPageUI.PASSWORD_TEXTBOX,password);
    }
}

