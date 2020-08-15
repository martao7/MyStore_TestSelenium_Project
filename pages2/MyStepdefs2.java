package pages2;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class MyStepdefs2 {
    private WebDriver driver;

    @Given("^User is logged in to MyStore Website$")
    public void user_is_logged_in_to_MyStore_Website() {
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.loginAs( "yhpzhgytlxpdccugle@awdrt.com", "pass123");
    }

    @When("^User goes choose a keyword \"(.*)\"$")
    public void userGoesChooseAKeyword(String keyword)  {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("s"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
    }
    @And("^User chooses five of Hummingbird Printed Sweater in size M$")
    public void userChoosesFiveOfHummingbirdPrintedSweaterInSizeM() {

        driver.get ("https://prod-kurs.coderslab.pl/index.php?controller=search&s=Hummingbird+Printed+Sweater");

        WebElement sweaterInput = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a"));
        sweaterInput.click();

        driver.get("https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s");

        SizeM5Page sizeM5Page = new SizeM5Page(driver);
        sizeM5Page.addProduct();
    }

    @And("^User adds this product to his order$")
    public void userAddsThisProductToHisOrder() {

        driver.get("https://prod-kurs.coderslab.pl/index.php?id_product=2&id_product_attribute=10&rewrite=brown-bear-printed-sweater&controller=product#/2-size-m");
    }

    @And("^goes to checkout option$")
    public void goesToCheckoutOption() {

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.proceedToCheckout();
    }

    @And("^gives his address$")
    public void givesHisAddress() {

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=order");

        ChooseAddressPage chooseAddressPage = new ChooseAddressPage(driver);
        chooseAddressPage.addAddress();
    }

    @And("^chooses -pick up in store- way$")
    public void choosesPickUpInStoreWay() {

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=order");

        PickUpPage pickUpPage = new PickUpPage(driver);
        pickUpPage.pickUpInStore();
    }

    @And("^chooses obligation to pay with Pay by Check$")
    public void choosesObligationToPayWithPayByCheck() {

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=order");

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.payByCheck();
    }

    @Then("^Order successfully added and paid$")
    public void orderSuccessfullyAddedAndPaid() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=order-confirmation&id_cart=22412&id_module=11&id_order=2610&key=6ebac167f2148b0616917489b08f1961");
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=order-confirmation&id_cart=22412&id_module=11&id_order=2610&key=6ebac167f2148b0616917489b08f1961");

        ScreenshotPage screenshotPage = new ScreenshotPage(driver);
        screenshotPage.getUpdateInformation();
    }

}
