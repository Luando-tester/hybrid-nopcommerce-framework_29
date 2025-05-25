package browserFactory;

import commons.GlobalContants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEBrowserManager implements BrowserFactory {
    @Override
    public WebDriver getDriver() {
        if(!GlobalContants.OS_NAME.contains("Windows")){
            throw new BrowserNotSupportException("Internet Explore is not supported on " + GlobalContants.OS_NAME);
        }
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.destructivelyEnsureCleanSession();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        return new InternetExplorerDriver(ieOptions);
    }
}
