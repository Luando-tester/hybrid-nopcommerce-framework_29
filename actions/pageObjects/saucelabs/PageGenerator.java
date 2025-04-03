package pageObjects.saucelabs;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.DashboardPO;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static InventoryPageObject getInvertoryPage(WebDriver driver){
        return new InventoryPageObject(driver);
    }
}
