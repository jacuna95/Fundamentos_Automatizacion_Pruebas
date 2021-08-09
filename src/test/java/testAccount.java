
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testAccount extends BaseClass {

    @Description("Validate test login was successfull")
    @Test
    public void test_Login() {

        String username = "jose.acuna.sanchez@ucreativa.com";
        String password = "123ja";

        //login page

        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();

        // Datos

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/input")).click();

        WebElement logOutButtom = driver.findElement(By.xpath("//*[@id='column-right']/div/a[13]"));
        Assert.assertTrue(logOutButtom.isDisplayed());


    }

    @Description("Validate that the login is working with non validad credentials")
    @Test
    public void Test_Login_Unsuccessful() {

        String username = "jacuna";
        String password = "12345";
        String expectedMessage = "warning: your account has exceeded allowed number of login attempts. please try again in 1 hour.";

        //login page

        driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();

        // Datos

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/form/input")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//*[@id='account-login']/div[1]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());

    }

}
