package pageObjects.orangehrm.pim.configurations;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DataImportPO extends BasePage {
    private WebDriver driver;

    public DataImportPO(WebDriver driver){
        this.driver =  driver;
    }
}
