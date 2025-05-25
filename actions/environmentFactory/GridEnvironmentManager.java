package environmentFactory;

import commons.BrowserList;
import commons.GlobalContants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridEnvironmentManager implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName,osName,ipAddress,portNumber;

    public GridEnvironmentManager(String browserName, String osName, String ipAddress, String portNumber) {
        this.browserName = browserName;
        this.osName = osName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    @Override
    public WebDriver createDriver() {

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
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/",ipAddress,portNumber)),capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            return  driver;
    }
}
