package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelabs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public InventoryPageObject loginToApplication(String username, String password) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.USERNAME_TEXTBOX,username);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getInvertoryPage(driver);
    }
}
