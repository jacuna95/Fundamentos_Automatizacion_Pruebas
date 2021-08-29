package selenium;

import PageObjects.BaseClass;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import PageObjects.ShoppingCartPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality() {

        int quantity = 5;

        String imageURL = "macbook_1-47x47.jpg";
        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().setQuantity(quantity);
        productPage().clickAddButton();
        headerPage().clickOnShoppingCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(), quantity, "Quantity is not matching");
        Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");
    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart() {
        homePage().selectProductByName("MacBook");
        productPage().setQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().setQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnShoppingCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }
    @Description("Validate that add to cart is working using the search stick (project item 2)")
    @Test
    public void Test_Add_To_Cart_Functionality_2_Method() {
        ProductPage productPage = new ProductPage(driver);
        String search = "macBook Pro";

        productPage.fillSearch(search);
        productPage.clickNameProduct();
        productPage.clickAddButton();
        productPage.isAlertSuccessDisplayed();
        shoppingCartPage().clickShoppingCart();
        shoppingCartPage().messageProductNotAvailable();
    }
 }
