package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserInfoPage {
    private static WebDriver driver;

    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "postcode")
    WebElement postcodeInput;

    @FindBy(name = "city")
    WebElement cityInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(id ="submit-login")
    private WebElement signInButton;

    @FindBy(xpath="//a[@class='account']")
    private WebElement userName;

    @FindBy(css = ".btn.btn-primary.form-control-submit")
    WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    @FindBy(name ="id_country")
    private WebElement country;


    public void setAlias(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void setAddress(String address) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPostcode(String postcode) {
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
    }

    public void setCity(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setPhone(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void setCountry() {
        //Select countrySelectElement = new Select(countrySelectElement);
        //countrySelect.selectByVisibleText("QA");
        if (!country.isSelected())
            country.click();
    }

    public static String getUpdateInformation() {
        WebElement successInformation = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div"));
        return successInformation.getText();
    }
}

