package pageObjects.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.users.UserOrderPageUI;

public class UserOrderPO extends UserSidebarPO {
    private WebDriver driver;

    public UserOrderPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserAddressPO openAddressPage(){
        waitForElementClickable(driver, UserOrderPageUI.ADDRESS_LINK);
        clickToElement(driver, UserOrderPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
}