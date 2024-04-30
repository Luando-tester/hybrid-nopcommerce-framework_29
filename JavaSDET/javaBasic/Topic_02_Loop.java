package javaBasic;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_02_Loop {

    public  static final String PI = "3.141867687";

    public final void clickToElement(){

    }
    public static void clickToButton(){

    }

    public static void main (String[] args) {
        Topic_02_Loop topic02 = new Topic_02_Loop();
        topic02.clickToElement();
        Topic_02_Loop.clickToButton();
        System.out.println(Topic_02_Loop.PI);
        for (int i = 1; i <= 10; i++) {
            if(i < 5){
                System.out.println(i);
                break;
            }
        }
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("While:");
        i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 1);
    }
    public boolean isElementDisplayed(){
        WebDriver driver = new FirefoxDriver();
        WebElement element = driver.findElement(By.cssSelector(""));
        boolean status = false;
        try{
            element.isDisplayed();
        }catch (NoSuchElementException exception){
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage());
        }finally {

        }
        return status;
    }
}
