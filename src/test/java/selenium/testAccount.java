package selenium;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import PageObjects.Utils;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;


public class testAccount extends BaseClass {
    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: your account has exceeded allowed number of login attempts. please try again in 1 hour.";

    public By logOutButtonLocator = By.xpath("//*[@id='column-right']/div/a[13]");
    public By alertMessageLocator = By.xpath("//*[@id='account-login']/div[1]");

    @Description("Validate test login was successfull")
    @Test
    public void test_Login() {

        String username = "jose.acuna.sanchez@ucreativa.com";
        String password = "123ja";
        //login page
        headerPage().clickOnMyAccount();
        headerPage().clickOnLoginButton();
        // Datos
        loginPage().EnterEmail(username);
        loginPage().EnterPassword(password);
        loginPage().clickSubmitButton();

        WebElement logOutButtom = driver.findElement(logOutButtonLocator);
        Assert.assertTrue(logOutButtom.isDisplayed());
    }

    @Description("Validate that the login is working with non validad credentials")
    @Test
    public void Test_Login_Unsuccessful() {
        String username = "jacuna";
        String password = "12345";
        String expectedMessage = "warning: your account has exceeded allowed number of login attempts. please try again in 1 hour.";
        //login page
        loginPage().goTo();
        // Datos
        loginPage().login(username, password);

        WebElement alertMessage = driver.findElement(alertMessageLocator);
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }


    @Test(dataProvider = "getUsersData", dataProviderClass = UsersProvider.class)
    public void Test_Login_With_Data(UserAccount testUser) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goTo();
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        if (testUser.ValidAccount())
            Assert.assertTrue(driver.findElement(logOutButtonLocator).isDisplayed());
        else
            Assert.assertEquals(ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE.toLowerCase(), driver.findElement(alertMessageLocator).getText().toLowerCase().trim());
    }

    @Test
    public void Test_Create_New_Account() {
        //SETUP VARIABLES Y DEMÁS
        String firstname = "Nacho";
        String lastname = "Acuña";
        String email = Utils.generateRandomEmails();
        String telephone = "12121212";
        String password = "Clase6";
        String expectedMessage = "Your Account Has Been Created!";
        //RUN
        registerPage().goTo();
        registerPage().FillForm(firstname, lastname, email, telephone, password);
        //VALIDATION
        Assert.assertEquals(registerPage().GetConfirmationMessage(), expectedMessage);
    }

    @Test
    public void Test_Duplicated_Email() {
        String firstname = "Nacho";
        String lastname = "Acuña";
        String email = "jacuna@sanchez.com";
        String telephone = "12121212";
        String password = "Clase6";
        String expectedMessage = "Warning: E-Mail Address is already registered!";

        registerPage().goTo();
        registerPage().FillForm(firstname, lastname, email, telephone, password);

        Assert.assertEquals(registerPage().getAlertMessageEmailInUse(), expectedMessage);

    }
}
