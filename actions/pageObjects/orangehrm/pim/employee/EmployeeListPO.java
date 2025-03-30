package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    public EmployeeListPO(WebDriver driver){
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeButton() {
        waitAllLoadIconInvisible(driver);
        return PageGenerator.getAddNewEmployeePage(driver);
    }

}
