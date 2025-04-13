package com.nopcommerce.uses;


import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvironmentConfig;

import java.util.Random;

public class Level_28_Cloud_Bitbar extends BaseTest {
    WebDriver driver;
    Select select;
    String firstName, lastName, email, companyName, password;
    EnvironmentConfig environmentConfig;
    @Parameters({ "environment", "osName", "osVersion", "browserName", "browserVersion" })
    @BeforeClass
    public void beforeClass(String environment,String platformNmae, String browserName, String browserVer) {
        ConfigFactory.setProperty("environment",environment);
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        driver = getBroswerDriverSauceLab(environmentConfig.getAppUrl(),platformNmae,browserName,browserVer);
        driver.get("https://demo.nopcommerce.com/");
        sleepInSecond(2);

        System.out.println(environmentConfig.getAppUrl());
        System.out.println(environmentConfig.getAppUsername());
        System.out.println(environmentConfig.getAppPassword());
        ConfigFactory.getProperty("App.url");
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.className("ico-register")).click();
        sleepInSecond(2);

        driver.findElement(By.id("gender-male")).click();
        sleepInSecond(2);

        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        select = new Select(driver.findElement(By.name("DateOfBirthDay")));
        select.selectByVisibleText("10");

        select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        select.selectByVisibleText("August");

        select = new Select(driver.findElement(By.name("DateOfBirthYear")));
        select.selectByVisibleText("1960");

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.id("register-button")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page registration-result-page']//div[@class='result']")).getText(), "Your registration completed");

        driver.findElement(By.className("ico-logout")).click();
        sleepInSecond(2);
    }

    @Test
    public void TC_02_Login() {
        driver.findElement(By.className("ico-login")).click();
        sleepInSecond(2);

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector(".login-button")).click();
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(By.className("ico-account")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed());
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
