package environmentFactory;

import browserFactory.*;
import commons.BrowserList;
import commons.GlobalContants;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LocalEnvironmentManager implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName;

    public LocalEnvironmentManager(String browserName){
        this.browserName = browserName;
    }

    @Override
    public WebDriver createDriver() {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxBrowserManager().getDriver();
                break;
            case HFIREFOX:
                driver = new FireFoxHeadlessBrowserManager().getDriver();
                break;
            case CHROME:
                driver = new ChromeBrowserManager().getDriver();
                break;
            case HCHROME:
                driver = new ChromeHeadlessBrowserManager().getDriver();
                break;
            case COCCOC:
                driver = new CocCocBrowserManager().getDriver();
            case EDGE:
                driver = new EdgeBrowserManager().getDriver();
                break;
            case HEDGE:
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
        return  driver;
    }
}

