package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By submitButton = By.xpath("//div[@id='content']/div/div[2]/div/form/input");

    public LoginPage(WebDriver _driver) {
        super (_driver);

    }

    public void EnterEmail(String email) {
        this.driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void EnterPassword(String password) {
        this.driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickSubmitButton() {
        this.driver.findElement(submitButton).click();

    }

    public void login(String username, String password) {
        this.driver.findElement(emailInputLocator).sendKeys(username);
        this.driver.findElement(passwordInputLocator).sendKeys(password);
        this.driver.findElement(submitButton).click();
    }

    public void goTo() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
    }


}
