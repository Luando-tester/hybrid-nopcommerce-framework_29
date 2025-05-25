package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxHeadlessBrowserManager implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        FirefoxOptions hfOption = new FirefoxOptions();
        hfOption.addArguments("-headless");
        hfOption.addArguments("window-size=1920x1080");
        return new FirefoxDriver(hfOption);
    }
}
