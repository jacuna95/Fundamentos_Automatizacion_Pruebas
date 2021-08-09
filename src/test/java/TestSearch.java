import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BaseClass{
   @Test
   @Parameters({"searchCriteria","expectedResults"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResults){

        int results = Integer.parseInt(expectedResults);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        //Assert.assertEquals(results.size(),expectedResult,
          //      String.format("Expected %s results,but got %s",expectedResult,results.size()));

       Assert.assertEquals(getResults(),results,"Expecting" + expectedResults + "results, but got"+
                getResults());
    }

    @Test
    public void Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult =0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);
        Assert.assertEquals(getResults(),expectedResult,"Expecting" + expectedResult + "results, but got"+
                getResults());
    }

    public int getResults(){
       return driver.findElements(By.cssSelector("product-thumb")).size();

    }

}
