import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod //AfterMethod//
    public void beforeMethod(@Optional("chrome") String browser) {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        if (browser.equals("firefox"))
            driver = new FirefoxDriver();
        else
            driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void afterMethod() {
        TakeScreenshot(driver);

        driver.close();
        try {
            driver.quit();
        } catch (WebDriverException ex) {
            System.out.println("El browser ya se había cerrado");
        }

    }

}
