package selenium;

import PageObjects.BaseClass;
import PageObjects.SearchPage;
import PageObjects.SearchResultsPage;
import dataProviders.SearchProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;

public class TestSearch extends BaseClass {
    @Test
    @Parameters({"searchCriteria", "expectedResults"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResults) {
        SearchPage searchPage = new SearchPage(driver);
        int results = Integer.parseInt(expectedResults);

        searchPage.fillSearchBar(searchCriteria);

        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + searchCriteria));

        Assert.assertEquals(searchPage.getResultsByCssClass(".product-thumb"), results, "Expecting" + expectedResults + "results, but got" +
                searchPage.getResultsByCssClass(".product-thumb"));
    }

    @Test
    public void Empty_Results() {
        SearchPage searchPage = new SearchPage(driver);
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        searchPage.fillSearchBar(searchCriteria);

        Assert.assertEquals(searchPage.getResultsByCssClass(".product-thumb"), expectedResult, "Expecting" + expectedResult + "results, but got" +
                searchPage.getResultsByCssClass(".product-thumb"));
    }

    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_With_Data(SearchData testData) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());

        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        if (testData.getExpectedResults() > 0) {
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getExpectedResults());
        } else {
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());
        }
    }

}
