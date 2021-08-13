
import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testAccount extends BaseClass {

    @Description("Validate test login was successfull")
    @Test
    public void test_Login() {
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "jose.acuna.sanchez@ucreativa.com";
        String password = "123ja";

        //login page

        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();

        // Datos

        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.clickSubmitButton();


        WebElement logOutButtom = driver.findElement(By.xpath("//*[@id='column-right']/div/a[13]"));
        Assert.assertTrue(logOutButtom.isDisplayed());


    }

    @Description("Validate that the login is working with non validad credentials")
    @Test
    public void Test_Login_Unsuccessful() {

        LoginPage loginPage = new LoginPage(driver);
        String username = "jacuna";
        String password = "12345";
        String expectedMessage = "warning: your account has exceeded allowed number of login attempts. please try again in 1 hour.";

        //login page
        loginPage.goTo();

        // Datos
        loginPage.login(username,password);

        WebElement alertMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());

    }

    @Test
    public void Test_Create_New_Account(){
        //SETUP VARIABLES Y DEMÁS
        String firstname = "Nacho";
        String lastname = "Acuña";
        String email = "jacuna@sanchez.com";
        String telephone = "12121212";
        String password = "Clase6";
        String expectedMessage = "Your Account Has Been Created!";
        RegisterPage registerPage = new RegisterPage(driver);

        //RUN
        registerPage.goTo();
        registerPage.FillForm(firstname,lastname,email,telephone,password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetConfirmationMessage(),expectedMessage);

    }

}
