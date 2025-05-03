package com.nopcommerce.uses;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_init {
    WebDriver driver;
    BasePage basePage;


    private String firstname,lastName,day,month,year,emailAddress,companyName,password;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage =  BasePage.getBasePage();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        basePage = BasePage.getBasePage();
        firstname="Thomas";
        lastName="Miller";
        day="10";
        month="August";
        year="1986";
        emailAddress="ThomasMiller"+ generateRandomNumber() +"@gmail.de";
        companyName="Bayer Munich";
        password="123456";
    }

    @Test
    public void TC_01_Register(){
      driver.findElement(By.xpath("//a[@class='ico-register']")).click();
      driver.findElement(By.xpath("//input[@id='gender-male']")).click();
      driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Thomas");
      driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Miller");
      driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("10");
      driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("August");
      driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1986");
      driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
      driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);
      driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
      driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(password);
      driver.findElement(By.xpath("//button[@id='register-button']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");
    }

    @Test
    public void TC_02_Login(){
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text()='My account']")).isDisplayed());

    }

    @Test
    public void TC_03_MyAccount(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");;

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected());
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),"Thomas");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),"Miller");

        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"))).getFirstSelectedOption().getText(),"10");
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"))).getFirstSelectedOption().getText(),"August");
        Assert.assertEquals(new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"))).getFirstSelectedOption().getText(),"1986");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"),"Bayer Munich");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    private int generateRandomNumber(){
        return new Random().nextInt(99999);
    }
}
