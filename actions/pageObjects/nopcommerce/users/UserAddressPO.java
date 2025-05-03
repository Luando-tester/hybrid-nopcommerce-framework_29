package pageObjects.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.users.UserAddressPageUI;
import pageUIs.users.UserCustomerInfoPageUI;
import pageUIs.users.UserRewardPointPageUI;

public class UserAddressPO extends UserSidebarPO {
    private WebDriver driver;

    public UserAddressPO(WebDriver driver) {
       super(driver);
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage(){
        waitForElementClickable(driver, UserAddressPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage(){
        waitForElementClickable(driver, UserRewardPointPageUI.ORDER_LINK);
        clickToElement(driver, UserRewardPointPageUI.ORDER_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }


}