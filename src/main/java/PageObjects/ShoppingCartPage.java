package PageObjects;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage {

    public String ProductNameLocator = "//div[@id='content']//a[text()='<name>']";
    public By ProductQuantityLocator = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input");
    public By shoppingCartInText = By.xpath("//*[@id='product-product']/div[1]/a[2]");
    public By productNotAvailable = By.xpath("//*[@id='checkout-cart']/div[1]");


    private String ProductRowLocator = "//div[@id='content']//tr[contains(.,'<name>')]";
    private By inputRowSelector = By.cssSelector("input");
    private By imageSelector = By.cssSelector("img");
    private By shoppingCartRows = By.xpath("//div[@id='content']//div[contains(@class, 'table-responsive')]//tr");

    private WebElement productRow;

    public ShoppingCartPage(WebDriver _driver){
        super(_driver);
    }
    public boolean isProductNameDisplayed(String name){
      return driver.findElement(By.xpath(ProductNameLocator.replace("<name>",name))).isDisplayed();
    }

    public int getProductQuantity(){
       return Integer.parseInt(driver.findElement(ProductQuantityLocator).getAttribute("name"));
    }

    public boolean isProductRowDisplayed(String name){
        this.productRow =
                driver.findElement(
                        By.xpath(ProductRowLocator.replace("<name>", name)));
        return this.productRow.isDisplayed();
    }

    public int getProductRowQuantity(){
        String sAmount = productRow.findElement(inputRowSelector)
                .getAttribute("value");
        return Integer.parseInt(sAmount);
    }
    public String getProductImageURL(){
        String imageURL = productRow.findElement(imageSelector)
                .getAttribute("src");
        return imageURL;
    }

    public int getAmountOfShoppingCartRows(){
        return driver.findElements(shoppingCartRows).size() - 1;
    }

    public void clickShoppingCart(){driver.findElement(shoppingCartInText).click();}

    public boolean messageProductNotAvailable(){
        return driver.findElement(productNotAvailable).isDisplayed();
    }

}
