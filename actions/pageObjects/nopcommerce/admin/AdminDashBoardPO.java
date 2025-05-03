package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminDashBoardPO extends BasePage {
    WebDriver driver;
    public AdminDashBoardPO(WebDriver driver){
        this.driver = driver;
    }
}
