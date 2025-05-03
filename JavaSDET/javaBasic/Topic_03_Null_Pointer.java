package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_03_Null_Pointer {
    WebDriver driver;

    WebDriverWait explicitWait;
    @Test
    public void testNullPointer(){
        driver =  new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com/");

         explicitWait.until(ExpectedConditions.urlContains("demo.nopcommerce.com"));

        driver.quit();
    }

}
