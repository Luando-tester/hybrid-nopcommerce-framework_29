package commons;

import browserFactory.*;
import com.google.common.util.concurrent.Service;
import environmentFactory.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Provider;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;


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
        Path path = null;
        File extensionFilePath =  null;
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxBrowserManager().getDriver();
                break;
            case HFIREFOX :
                driver = new FireFoxHeadlessBrowserManager().getDriver();
                break;
            case CHROME :
                driver = new ChromeBrowserManager().getDriver();
                break;
            case HCHROME :
                driver = new ChromeHeadlessBrowserManager().getDriver();
                break;
            case COCCOC:
                driver = new CocCocBrowserManager().getDriver();
            case EDGE :
                driver = new EdgeBrowserManager().getDriver();
                break;
            case HEDGE :
                driver = new EdgeHeadlessBrowserManager().getDriver();
                break;
            case IE:
                driver = new IEBrowserManager().getDriver();
                break;
            case SAFARI:
                driver = new SafariBrowserManager().getDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBroswerDriverGrid(String browserName,String url,String osName,String ipAddress,String portName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

        Capabilities capabilities = null;
        switch (browserList){
            case FIREFOX :
                capabilities = new FirefoxOptions();
                break;
            case CHROME :
                capabilities = new ChromeOptions();
                break;
            case EDGE :
                capabilities = new EdgeOptions();
                break;
            case SAFARI:
                capabilities = new SafariOptions();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/",ipAddress,portName)),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBroswerDriver(String browserName,String url,String osName,String ipAddress,String portName){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        Capabilities capabilities =  null;
        Platform platform = null;
        if(osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }
        switch (browserName){
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PLATFORM_NAME,platform);
                capabilities = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setCapability(CapabilityType.PLATFORM_NAME,platform);
                capabilities = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setCapability(CapabilityType.PLATFORM_NAME,platform);
                capabilities = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME,platform);
                capabilities = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid");
        }
        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/",ipAddress,portName)),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBroswerDriverBrowserStack(String url,String osName,String osVersion,String browserName,String browserVersion){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String,Object> bstackOptions = new HashMap<String,Object>();
        capabilities.setCapability("browserName","Chrome");
        bstackOptions.put("os",osName);
        bstackOptions.put("osVersion",osVersion);
        bstackOptions.put("browserVersion",browserVersion);
        bstackOptions.put("userName",GlobalContants.BROWSER_USERNAME);
        bstackOptions.put("accessKey",GlobalContants.BROWSER_AUTOMATE_KEY);

//        bstackOptions.put("consoleLogs","info");
        bstackOptions.put("seleniumVersion","4.29.0");
        capabilities.setCapability("bstack:options",bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalContants.BROWSER_STACK_URL),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBroswerDriverSauceLab(String url,String platformName,String browserName,String browserVersion){
        MutableCapabilities capability = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(platformName);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(platformName);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(platformName);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(platformName);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, String> sauceOptions = new HashMap<String, String>();
        sauceOptions.put("username", GlobalContants.SAUCE_USERNAME);
        sauceOptions.put("accessKey", GlobalContants.SAUCE_AUTOMATE_KEY);
        sauceOptions.put("build", "automation-fc-build");
        sauceOptions.put("name", "Run on " + platformName + " | " + browserName + " | " + browserVersion);

        capability.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalContants.SAUCE_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBroswerDriverLambdaTets(String url,String platformName,String browserName,String browserVersion){
        MutableCapabilities capability = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(platformName);
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(platformName);
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(platformName);
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(platformName);
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        HashMap<String, Object> LambdaOption = new HashMap<String, Object>();
        LambdaOption.put("username", GlobalContants.LAMBDA_USERNAME);
        LambdaOption.put("accessKey", GlobalContants.LAMBDA_AUTOMATE_KEY);
        LambdaOption.put("build", "automation-fc-build");
        LambdaOption.put("project", "NopCommerce Automation UI Test");
        LambdaOption.put("name", "Run on " + platformName + " | " + browserName + " | " + browserVersion);

        capability.setCapability("LT:options", LambdaOption);

        try {
            driver = new RemoteWebDriver(new URL(GlobalContants.LAMBDA_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBroswerDriveDeviceFarm(String url,String platform,String browserName,String browserVersion){
        MutableCapabilities capability = null;

        switch (browserName.toLowerCase()) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(platform.toLowerCase());
                fOptions.setBrowserVersion(browserVersion);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(platform.toLowerCase());
                cOptions.setBrowserVersion(browserVersion);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(platform.toLowerCase());
                eOptions.setBrowserVersion(browserVersion);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(platform.toLowerCase());
                sOptions.setBrowserVersion(browserVersion);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.US_WEST_2).build();

        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder().expiresInSeconds(300).projectArn(GlobalContants.AWS_DEVICE_FARM_ARN).build();
        URL tesGridUrl = null;
        try {
            CreateTestGridUrlResponse response = client.createTestGridUrl(request);
            tesGridUrl = new URL(response.url());
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(tesGridUrl,capability);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return  driver;
    }
    protected WebDriver getBroswerDriverBitbar(String url,String platformName,String platformVersion,String browserName,String browserVersion){
        MutableCapabilities capability = null;
        HashMap<String,String> bitbarOptions = new HashMap<String,String>();
        capability.setCapability("browserName",browserName);
        capability.setCapability("browserName",browserName);
        capability.setCapability("browserVersion",browserVersion);

        bitbarOptions.put("project","NopCommerce");
        bitbarOptions.put("apiKey",GlobalContants.BITBAR_AUTOMATE_KEY);
        bitbarOptions.put("osVersion",platformVersion);
        bitbarOptions.put("resolution","1920x1000");
        bitbarOptions.put("seleniumVersion","4");

        capability.setCapability("bitbar:options",bitbarOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalContants.BITBAR_EU_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    protected WebDriver getBrowserDriver(String environmentName,String url,String osName,String osVersion,String browserName,String browserVersion,String ipAddress,String portNumber){
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        EnvironemtnList environemtnList = EnvironemtnList.valueOf(environmentName.toUpperCase());

        switch (environemtnList){
            case LOCAL:
                driver = new LocalEnvironmentManager(browserName).createDriver();
                break;
            case GRID:
                driver =new GridEnvironmentManager(browserName,osName,ipAddress,portNumber).createDriver();
                break;
            case BROWSERSTACK:
                driver = new BrowserStackEnvironmentManager(osName,osVersion,browserName,browserVersion).createDriver();
                break;
            case SAUCELAB:
                driver = new SauceEnvironmentManager(osName,browserName,browserVersion).createDriver();
                break;
            case BITBAR:
                driver = new B(environmentName).createDriver();
            case LAMBDA:
                driver = new LocalEnvironmentManager(environmentName).createDriver();
                break;
            case DEVICEFARM:
                driver = new LocalEnvironmentManager(environmentName).createDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalContants.LONG_TIMEOUT));
        return  driver;
    }
    private String getUrlEnvironmentName(String environmentName){
        String url;
        switch (environmentName){
            case "dev":
                url = "https://demo.nopcommerce.com/";
                break;
            case "testing":
                url = "https://testing.nopcommerce.com";
                break;
            case "staging":
                url = "https://staging.nopcommerce.com";
                break;
            default:
                throw new RuntimeException("Environment name is not valid.");
        }
        return  url;
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
    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
