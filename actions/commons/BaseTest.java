package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected WebDriver driver;
    private String projectPath = System.getProperty("user.dir");
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

        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
    protected int generateRandomNumber(){
        return new Random().nextInt(99999);
    }
}
