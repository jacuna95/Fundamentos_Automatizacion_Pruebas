package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver _driver) {
        super(_driver);
    }

    public String getfirstProductName() {
        return driver.findElement(HomePageLocators.firstProductTitleSelector).getText();
    }

    public void selectProductByName(String name) {
        driver.findElement(By.xpath(HomePageLocators.firstH4Locator.replace("<name>", name))).click();
    }

    public String selectFirstProductAndGetName() {
        String name = getfirstProductName();
        selectProductByName(name);
        return name;
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnYourStoreButton();
    }

}

