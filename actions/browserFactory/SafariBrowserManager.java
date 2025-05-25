package browserFactory;

import commons.GlobalContants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariBrowserManager implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        if(!GlobalContants.OS_NAME.toUpperCase().startsWith("MAC")){
            throw new BrowserNotSupportException("Safari is not supported on " + GlobalContants.OS_NAME);
        }
        SafariOptions sOptions = new SafariOptions();
        return new SafariDriver(sOptions);
    }
}
