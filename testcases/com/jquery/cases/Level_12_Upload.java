package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_12_Upload extends BaseTest {
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {

        driver = getBroswerDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

        danang= "DaNang.jpg";
        hanoi= "HaNoi.jpg";
        hochiminh= "HoChiMinh.jpg";
    }
    @Test
    public void Upload_01() {
        homePage.uploadMultipleFiles(driver,danang);
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);


        homePage.uploadMultipleFiles(driver,danang,hanoi);
        homePage.sleepInSeconds(3);
        homePage.refreshCurrentPage(driver);

        homePage.uploadMultipleFiles(driver,danang,hanoi,hochiminh);
        homePage.sleepInSeconds(3);
//        homePage.refreshCurrentPage(driver);

        Assert.assertTrue(homePage.isFileLoadedByName(danang));
        Assert.assertTrue(homePage.isFileLoadedByName(hanoi));
        Assert.assertTrue(homePage.isFileLoadedByName(hochiminh));

        homePage.clickToUploadButton(driver);

        Assert.assertTrue(homePage.isFileUploadedByName(danang));
        Assert.assertTrue(homePage.isFileUploadedByName(hanoi));
        Assert.assertTrue(homePage.isFileUploadedByName(hochiminh));
    }


    @AfterClass
    public void afterClass(){
        //driver.quit();
    }

    private WebDriver driver;
    private HomePO homePage;
    private String danang,hanoi,hochiminh;
}
