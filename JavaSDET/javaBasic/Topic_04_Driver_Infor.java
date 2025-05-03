package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class Topic_04_Driver_Infor {
    public  static void main(String args){
        WebDriver driver = new FirefoxDriver();

        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        System.out.println("Session ID = " + sessionId);
        System.out.println("Driver ID = " + driver.toString());
        System.out.println(System.getProperty("java.version"));
        driver.quit();
    }
}
