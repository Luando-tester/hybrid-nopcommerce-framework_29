package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageObjects.users.UserAddressPO;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserOrderPO;
import pageObjects.users.UserRewardPointPO;
import pageUIs.BasePageUI;
import pageUIs.users.UserSidebarPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;

    JavascriptExecutor jsExecutor;
//    public BasePage (WebDriver driver){
//        this.driver =  driver;
//    }

    public static BasePage getBasePage(){
        return new BasePage();
    }

    public By getByXpath (String locator){
        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver){
        driver.findElement(By.cssSelector("")).click();
    }

    public void getElementText(WebDriver driver){
        driver.findElement(By.cssSelector("")).getText();
    }
    public void sendKeyToElement(String valueToSendkey){
        driver.findElement(By.cssSelector("")).sendKeys(valueToSendkey);
    }

    public void openPageUrl(WebDriver driver,String url) {
        driver.get(url);
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getPageURL(WebDriver driver){
        return driver.getCurrentUrl();
    }



    public void waitAlertPresence(WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public void acceptToAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public void cancelToAlert(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }
    public void getAlertText(WebDriver driver){
        driver.switchTo().alert().getText();
    }

    public void sendKeyToAlert(WebDriver driver,String keyToSend){
        driver.switchTo().alert().sendKeys(keyToSend);
    }
    public void switchToWindowByID(WebDriver driver,String parentID){
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindow : allWindows){
            driver.switchTo().window(runWindow);
            break;
        }
    }
    public void switchToWindowByTitle(WebDriver driver,String title){
        Set<String> allWindows =  driver.getWindowHandles();
        for(String runWindows : allWindows){
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if(currentWin.equals(title)){
                break;
            }
        }

    }
    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID){
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindows : allWindows){
            if(!runWindows.equals(parentID)){
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }



    public void clickToElement(WebDriver driver,String locator){
        getElement(driver,locator).click();
    }

    public void clickToElement(WebDriver driver,String locator,String... restParameter){
        getElement(driver,castParameter(locator,restParameter)).click();
    }



    public void clickToElement(WebDriver driver,String locator,String value){
        getElement(driver,castParameter(locator,value)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator,String keyToSend){
        getElement(driver,locator).clear();
        getElement(driver,locator).sendKeys(keyToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator,String keyToSend,String... restParameter){
        getElement(driver,castParameter(locator,restParameter)).clear();
        getElement(driver,castParameter(locator,restParameter)).sendKeys(keyToSend);
    }

    public void selectItemInDropdown(WebDriver driver,String locator,String textItem){
        new Select(driver.findElement(getByLocator(locator))).selectByVisibleText(textItem);
    }

    public void selectItemInDropdown(WebDriver driver,String locator,String textItem,String... restParameter){
        new Select(driver.findElement(getByLocator(castParameter(locator,restParameter)))).selectByVisibleText(textItem);
    }

    public String getSelectItemInDropDown(WebDriver driver,String locator){
        return new Select(getElement(driver,locator)).getFirstSelectedOption().getText();
    }

    public void isDropDownMultiple(WebDriver driver,String locator){
        new Select(driver.findElement(By.xpath(locator))).isMultiple();
    }
    protected List<WebElement> getListElement(WebDriver driver,String locator){
       return driver.findElements(getByLocator(locator));
    }

    protected List<WebElement> getListElement(WebDriver driver,String locator,String... restParameter){
        return driver.findElements(getByLocator(castParameter(locator,restParameter)));
    }
    public void sendKeyToElement1(WebDriver driver,String locator,String keyToSend){
        getElement(driver,locator).clear();
        getElement(driver,locator).sendKeys(keyToSend);
    }

    private WebElement getElement(WebDriver driver,String locator) {
        return driver.findElement(getByLocator(locator));
    }

    private String castParameter(String locator,String... restParameter){
        return String.format(locator,(Object[]) restParameter);
    }

    protected By getByLocator(String prefixLocator){
       By by = null;
       if(prefixLocator.toUpperCase().startsWith("ID")){
           by = By.id(prefixLocator.substring(3));
       }else if (prefixLocator.toUpperCase().startsWith("CLASS")){
           by = By.className(prefixLocator.substring(6));
       }else if (prefixLocator.toUpperCase().startsWith("NAME")){
           by = By.name(prefixLocator.substring(5));
       }else if (prefixLocator.toUpperCase().startsWith("TAGNAME")){
           by = By.tagName(prefixLocator.substring(8));
       }else if (prefixLocator.toUpperCase().startsWith("CSS")){
           by = By.cssSelector(prefixLocator.substring(4));
       } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
           by = By.xpath(prefixLocator.substring(6));
       }else {
           throw new RuntimeException("Locator type is not support!!!!");
       }
       System.out.println(by);
       return by;
    }


    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        driver.findElement(By.xpath(parentLocator)).click();

        List<WebElement> allItems = new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }
    public void sleepInSeconds(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }

    public String getElementAttribute(WebDriver driver,String locator,String attributeName){
       return getElement(driver,locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver,String locator,String attributeName,String... restParameter){
        return getElement(driver,castParameter(locator,restParameter)).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver,String locator){
        return getElement(driver,locator).getText();
    }

    public String getElementText(WebDriver driver,String locator,String... restParameter){
        return getElement(driver,castParameter(locator,restParameter)).getText();
    }

    public String getElementCssValue(WebDriver driver,String locator,String propertyName){
        return getElement(driver,locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public void getListElementNumber(WebDriver driver,String locator){
        getListElement(driver,locator).size();
    }

    public void checkToCheckboxRadio(WebDriver driver,String locator){
        if(!getElement(driver, locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public void checkToCheckboxRadio(WebDriver driver,String locator,String... restParameter){
        if(!getElement(driver, castParameter(locator,restParameter)).isSelected()){
            getElement(driver,castParameter(locator,restParameter)).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver,String locator){
        if(getElement(driver, locator).isSelected()){
            getElement(driver,locator).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver,String locator,String... restParameter){
        if(getElement(driver, castParameter(locator,restParameter)).isSelected()){
            getElement(driver,castParameter(locator,restParameter)).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver,String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver,String locator,String... restParameter) {
        return getElement(driver, castParameter(locator,restParameter)).isDisplayed();
    }


    public boolean isElementEnabled(WebDriver driver,String locator){
        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver,String locator){
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected(WebDriver driver,String locator,String... restParameter){
        return getElement(driver, castParameter(locator,restParameter)).isSelected();
    }

    public void switchToFrame(WebDriver driver,String locator){
        driver.switchTo().frame(getElement(driver,locator));
    }

    public void switchToDefaultPage(){
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(WebDriver driver,String locator){
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void clickToElementByAction(WebDriver driver,String locator){
        new Actions(driver).click(getElement(driver,locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver,String locator){
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void rightClickToElement(WebDriver driver,String locator){
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver,String sourceLocator,String targetLocator){
        new Actions(driver).dragAndDrop(getElement(driver,sourceLocator),getElement(driver,targetLocator)).perform();
    }

    public void releaseLeftMouse(WebDriver driver){
        new Actions(driver).release();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver,locator),keys).perform();
    }

    public void pressKeyToElement(WebDriver driver, String locator, Keys keys,String... restParameter){
        new Actions(driver).sendKeys(getElement(driver,castParameter(locator,restParameter)),keys).perform();
    }



    public void doubleClickToElement(WebDriver driver,String locator){
        new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void scrollToElementOnDown(String locator){
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public Object executeForBrowser(String javaScript){
        return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(){
        return(String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected){
        String  textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('"+ textExpected+ "')[0];");
        return textActual.equals(textExpected);
    }
    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) jsExecutor.executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public void scrollToBottomPage(WebDriver driver){
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url){
        jsExecutor.executeScript("'window.location= '"+ url + "'");
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator,String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementSelect(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelect(WebDriver driver, String locator,String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementPresence(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator,String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator,String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParameter(locator,restParameter))));
    }

    public void uploadMultipleFiles(WebDriver driver,String... fileNames){
        String filePath = GlobalContants.UPLOAD_PATH;
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName += filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
       sendKeyToElement(driver,BasePageUI.UPLOAD_FILE_TYPE,fullFileName);
    }


    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator,String... restParameter){
        new WebDriverWait(driver, Duration.ofSeconds(GlobalContants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator,restParameter))));
    }

    public UserRewardPointPO openRewardPointPage(WebDriver driver){
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }
    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver){
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerInforPage(driver);
    }
    public UserAddressPO openAddressPage(WebDriver driver){
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
    public UserOrderPO openOrderPage(WebDriver driver){
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
    public void openAdminSite(WebDriver driver,String adminUrl){
       openPageUrl(driver,adminUrl);
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
