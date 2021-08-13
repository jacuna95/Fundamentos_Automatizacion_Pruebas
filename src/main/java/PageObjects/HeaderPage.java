package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

    private WebDriver driver;

    //Elementos de la Página
    private By myAccountLinkLocator = By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]");
    private By LoginButtonLocator = By.xpath("//div[@id='top-links']/ul/li[2]/ul/li[2]/a");
    private By registerButtonLocator = By.linkText("Register");

    public HeaderPage(WebDriver _driver) {
        this.driver = _driver;

    }

    public void clickOnMyAccount() {
        driver.findElement(myAccountLinkLocator).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(LoginButtonLocator).click();
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButtonLocator).click();
    }
}
