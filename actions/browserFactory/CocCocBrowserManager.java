package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCocBrowserManager implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        ChromeOptions ccOptions = new ChromeOptions();
        ccOptions.setBinary("C:\\ProgarmFiles\\CocCoc\\Browser\\Application\\browser.exe");
        return new ChromeDriver(ccOptions);
    }
}
