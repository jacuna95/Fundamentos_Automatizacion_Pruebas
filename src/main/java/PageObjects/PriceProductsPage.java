package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceProductsPage extends BasePage {


    /*SelectoresProductos*/
    private By firstProductSelector = By.xpath("//*[@id='content']/div[2]/div[1]/div/div[2]/h4/a");
    private By secondProductSelector = By.xpath("//*[@id='content']/div[2]/div[2]/div/div[2]/h4/a");
    private By thirdProductSelector = By.xpath("//*[@id='content']/div[2]/div/div/div[2]/div[1]/h4/a");

    private By searchTabletsSelector = By.xpath("//*[@id='menu']/div[2]/ul/li[4]/a");

    /*currency*/
    private By currencyButtom = By.xpath("//*[@id='form-currency']/div/button/i");
    private By euroButtom = By.xpath("//*[@id='form-currency']/div/ul/li[1]/button");
    private By dolarsButtom = By.xpath("//*[@id='form-currency']/div/ul/li[3]/button");
    private By poundsButtom = By.xpath("//*[@id='form-currency']/div/ul/li[2]/button");


    private By price = By.xpath("//*[@id='content']/div/div[2]/ul[2]/li[1]/h2");

    public String priceReturn() {
        return driver.findElement(price).getText();
    }


    public PriceProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMyFirstProduct() {
        driver.findElement(firstProductSelector).click();
    }

    public void clickOnMySecondProduct() {
        driver.findElement(secondProductSelector).click();
    }

    public void clickOnMyThirdProduct() {
        driver.findElement(searchTabletsSelector).click();
        driver.findElement(thirdProductSelector).click();
    }

    public void clickOnCurrency() {
        driver.findElement(currencyButtom).click();
    }

    public void clickOnEuro() {
        driver.findElement(euroButtom).click();
    }

    public void clickOnDolar() {
        driver.findElement(dolarsButtom).click();
    }

    public void clickOnPounds() {
        driver.findElement(poundsButtom).click();
    }


}

