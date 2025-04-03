package pageObjects.saucelabs;

import commons.BasePage;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.SequenceOfUint8;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelabs.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryPageObject extends BasePage {
    private WebDriver driver;
    public InventoryPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void selectSortDropdown(String sortItem){
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemInDropdown(driver,InventoryPageUI.SORT_DROPDOWN,sortItem);
    }

    public boolean isNameSortAscending() {
        List<WebElement> productNameElement = getListElement(driver,InventoryPageUI.PRODUCT_NAME);
        List<String> productNameText = productNameElement.stream().map( n -> n.getText()).collect(Collectors.toList());
        List<String> productNameTextClone = new ArrayList<>(productNameText);
        Collections.sort(productNameTextClone);

        return productNameTextClone.equals(productNameText);
    }
    public boolean isDataSortedAsc(WebDriver driver,String locator){
        var elementLists = driver.findElements(By.xpath(locator));
        var names = elementLists.stream().map(WebElement::getText).toList();
        var sortedNames = names.stream().sorted().toList();
        return names.equals(sortedNames);
    }
    public boolean isNameSortDescending() {
        List<WebElement> productNameElement = getListElement(driver,InventoryPageUI.PRODUCT_NAME);
        List<String> productNameText = new ArrayList<String>();
        for(WebElement productName: productNameElement){
            productNameText.add(productName.getText());
        }
        List<String> productNameTextClone = new ArrayList<>(productNameText);
        Collections.sort(productNameTextClone);
        Collections.reverse(productNameTextClone);

        return productNameTextClone.equals(productNameText);
    }
    public boolean isPriceSortAscending() {
        List<WebElement> productPriceElement = getListElement(driver,InventoryPageUI.PRODUCT_NAME);
        List<Float> productPriceText = new ArrayList<Float>();

        System.out.println("Trước khi Sort");
        for(WebElement productName: productPriceElement){
            System.out.println(productName.getText());
            productPriceText.add(Float.valueOf(productName.getText().replace("$","")));
        }
        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);
        Collections.sort(productPriceTextClone);
        System.out.println("Sau khi SORTS");
        for (Float price: productPriceTextClone){
            System.out.println(price);
        }
        return productPriceTextClone.equals(productPriceText);
    }
    public boolean isPriceSortDescending() {
        List<WebElement> productPriceElement = getListElement(driver,InventoryPageUI.PRODUCT_NAME);
        List<Float> productPriceText = new ArrayList<Float>();

        System.out.println("Trước khi Sort");
        for(WebElement productName: productPriceElement){
            System.out.println(productName.getText());
            productPriceText.add(Float.valueOf(productName.getText().replace("$","")));
        }
        List<Float> productPriceTextClone = new ArrayList<Float>(productPriceText);
        Collections.sort(productPriceTextClone);
        Collections.reverse(productPriceTextClone);
        System.out.println("Sau khi SORTS");
        for (Float price: productPriceTextClone){
            System.out.println(price);
        }
        return productPriceTextClone.equals(productPriceText);
    }
}
