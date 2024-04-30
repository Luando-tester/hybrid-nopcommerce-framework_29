package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Keyword {
    char c = 'a';

    byte bNumber = 10;
    short sNumber = 100;

    int iNumber = 1000;

    long lNumber = 10000;

    float fNumber = 15.7f;

    double dNumber = 45.88d;

    boolean bStatus = true;

    String fullName = "Automation Test";

    void clickTologinButton() {

    }

    String getLoginMessage() {
        return "";
    }

    public String address="145 Hoàng Cầu - Long Biên - Hà Nội";

    protected String city = "TP.Hồ Chí Minh";

    private String phone = "085562563";

    String zipCode = "650000";

    WebDriver driver;

    public WebDriver getBrowserDriver(String browserName){
        if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }

        for(int i = 0; i < 10 ; i++ ){
            System.out.println(i);
        }

        switch (browserName){
            case "firefox":
                driver = new FirefoxDriver();
            case "chrome":
                driver = new ChromeDriver();
            default:
                driver = new EdgeDriver();
        }
        return driver;
    }
}

