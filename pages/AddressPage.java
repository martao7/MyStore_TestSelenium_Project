package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AddressPage {
    private static WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //String alias, String address,  String city, String zip, String phone, country

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement userName;
    //private WebElement userName;

    @FindBy(name = "id_country")
    private WebElement countryInput;


    public static void addAddress(String alias, String address, String city, String zip, String phone, String country) {

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(zip);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement countryInput = driver.findElement(By.name("id_country"));
        Select countrySelect = new Select(countryInput);
        countrySelect.selectByValue(country);
        countryInput.click();
    }

    public static void submitUserInfo() {

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        signInButton.click();
    }

    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }

}


/*
MyStoreAddAddress
Feature: MyStore - Add user new address after login

Napisz skrypt, który:

będzie logować się na tego stworzonego użytkownika,

wejdzie klikając w kafelek Addresses po zalogowaniu
(adres, na którym powinniśmy się znaleźć to:
https://prod-kurs.coderslab.pl/index.php?controller=addresses ),

kliknie w + Create new address,

wypełni formularz New address - dane powinny być
pobierane z tabeli Examples w Gherkinie
(alias, address, city, zip/postal code/country/phone),

sprawdzi czy dane w dodanym adresie są poprawne.


 */