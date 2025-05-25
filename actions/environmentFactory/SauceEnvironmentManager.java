package environmentFactory;

import commons.GlobalContants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class SauceEnvironmentManager  implements  EnvironmentFactory {
    private WebDriver driver;
    private String platformName, browserName, browserVersion;

    public SauceEnvironmentManager(String platformName, String browserName, String browserVersion) {
        this.platformName = platformName;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }

    @Override
    public WebDriver createDriver() {
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
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
