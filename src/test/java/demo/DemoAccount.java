package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount {

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }
    @Ignore
    @Test
    public void test_capabilities(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1200,800");
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());

      //driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");

     // driver.manage().window().maximize();
    }

    @Test
    public void test_waits() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.xpath("//*[@id=\"downloadButton\"]")).click();

        boolean result = false;
        try {
            result = wait.until(
                    ExpectedConditions.textToBe(By.className("progress-label"),"complete!"));

        }
        catch (WebDriverException exception){
            System.out.println("No funcionó");
        }
    }
}
