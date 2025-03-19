package pageObjects.users;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserRewardPointPageUI;

public class UserRewardPointPO extends UserSidebarPO {
    private WebDriver driver;

    public UserRewardPointPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserOrderPO openOrderPage(){
        waitForElementClickable(driver, UserRewardPointPageUI.ORDER_LINK);
        clickToElement(driver, UserRewardPointPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
}