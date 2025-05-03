package com.nopcommerce.user;

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
import commons.BasePage;

public class Level_02_BasePage_II_static_method {
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
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.waitForElementClickable(driver,"//input[@id='gender-male']");
        basePage.clickToElement(driver,"//input[@id='gender-male']");
        basePage.sendKeyToElement(driver,"//input[@id='FirstName']","Thomas");
        basePage.sendKeyToElement(driver,"//input[@id='LastName']","Miller");
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']","10");
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']","August");
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']","1986");
        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Company']",companyName);
        basePage.sendKeyToElement(driver,"//input[@id='Password']",password);
        basePage.sendKeyToElement(driver,"//input[@id='ConfirmPassword']",password);
        basePage.clickToElement(driver,"//button[@id='register-button']");


        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");
    }

    @Test
    public void TC_02_Login(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-login']");
        basePage.clickToElement(driver,"//a[@class='ico-login']");

        basePage.sendKeyToElement(driver,"//input[@id='Email']",emailAddress);
        basePage.sendKeyToElement(driver,"//input[@id='Password']",password);
        basePage.clickToElement(driver,"//button[@class='button-1 login-button']");


        Assert.assertTrue(basePage.isElementDisplayed(driver,"//a[@class='ico-account' and text()='My account']"));

    }

    @Test
    public void TC_03_MyAccount(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");
        Assert.assertTrue(basePage.isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='FirstName']","value"),"Thomas");

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),"Thomas");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),"Miller");

        Assert.assertEquals(basePage.getSelectItemInDropDown(driver,"//select[@name='DateOfBirthDay']"),"10");
        Assert.assertEquals(basePage.getSelectItemInDropDown(driver,"//select[@name='DateOfBirthMonth']"),"August");
        Assert.assertEquals(basePage.getSelectItemInDropDown(driver,"//select[@name='DateOfBirthYear']"),"1986");
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Company']","value"),"Bayer Munich");

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    private int generateRandomNumber(){
        return new Random().nextInt(99999);
    }
}
