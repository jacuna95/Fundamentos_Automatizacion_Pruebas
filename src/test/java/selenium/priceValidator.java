package selenium;

import PageObjects.BaseClass;
import PageObjects.PriceProductsPage;
import dataProviders.PriceProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ProductsPrice;

public class priceValidator extends BaseClass {

    @Test(dataProvider = "getSearchPriceFromJson", dataProviderClass = PriceProvider.class)
    public void Test_Validate_Price(ProductsPrice testData) {
        PriceProductsPage priceProductsPage = new PriceProductsPage(driver);

        if (testData.getNameProduct().equals("macbook")) {
            priceProductsPage.clickOnMyFirstProduct();
        }
        if (testData.getNameProduct().equals("iphone")) {
            priceProductsPage.clickOnMySecondProduct();
        }
        if (testData.getNameProduct().equals("Samsung Galaxy Tab 10.1")) {
            priceProductsPage.clickOnMyThirdProduct();
        }
        priceProductsPage.clickOnCurrency();
        priceProductsPage.clickOnDolar();
        Assert.assertEquals(priceProductsPage.priceReturn(), testData.getPriceDolars());
        priceProductsPage.clickOnCurrency();
        priceProductsPage.clickOnEuro();
        Assert.assertEquals(priceProductsPage.priceReturn(), testData.getPriceEuro());
        priceProductsPage.clickOnCurrency();
        priceProductsPage.clickOnPounds();
        Assert.assertEquals(priceProductsPage.priceReturn(), testData.getPricePounds());
    }
}
