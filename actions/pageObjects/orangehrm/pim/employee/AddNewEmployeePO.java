package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.AddNewPUI;
import pageUIs.orangehrm.pim.employee.EmployeeListPUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver){
        this.driver =  driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddNewPUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver,AddNewPUI.FIRSTNAME_TEXTBOX,firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddNewPUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver,AddNewPUI.LASTNAME_TEXTBOX,lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver,AddNewPUI.EMPLOYEE_ID_TEXTBOX);
        return getElementText(driver,AddNewPUI.EMPLOYEE_ID_TEXTBOX);
    }

    public PersonalDetailPO clickToSaveButtonAtEmployeeContainer() {
        waitForElementClickable(driver, EmployeeListPUI.SAVE_BUTTON_AI_ADD_EMPLOYEE_CONTAINER);
        clickToElement(driver,AddNewPUI.SAVE_BUTTON_AI_ADD_EMPLOYEE_CONTAINER);
        waitAllLoadIconInvisible(driver);
        return PageGenerator.getPersonalDetailPage(driver);
    }
}
