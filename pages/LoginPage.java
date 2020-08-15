package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//PageObjekt do zalogowania sie na strone
public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id ="submit-login")
    private WebElement signInButton;

    @FindBy(xpath="//a[@class='account']")
    private WebElement userName;
    //private WebElement userName;

    public void loginAs(String username, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(username);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }
    public String getLoggedUsername() {
        return userName.getText();
    }
}

