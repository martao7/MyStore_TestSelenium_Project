package pages;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs1 {
    private WebDriver driver;

    @Given("^User is logged in to MyStore Website$")
    public void userIsLoggedInToMyStoreWebsite() {
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.loginAs("yhpzhgytlxpdccugle@awdrt.com", "pass123");
    }

    @When("^User goes to user address page$")
    public void userGoesToUserAddressPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @And("^User adds his address data alias \"(.*)\", address \"(.*)\", city \"(.*)\", postal code \"(.*)\", phone \"(.*)\", country$")
    //@And("^User adds his address data alias \"([^\"]*)\", address \"([^\"]*)\", city \"([^\"]*)\", postal code \"([^\"]*)\", phone \"([^\"]*)\">$")
    public void userAddsHisAddressDataAliasAddressCityPostalCodePhoneCountry(String alias, String address, String city, String postalCode, String phone) throws Throwable {
        AddressPage AddressPage = new AddressPage(driver);
        AddressPage.addAddress(alias, address, city, postalCode, phone, "17");

    }

    @And("^User saves info$")
    public void userSavesInfo() {
        AddressPage.submitUserInfo();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
    }


    @Then("^Address successfully added \"([^\"]*)\", address \"([^\"]*)\", city \"([^\"]*)\", postal code \"([^\"]*)\", phone \"([^\"]*)\", country$")
    public void addressSuccessfullyAddedAddressCityPostalCodePhoneCountry(String arg0, String arg1, String arg2, String arg3, String arg4 ) throws Throwable {

        List<WebElement> addresses = driver.findElements(By.className("address"));
        //System.out.println("Number of addresses:" + addresses.size());

        System.out.println(addresses.size() - 1);
        WebElement lastAddress = addresses.get(addresses.size() - 1);
        String actualAddress = lastAddress.getText();
        System.out.println("Your address: ");
        System.out.println(actualAddress);
        System.out.println("Check your address: \n" + arg0 + " \n" + "Anna Nowak \n" + arg1 + " \n" + arg2 + " \n" + arg3 + " \n" + "United Kingdom\n" + arg4 + " ");

    }
}

