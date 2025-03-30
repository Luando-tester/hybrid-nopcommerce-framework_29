package pageObjects.orangehrm.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.PageGenerator;
import pageUIs.orangehrm.pim.employee.EmployeeTabsUI;

public class EmployeeTabs extends BasePage {
    private WebDriver driver;

    public EmployeeTabs(WebDriver driver){
        this.driver =  driver;
    }
    public PersonalDetailPO openPersonalDetailPage(){
        waitForElementClickable(driver, EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver,EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getPersonalDetailPage(driver);
    }
    public ContactDetailsPO openContactDetailPage(){
        waitForElementClickable(driver,EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver,EmployeeTabsUI.PERSONAL_DETAIL_LINK);
        return PageGenerator.getContactDetailPage(driver);
    }
    public PersonalDetailPO openEmergencyContactPage(){
        waitForElementClickable(driver,EmployeeTabsUI.EMERGENCY_CONTACT_LINK);
        clickToElement(driver,EmployeeTabsUI.EMERGENCY_CONTACT_LINK);
        return PageGenerator.getPersonalDetailPage(driver);
    }
}
