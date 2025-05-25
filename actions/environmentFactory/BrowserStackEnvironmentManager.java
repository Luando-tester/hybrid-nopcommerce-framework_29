package environmentFactory;

import commons.BrowserList;
import commons.GlobalContants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BrowserStackEnvironmentManager implements EnvironmentFactory{
    private WebDriver driver;
    private String  osName, osVersion,browserName, browserVersion;

    public BrowserStackEnvironmentManager(String osName, String osVersion, String browserName, String browserVersion) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.browserName = browserName;
        this.browserVersion = browserVersion;
    }


    @Override
    public WebDriver createDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String,Object> bstackOptions = new HashMap<String,Object>();
        capabilities.setCapability("browserName","Chrome");
        bstackOptions.put("os",osName);
        bstackOptions.put("osVersion",osVersion);
        bstackOptions.put("browserVersion",browserVersion);
        bstackOptions.put("userName", GlobalContants.BROWSER_USERNAME);
        bstackOptions.put("accessKey",GlobalContants.BROWSER_AUTOMATE_KEY);

//        bstackOptions.put("consoleLogs","info");
        bstackOptions.put("seleniumVersion","4.29.0");
        capabilities.setCapability("bstack:options",bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalContants.BROWSER_STACK_URL),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  driver;
    }
}

