package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By productQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(" .alert-success");
    /*********************************selectores proyecto***************************************************/
    public By searchInputLocator = By.name("search");
    public By ProductFound = By.xpath("//*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a");


    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isTitleDisplayed(String name ){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>",name))).isDisplayed();
    }

    public void setQuantity(int quantity){
        driver.findElement(productQuantityInputSelector).clear();
        driver.findElement(productQuantityInputSelector).sendKeys(" " + quantity);

    }
    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public void clickNameProduct(){driver.findElement(ProductFound).click();
    }
    public void fillSearch(String searchCriteria) {
        driver.findElement(searchInputLocator).sendKeys(searchCriteria, Keys.ENTER);
    }






}
