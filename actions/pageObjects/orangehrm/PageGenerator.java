package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.pim.employee.*;
import pageObjects.orangehrm.pim.reports.AddNewReportPO;


public class PageGenerator {
    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }
    public static DashboardPO getDashboardPage(WebDriver driver){
        return new DashboardPO(driver);
    }
    public static AddNewEmployeePO getAddNewEmployeePage(WebDriver driver){
        return new AddNewEmployeePO(driver);
    }
    public static EmployeeListPO getEmployeeListPage(WebDriver driver){
        return new EmployeeListPO(driver);
    }
    public static PersonalDetailPO getPersonalDetailPage(WebDriver driver){
        return new PersonalDetailPO(driver);
    }
    public static ContactDetailsPO getContactDetailPage(WebDriver driver){
        return new ContactDetailsPO(driver);
    }

    public static EmergencyContactPO getEmergencyContactPage(WebDriver driver){
        return new EmergencyContactPO(driver);
    }
}
