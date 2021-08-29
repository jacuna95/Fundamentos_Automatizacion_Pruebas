package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver _driver) {
        super(_driver);
    }

    private By searchInputLocator = By.name("search");

    public void fillSearchBar(String searchCriteria) {
        driver.findElement(searchInputLocator).sendKeys(searchCriteria, Keys.ENTER);

    }

    public int getResultsByCssClass(String classId) {
        return driver.findElements(By.cssSelector(classId)).size();

    }


}
