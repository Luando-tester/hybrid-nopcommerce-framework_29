package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_11_DataTable extends BaseTest {


    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {

        driver = getBroswerDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void Table_01() {
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActived("15"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActived("5"));

        homePage.openPageByNumber("12");
        Assert.assertTrue(homePage.isPageNumberActived("12"));
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void Table_02(){
        homePage.enterToTextboxHeaderName("Country","Algeria");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("283821","Algeria","295140","578961"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxHeaderName("Males","12599691");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("12253515","AFRICA","12599691","24853148"));
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxHeaderName("Females","764956");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("764956","Arab Rep of Egypt","802948","1567904"));
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void Table_03() {

        homePage.enterToTextboxHeaderName("Country","Afghanistan");
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxHeaderName("Country","Arab Rep of Egypt");
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("Arab Rep of Egypt");
        homePage.refreshCurrentPage(driver);


        homePage.enterToTextboxHeaderName("Country","Arab Rep of Egypt");
        homePage.sleepInSeconds(3);
        homePage.editRowByCountryName("Arab Rep of Egypt");
        homePage.refreshCurrentPage(driver);

    }
    @Test
    public void Table_04() {
        homePage.getAllValueAtColumnName("Country");

        homePage.getAllValueAtColumnName("Females");
    }
    @Test
    public void Table_05() {
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickToLoadDataButton();
        homePage.sleepInSeconds(3);

        homePage.enterToTexboxByIndex("4","Contact Person","Michael Jackson");
        homePage.sleepInSeconds(3);

        homePage.enterToTexboxByIndex("2","Company","MJ Company");
        homePage.sleepInSeconds(3);

        homePage.enterToTexboxByIndex("2","Order Placed","881");
        homePage.sleepInSeconds(3);

        homePage.selectToDropDownByIndex("6","Country","Hong Kong");

        homePage.selectToDropDownByIndex("8","Country","United Kingdom");

        homePage.checkToCheckboxByIndex("6","NPO?",true);

        homePage.checkToCheckboxByIndex("5","NPO?",false);

        homePage.clickToIconByIndex("8","Move Up");

        homePage.clickToIconByIndex("6","Remove");

        homePage.clickToIconByIndex("4","Insert");

    }




    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    private WebDriver driver;
    public HomePO homePage;

}
