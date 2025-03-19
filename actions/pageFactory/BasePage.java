package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    JavascriptExecutor jsExecutor;
//    public BasePage (WebDriver driver){
//        this.driver =  driver;
//    }

    public static commons.BasePage getBasePage(){
        return new commons.BasePage();
    }

    public void clickToElement(WebElement element){
        element.click();
    }

    public void sendKeyToElement(WebElement element,String keyToSend){
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void selectItemInDropdown(WebElement element,String textItem){
        new Select(element).selectByVisibleText(textItem);
    }

    public String getSelectItemInDropDown(WebElement element){
        return new Select(element).getFirstSelectedOption().getText();
    }
    public String getElementText(WebElement element){
        return element.getText();
    }


    public void checkToCheckboxRadio(WebElement element){
        if(!element.isSelected()){
            element.click();
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }


    public boolean isElementSelected(WebElement element){
        return element.isSelected();
    }

    public void waitForElementVisible(WebDriver driver,WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    public String getElementAttribute(WebElement element,String attributeName){
        return element.getAttribute(attributeName);
    }

    public void waitForElementSelect(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForElementInvisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitForElementPresence(WebElement element,String text){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.textToBePresentInElement(element,text));
    }





    public String fullName;

    public String getFullName(){
        String fullName = null;
        for(int i = 0; i < 10; i++){
            int n = 1;
            if(n > 0){
                int x = 10;
            }
        }
        return this.fullName;
    }
}
