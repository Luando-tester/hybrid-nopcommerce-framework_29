package pageObjects.nopcommerce.users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.users.UserHomePageUI;
import pageUIs.users.UserRegisterPageUI;

public class UserHomePO extends BasePage{

    private WebDriver driver;

    public UserHomePO(WebDriver driver){
        this.driver = driver;
    }

    @Step("Open Register page")
    public UserRegisterPO clickRegisterLink() {
        waitForElementClickable(driver, UserHomePageUI.RESGITER_LINK);
        clickToElement(driver, UserHomePageUI.RESGITER_LINK);
        return new UserRegisterPO(driver);
    }

    @Step("Verify My Account Link")
    public boolean isMyAccountLinkDisplayed() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }
    @Step("Verify Click to My Account Link")
    public UserCustomerInfoPO clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }
    @Step("Verify Open Login Page")
    public UserLoginPO openLoginPage(){
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

}
