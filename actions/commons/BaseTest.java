package commons;

import com.google.common.util.concurrent.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Provider;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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
        Path path = null;
        File extensionFilePath =  null;
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX :
//                FirefoxOptions fOptions = new FirefoxOptions();
//                fOptions.addPreference("geo.enabled",false);
//                fOptions.addPreference("geo.provider.use_corelocation",false);
//                driver = new FirefoxDriver(fOptions);
//                System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,GlobalContants.BROWSER_LOG_PATH + "FirefoxPropertyLog.log");
//                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogLevel(FirefoxDriverLogLevel.DEBUG).build();
//                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogOutput(System.out).build();
//                FirefoxDriverService ffService  = new GeckoDriverService.Builder().withLogFile(new File(GlobalContants.BROWSER_LOG_PATH + "FirefoxLog.log")).build();
//                driver = new FirefoxDriver();
//                Path xpiPath = Paths.get(GlobalContants.BROWSER_EXTENSION_PATH + "wappalyzer.xpi");
//                FirefoxDriver ffDriver = (FirefoxDriver) driver;
//                ffDriver.installExtension(xpiPath);
//                driver = ffDriver;
//                driver = new FirefoxDriver(ffService);
                FirefoxOptions fOptions = new FirefoxOptions();
//                fOptions.addArguments("-private");
//                driver =  new FirefoxDriver(fOptions);

//                DesiredCapabilities caps = new DesiredCapabilities();
//                FirefoxOptions optionss = new FirefoxOptions();
//                optionss.addArguments("-private");
//                caps.setCapability("moz:firefoxOptions",optionss);
                FirefoxProfile fffProfile = new FirefoxProfile();

                fffProfile.setPreference("browser.private.browsing.autostart",true);
                fffProfile.setPreference("browser.privatebrowsing.autostart",true);
                fffProfile.setAssumeUntrustedCertificateIssuer(false);
                fffProfile.setAcceptUntrustedCertificates(true);
                fOptions.setProfile(fffProfile);
                fOptions.addArguments("-private");
                driver =  new FirefoxDriver(fOptions);
                Dimension dimension = new Dimension(1920,1080);
                driver.manage().window().setSize(dimension);
                break;
            case HFIREFOX :
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-headless");
                options.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(options);
                break;
            case CHROME :
//                Map<String,Object> prefs =  new HashMap<String, Object>();
//                prefs.put("profile.default_content_setting_values.notfications",2);
//                prefs.put("credentials_enable_service",false);
//                prefs.put("profile.password_manager_enabled",false);
//                prefs.put("autonfill.profile_enabled",false);

//                ChromeOptions optionss =  new ChromeOptions();
//                optionss.setExperimentalOption("prefs",prefs);
//                optionss.addArguments("--disable-notifications");
//                driver = new ChromeDriver(optionss);
//                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,GlobalContants.BROWSER_LOG_PATH + "ChromePropertyLog.log");
//                ChromeDriverService cService = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();
//                ChromeDriverService cService = new ChromeDriverService.Builder().withLogOutput(System.out).build();
//                ChromeDriverService cService  = new ChromeDriverService.Builder().withLogFile(new File(GlobalContants.BROWSER_LOG_PATH + "ChromeLog.log")).build();
//                ChromeOptions cOptions = new ChromeOptions();
//                path = Paths.get(GlobalContants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
//                extensionFilePath = new File(path.toUri());
//                cOptions.addExtensions(extensionFilePath);
//                driver = new ChromeDriver(cService);
                ChromeOptions chromeOptionss =  new ChromeOptions();
                chromeOptionss.addArguments("--user-data-dir=C:\\Users\\THANH.LUAN\\AppData\\Local\\Google\\Chrome\\User Data\\");
                chromeOptionss.addArguments("--profile-directory=Profile 10");
                driver = new ChromeDriver(chromeOptionss);
                break;
            case HCHROME :
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("-headless");
                chromeOptions.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(chromeOptions);
                break;
            case COCCOC:
                ChromeOptions ccOptions = new ChromeOptions();
                ccOptions.setBinary("C:\\ProgarmFiles\\CocCoc\\Browser\\Application\\browser.exe");
                driver = new ChromeDriver(ccOptions);
            case EDGE :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                driver = new EdgeDriver(edgeOptions);
//                EdgeOptions edgeOptionss =  new EdgeOptions();
//                edgeOptionss.addArguments("--disable-notifications");
//                driver = new EdgeDriver(edgeOptionss);
//                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,GlobalContants.BROWSER_LOG_PATH + "ChromePropertyLog.log");
//                EdgeDriverService edgeService = new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();
//                EdgeDriverService edgeService = new EdgeDriverService.Builder().withLogOutput(System.out).build();
//                EdgeDriverService ieService  = new EdgeDriverService.Builder().withLogFile(new File(GlobalContants.BROWSER_LOG_PATH + "EdgeLog.log")).build();
//                EdgeOptions edgeOptions = new EdgeOptions();
//                path = Paths.get(GlobalContants.BROWSER_EXTENSION_PATH + "Wappalyzer.crx");
//                extensionFilePath = new File(path.toUri());
//                edgeOptions.addExtensions(extensionFilePath);
//                driver = new EdgeDriver(edgeService);
                break;
            case HEDGE :
                EdgeOptions egOptions = new EdgeOptions();
                egOptions.addArguments("-headless");
                egOptions.addArguments("window-size=1920x1080");
                driver = new EdgeDriver(egOptions);
                break;
            case IE:
//                DesiredCapabilities capabilities =  new DesiredCapabilities();
//                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
//                capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR,true);
//                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
//                capabilities.setCapability("ignoreProtectModeSettings",true);
//                capabilities.setCapability("ignioreZoomSettings",true);
//                capabilities.setCapability("requireWindowFocus",true);
//                capabilities.setJavascriptEnable(true);
//                capabilities.setCapability("enableElementCacheCleanup",true);
//                capabilities.setBrowserName("internet explorer");
//                capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
//                driver = new InternetExplorerDriver(capabilities);
//                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//                driver = new InternetExplorerDriver(ieOptions);
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.destructivelyEnsureCleanSession();
                ieOptions.ignoreZoomSettings();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                driver = new InternetExplorerDriver(ieOptions);
                break;
            case SAFARI:
                SafariOptions sOptions = new SafariOptions();
                driver = new SafariDriver(sOptions);
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
