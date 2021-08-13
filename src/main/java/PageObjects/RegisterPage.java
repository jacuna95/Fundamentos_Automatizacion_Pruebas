package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    //Elements

    private By NameLocator = By.name("firstname");
    private By LastNameLocator = By.name("lastname");
    private By EmailLocator = By.name("email");
    private By TelLocator = By.name("telephone");
    private By PasswordLocator = By.name("password");
    private By ConfirmLocator = By.name("confirm");
    private By ConfirmRegisterMessageLocator = By.xpath("//div[@id='content']/h1");
    private By TermsCheckBoxLocator = By.name("agree");
    private By ContinueButtonLocator = By.xpath("//*[@id='content']/form/div/div/input[2]");

    public RegisterPage (WebDriver _driver){
        this.driver = _driver;
    }
    public void goTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();

    }

    public void FillForm(String firstname, String lastname, String email,String telephone,String password){
        driver.findElement(NameLocator).sendKeys(firstname);
        driver.findElement(LastNameLocator).sendKeys(lastname);
        driver.findElement(EmailLocator).sendKeys(email);
        driver.findElement(TelLocator).sendKeys(telephone);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(ConfirmLocator).sendKeys(password);
        driver.findElement(TermsCheckBoxLocator).click();
        driver.findElement(ContinueButtonLocator).click();

    }

    public String GetConfirmationMessage(){return driver.findElement(ConfirmRegisterMessageLocator).getText();
    }
}
