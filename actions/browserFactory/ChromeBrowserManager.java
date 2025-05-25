package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowserManager implements  BrowserFactory{
    @Override
    public WebDriver getDriver(){
        ChromeOptions chromeOptionss =  new ChromeOptions();
        chromeOptionss.addArguments("--user-data-dir=C:\\Users\\THANH.LUAN\\AppData\\Local\\Google\\Chrome\\User Data\\");
        chromeOptionss.addArguments("--profile-directory=Profile 10");
        return  new ChromeDriver(chromeOptionss);
    }
}
