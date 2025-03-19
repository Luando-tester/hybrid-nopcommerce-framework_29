package commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected WebDriver driver;
    protected final Log log;
    private String projectPath = System.getProperty("user.dir");

    public BaseTest() {
       log = LogFactory.getLog(getClass());
    }

    public WebDriver getDriver() {
        return driver;
    }
    protected WebDriver getBrowserDriver(String browserName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch(browserList){
            case FIREFOX:
//                System.setProperty("webdriver.gecko.driver", projectPath + "\\hybrid-nopcommerce-framework\\browserDriver\\geckodriver.exe");
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                driver = WebDriverManager.firefoxdriver().capalities().create();
                driver = new FirefoxDriver();
                break;
            case CHROME:
//                ChromeOptions chromeOptions = new ChromeOptions();
//                System.setProperty("webdriver.chrome.driver", projectPath + "\\hybrid-nopcommerce-framework\\browserDriver\\chromedriver.exe");
                driver = new ChromeDriver();
//                driver = WebDriverManager.chromedriver().capalities().create();
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
//                System.setProperty("webdriver.edge.driver", projectPath + "\\hybrid-nopcommerce-framework\\browserDriver\\msedgedriver.exe");
                driver =  new EdgeDriver();
//                driver = WebDriverManager.edgedriver().capalities().create();
                break;
            default:
                throw new RuntimeException("browser name is not valid");
        }

        driver.get(GlobalContants.DEV_USER_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return driver;
    }
    protected WebDriver getBroswerDriver(String browserName,String url){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX :
                driver = new FirefoxDriver();
                break;
            case CHROME :
                driver =  new ChromeDriver();
                break;
            case EDGE :
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------- PASSED -------------");
        } catch (Throwable e) {
            status = false;
            log.info("---------- FAILED -------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalContants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected void assertTrue (boolean condition){
        Assert.assertTrue(verifyTrue(condition));
    }

    protected int generateRandomNumber(){
        return new Random().nextInt(99999);
    }


}
