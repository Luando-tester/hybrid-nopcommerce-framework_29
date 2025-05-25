package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeHeadlessBrowserManager implements BrowserFactory{
    @Override
    public WebDriver getDriver() {
        EdgeOptions ehOptions = new EdgeOptions();
        ehOptions.addArguments("-headless");
        ehOptions.addArguments("window-size=1920x1080");
        return new EdgeDriver(ehOptions);
    }
}
